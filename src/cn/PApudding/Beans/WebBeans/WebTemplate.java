package cn.PApudding.Beans.WebBeans;

import java.util.HashSet;
import java.util.Set;

/**
 * ģ��ʵ��
 * 
 * @author PApudding
 *
 */
public class WebTemplate {
	private int id; // id
	private String templateName; // ģ�������
	private String templateType; // ģ�������
	private Set<WebTemplateToModelBindEntity> templateToModelBindEntities = new HashSet<WebTemplateToModelBindEntity>(); 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Set<WebTemplateToModelBindEntity> getTemplateToModelBindEntities() {
		return templateToModelBindEntities;
	}

	public void setTemplateToModelBindEntities(Set<WebTemplateToModelBindEntity> templateToModelBindEntities) {
		this.templateToModelBindEntities = templateToModelBindEntities;
	}

}
