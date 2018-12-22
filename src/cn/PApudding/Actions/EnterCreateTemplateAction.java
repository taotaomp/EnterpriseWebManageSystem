package cn.PApudding.Actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.PApudding.Dao.HibernateUtils;

public class EnterCreateTemplateAction extends ActionSupport {

	List<Object> listAllModelContainer;
	
	@Override
	public String execute() throws Exception {
		listAllModelContainer = HibernateUtils.getAllObjects("WebModel");
		ServletActionContext.getRequest().setAttribute("listAllModelContainer",listAllModelContainer);
	
		return SUCCESS;
	}
}
