package cn.PApudding.Actions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebTemplate;

/**
 * �����޸�ģ��ҳ�桱ʱ��Action
 * 
 * @author PApudding
 *
 */
public class EnterModifyTemplateAcrion extends ActionSupport {
	public WebTemplate webTemplate;

	public WebTemplate getWebTemplate() {
		return webTemplate;
	}

	public void setWebTemplate(WebTemplate webTemplate) {
		this.webTemplate = webTemplate;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
