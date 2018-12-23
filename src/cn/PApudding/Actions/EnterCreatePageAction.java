package cn.PApudding.Actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * ���롰����ҳ�桱ҳ�������Action
 * 
 * @author PApudding
 *
 */
public class EnterCreatePageAction extends ActionSupport {
	private List<Object> listAllTemplateContainer;

	@Override
	public String execute() throws Exception {
		listAllTemplateContainer = HibernateUtils.getAllObjects("WebTemplate");
		ServletActionContext.getRequest().setAttribute("listAllTemplateContainer", listAllTemplateContainer);
		return SUCCESS;
	}
}
