package cn.PApudding.Beans;

/**
 * 网页链接实体
 * 
 * @author PApudding
 *
 */
public class WebLink {
	private int id; // id
	private String linkName; // 链接名
	private String linkUrl; // 链接地址
	private String linkField; // 作用域

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
