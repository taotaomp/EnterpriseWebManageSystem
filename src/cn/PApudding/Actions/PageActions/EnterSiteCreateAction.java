package cn.PApudding.Actions.PageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * 请求“站点管理页面”时的Action
 * @author PApudding
 *
 */
public class EnterSiteCreateAction extends ActionSupport{
	private List<Object> webPages;
	
	@Override
	public String execute() throws Exception {
		webPages = HibernateUtils.getAllObjects("WebPage");
		ServletActionContext.getRequest().setAttribute("webPageList",webPages);
		return SUCCESS;
	}
}
