package cn.PApudding.Actions.PageActions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Dao.HibernateUtils;
import cn.PApudding.SiteGenerator.SiteJspDeleter;

/**
 * 删除站点页面的Action
 * 
 * @author PApudding
 *
 */
public class DeleteSiteAction extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		WebLink webLink = (WebLink) HibernateUtils.getSingleObjectBySql("FROM WebLink WHERE id= '"+id+"'");
		//删除本地文件
		String servletRealPath = ServletActionContext.getServletContext().getRealPath(".");
		SiteJspDeleter.deleteJSP(servletRealPath, webLink.getLinkName());
		HibernateUtils.removeObject(webLink);
		return SUCCESS;
	}
}
