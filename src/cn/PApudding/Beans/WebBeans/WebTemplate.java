package cn.PApudding.Beans.WebBeans;

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
	private String templateFileCode; // 模板的整体代码
	//private String 

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

	public String getTemplateFileCode() {
		return templateFileCode;
	}

	public void setTemplateFileCode(String templateFileCode) {
		this.templateFileCode = templateFileCode;
	}

}
