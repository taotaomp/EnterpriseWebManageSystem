package cn.PApudding.Beans.WebBeans;

/**
 * ģ�岿�����ؼ�����Դʵ��
 * 
 * @author PApudding
 *
 */
public class WebModel {
	private int id; // id
	private String modelName; // �ؼ�����
	private String modelType; // �ؼ�����
	private String modelHtmlCode; // �ؼ���html����
	private String modeCssCode; // �ؼ���css��ʽ
	private String modelJs; // �ؼ���Javascript����

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}



	public String getModelHtmlCode() {
		return modelHtmlCode;
	}

	public void setModelHtmlCode(String modelHtmlCode) {
		this.modelHtmlCode = modelHtmlCode;
	}

	public String getModeCssCode() {
		return modeCssCode;
	}

	public void setModeCssCode(String modeCssCode) {
		this.modeCssCode = modeCssCode;
	}

	public String getModelJs() {
		return modelJs;
	}

	public void setModelJs(String modelJs) {
		this.modelJs = modelJs;
	}
}
