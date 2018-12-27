package cn.PApudding.Beans.WebBeans;

/**
 * 模板和控件绑定实体
 * 
 * @author PApudding
 *
 */
public class WebTemplateToModelBindEntity {
	private int id;
	private String modelName;
	private String modelStyleValue;

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

	public String getModelStyleValue() {
		return modelStyleValue;
	}

	public void setModelStyleValue(String modelStyleValue) {
		this.modelStyleValue = modelStyleValue;
	}
}
