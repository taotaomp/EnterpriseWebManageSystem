package cn.PApudding.Actions.PageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;
/**
 * 进入删除站点界面action
 * @author PApudding
 *
 */
public class EnterSiteDeleteAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		List<Object> webLinks = HibernateUtils.getObjectsByField("WebLink", "NavBarDefault");
		ServletActionContext.getRequest().setAttribute("webLinks", webLinks);
		return SUCCESS;
	}
}
