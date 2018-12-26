package cn.PApudding.Beans.WebBeans;

/**
 * 模板部件（控件）资源实体
 * 
 * @author PApudding
 *
 */
public class WebModel {
	private int id; // id
	private String modelName; // 控件名称
	private String modelType; // 控件类型
	private String modelHtmlCode; // 控件的html代码
	private String modeCssCode; // 控件的css样式
	private String modelJs; // 控件的Javascript代码

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
