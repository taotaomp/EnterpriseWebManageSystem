package cn.PApudding.Beans.WebBeans;

import java.util.HashSet;
import java.util.Set;

/**
 * 模板实体
 * 
 * @author PApudding
 *
 */
public class WebTemplate {
	private int id; // id
	private String templateName; // 模板的名称
	private String templateType; // 模板的类型
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
