package cn.PApudding.Actions.PageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * 进入站点展示界面请求的action
 * @author PApudding
 *
 */
public class EnterSiteShowAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		List<Object> webLinks = HibernateUtils.getObjectsByField("WebLink", "NavBarDefault");
		ServletActionContext.getRequest().setAttribute("webLinks", webLinks);
		return SUCCESS;
	}
}
