package cn.PApudding.Beans.WebBeans;

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
	private String templateFileCode; // ģ����������
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
