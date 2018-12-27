package cn.PApudding.Actions.TemplateActions;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Beans.WebBeans.WebTemplateToModelBindEntity;
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
	private String templateName; // ģ�������
	private String templateType; // ģ�������
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	@Override
	public String execute() throws Exception {
		// ��ȡHttp�������
		HttpServletRequest request = ServletActionContext.getRequest();
		// ��ȡ��������е�ȫ����
		Enumeration<String> moduleNames = request.getParameterNames();
		// ��������
		WebTemplate webTemplate = new WebTemplate();
		Set<WebTemplateToModelBindEntity> bindEntitySet = new HashSet<WebTemplateToModelBindEntity>();
		WebTemplateToModelBindEntity bindEntity;

		// ѭ�������õ��ļ�����ȡ��Ӧֵ
		while (moduleNames.hasMoreElements()) {
			String moduleName = (String) moduleNames.nextElement();
			// �������Ϊģ������ֺ�����
			if (!moduleName.equals("templateName")) {
				if (!moduleName.equals("templateType")) {
					bindEntity = new WebTemplateToModelBindEntity();
					bindEntity.setModelName(moduleName);
					String styleValue = request.getParameter(moduleName);
					bindEntity.setModelStyleValue(styleValue);
					bindEntitySet.add(bindEntity);
				}
			}
		}

		// ���webTemplate��Set�ֶ�
		webTemplate.setTemplateToModelBindEntities(bindEntitySet);
		webTemplate.setTemplateName(templateName);
		webTemplate.setTemplateType(templateType);
		// �洢�������ݿ���
		Set<Object> ocToStore = new HashSet<Object>();
		for (Object objects : bindEntitySet) {
			ocToStore.add(objects);
		}
		ocToStore.add(webTemplate);
		HibernateUtils.saveObjects(ocToStore);
		return SUCCESS;
	}
}
