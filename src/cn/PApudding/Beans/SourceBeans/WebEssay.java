package cn.PApudding.Beans.SourceBeans;

/**
 * 网页文章实体
 * 
 * @author PApudding
 *
 */
public class WebEssay {
	private int id; // id
	private String essayTitle; // 文章标题
	private String essayContent; // 文章内容
	private String essayField; // 文章作用域

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEssayTitle() {
		return essayTitle;
	}

	public void setEssayTitle(String essayTitle) {
		this.essayTitle = essayTitle;
	}

	public String getEssayContent() {
		return essayContent;
	}

	public void setEssayContent(String essayContent) {
		this.essayContent = essayContent;
	}

	public String getEssayField() {
		return essayField;
	}

	public void setEssayField(String essayField) {
		this.essayField = essayField;
	}
}
