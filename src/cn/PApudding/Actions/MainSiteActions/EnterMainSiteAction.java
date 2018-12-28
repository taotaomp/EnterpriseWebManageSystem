package cn.PApudding.Actions.MainSiteActions;

import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 整个主站的入口Action，负责网站进入请求的映射
 * 
 * @author PApudding
 *
 */
public class EnterMainSiteAction extends ActionSupport {
	private String pageId;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	@Override
	public String execute() throws Exception {
		/*如果页面id为空，则从链接源中寻找名字为index的链接（即主页的链接）
		 * 从链接中获取pageId，填充到此Action类pageId中
		 * */
		if (pageId == null) {
			WebLink link = (WebLink) HibernateUtils.getSingleObjectBySql("FROM WebLink WHERE linkName = 'index'");
			String linkUrl = link.getLinkUrl();
			pageId = linkUrl.split("=")[1];
		}
		//通过pageId获取WebPage对象
		WebPage page = (WebPage) HibernateUtils.getSingleObjectBySql("FROM WebPage WHERE id = '" + pageId + "'");
		/*
		 * 通过WebPage对象获取Set<WebPageToModelBindEntity>(页面模板绑定实体集合)
		 * WebPageToModelBindEntity包含字段：
		 * 				int id; // id
		 *				int modelRandomNumber; // 随机数，用做页面内资源获取定位
	 	 *				String dataTableName; // 数据库名
	 	 *				String dataSourceField; // 数据源名（数据库作用域）
	 	 *				WebPage webPage; // 页面
		 * */
		Set<WebPageToModelBindEntity> modelBindEntities = page.getWebPageToModelBindEntities();
		
		//遍历WebPageToModelBindEntity集合
		for (WebPageToModelBindEntity modelbindEntity : modelBindEntities) {
			/*通过WebPageToModelBindEntity中的数据库名和数据源名获取资源，
			 * 并将资源以WebPageToModelBindEntity中的随机数为名，放入请求对象中
			 * */
			List<Object> dataList = HibernateUtils.getObjectsByField(modelbindEntity.getDataTableName(),
					modelbindEntity.getDataSourceField());
			ServletActionContext.getRequest().setAttribute(Integer.toString(modelbindEntity.getModelRandomNumber()),
					dataList);
		}
		// 装载导航栏
		List<Object> NavBarLinks = HibernateUtils.getObjectsByField("WebLink", "NavBarDefault");
		ServletActionContext.getRequest().setAttribute("NavBarDefault", NavBarLinks);

		return SUCCESS;
	}
}
