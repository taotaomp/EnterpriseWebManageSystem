package cn.PApudding.Beans.WebBeans;

/**
 * ҳ���ģ������ݿ�ӳ��ʵ�壬���ڶ�̬ҳ������� һ��ҳ�����ʵ�幹��һ�Զ�Ĺ�ϵ
 * 
 * @author PApudding
 *
 */
public class WebPageToModelBindEntity {
	private int id; // id
	private int modelRandomNumber; // �����������ҳ������Դ��ȡ��λ
	private String dataTableName; // ���ݿ���
	private String dataSourceField; // ����Դ�������ݿ�������
	private WebPage webPage; // ҳ��

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
