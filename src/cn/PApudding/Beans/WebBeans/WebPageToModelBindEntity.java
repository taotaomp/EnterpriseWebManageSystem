package cn.PApudding.Beans.WebBeans;

/**
 * 页面和模块的数据库映射实体，用于动态页面的生成 一个页面与此实体构成一对多的关系
 * 
 * @author PApudding
 *
 */
public class WebPageToModelBindEntity {
	private int id; // id
	private int modelRandomNumber; // 随机数，用做页面内资源获取定位
	private String dataTableName; // 数据库名
	private String dataSourceField; // 数据源名（数据库作用域）
	private WebPage webPage; // 页面

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModelRandomNumber() {
		return modelRandomNumber;
	}

	public void setModelRandomNumber(int modelRandomNumber) {
		this.modelRandomNumber = modelRandomNumber;
	}

	public String getDataTableName() {
		return dataTableName;
	}

	public void setDataTableName(String dataTableName) {
		this.dataTableName = dataTableName;
	}

	public String getDataSourceField() {
		return dataSourceField;
	}

	public void setDataSourceField(String dataSourceField) {
		this.dataSourceField = dataSourceField;
	}

	public WebPage getWebPage() {
		return webPage;
	}

	public void setWebPage(WebPage webPage) {
		this.webPage = webPage;
	}
}
