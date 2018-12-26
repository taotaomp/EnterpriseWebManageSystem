package cn.PApudding.Actions.TemplateActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/*
class WebTemplate
	int id; // id
	String templateName; // ģ�������
	String templateType; // ģ�������
	String templateFileCode; // ģ����������
*/
/**
 * ���󡰱��洴����ģ��ҳ�桱ʱ��Action
 * 
 * @author PApudding
 *
 */
public class SaveTemplateAction extends ActionSupport {
	private WebTemplate webTemplate;

	public WebTemplate getWebTemplate() {
		return webTemplate;
	}

	public void setWebTemplate(WebTemplate webTemplate) {
		this.webTemplate = webTemplate;
	}

	@Override
	public String execute() throws Exception {
		// ��ģ�屣�浽���ݿ���
		HibernateUtils.saveObject(webTemplate);
		return SUCCESS;
	}
}
