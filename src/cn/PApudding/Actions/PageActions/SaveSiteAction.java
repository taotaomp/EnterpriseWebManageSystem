package cn.PApudding.Actions.PageActions;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
import cn.PApudding.SiteGenerator.SiteJspGenerator;

/**
 * 请求保存创建的站点时的Action
 * ----------------------------------
 * 功能：
 * 	将创建的站点以.jsp文件的形式，
 *  保存到   %网站根目录路径%/jsps/MainSiteJsp  文件夹下
 * ----------------------------------
 * 注意：
 *  每次在Eclipse中对项目进行重新部署，将会使创建的站点丢失！ 
 *  
 * @author PApudding
 *
 */
public class SaveSiteAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		//获取Http请求对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取项目在服务器文件系统下的真实路径
		String servletRealPath = ServletActionContext.getServletContext().getRealPath(".");
		//获取全部请求的键字段
		Enumeration<String> sitePageNames = request.getParameterNames();
		//建立WebPage对象和WebLink对象引用
		WebPage webPage;
		WebLink webLink; 
		//开始遍历以获取请求键对应的值，键值对内容格式：键：站点页面名 值：数据库中页面名
		while (sitePageNames.hasMoreElements()) {
			//获取当前键
			String sitePageName = (String) sitePageNames.nextElement();
			//获取当前值
			String pageNameInDB = request.getParameter(sitePageName);
			if(pageNameInDB!=null) {
				//跟据获取到的值，从数据库中取得WebPage对象
				webPage = (WebPage) HibernateUtils.getSingleObjectBySql("from WebPage where pageName = '"+pageNameInDB+"'");
				//生成本地的JSP文件
				SiteJspGenerator.generateJSP(servletRealPath, sitePageName, webPage.getPageFileCode());
				
				//建立WebLink对象
				webLink = new WebLink();
				//设置该WebLink对象对应的数据源（作用域）
				webLink.setLinkField("NavBarDefault");
				//设置链接名
				webLink.setLinkName(sitePageName);
				//设置链接指向地址
				webLink.setLinkUrl(ServletActionContext.getRequest().getContextPath()+"/enterMainSite_"+sitePageName+".action?pageId="+webPage.getId());
				//将该WebLink对象保存到数据库中
				HibernateUtils.saveObject(webLink);
			}
		}
		return SUCCESS;
	}
}
