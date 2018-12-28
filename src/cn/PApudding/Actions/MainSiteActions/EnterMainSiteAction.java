package cn.PApudding.Actions.MainSiteActions;

import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
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
		if (pageId != null) {
			WebPage page = (WebPage) HibernateUtils.getSingleObjectBySql("FROM WebPage WHERE id = '" + pageId + "'");
			Set<WebPageToModelBindEntity> modelBindEntities = page.getWebPageToModelBindEntities();
			for (WebPageToModelBindEntity modelbindEntity : modelBindEntities) {
				List<Object> dataList = HibernateUtils.getObjectsByField(modelbindEntity.getDataTableName(),modelbindEntity.getDataSourceField());
				ServletActionContext.getRequest().setAttribute(Integer.toString(modelbindEntity.getModelRandomNumber()),dataList);
			}
			//装载导航栏
			List<Object> NavBarLinks=  HibernateUtils.getObjectsByField("WebLink","NavBarDefault");
			ServletActionContext.getRequest().setAttribute("NavBarDefault",NavBarLinks);
		}

		return SUCCESS;
	}
}
