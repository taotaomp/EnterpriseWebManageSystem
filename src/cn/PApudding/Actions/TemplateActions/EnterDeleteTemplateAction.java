package cn.PApudding.Actions.TemplateActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;
/**
 * É¾³ýÄ£°åÇëÇóµÄaction
 * @author PApudding
 *
 */
public class EnterDeleteTemplateAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		List<Object> templates =HibernateUtils.getAllObjects("WebTemplate");
		ServletActionContext.getRequest().setAttribute("templates", templates);
		return SUCCESS;
	}
}
