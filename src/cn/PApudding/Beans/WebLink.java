package cn.PApudding.Beans;

/**
 * ��ҳ����ʵ��
 * 
 * @author PApudding
 *
 */
public class WebLink {
	private int id; // id
	private String linkName; // ������
	private String linkUrl; // ���ӵ�ַ
	private String linkField; // ������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public String getLinkField() {
		return linkField;
	}

	public void setLinkField(String linkField) {
		this.linkField = linkField;
	}

	
}
