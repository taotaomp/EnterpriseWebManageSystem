package cn.PApudding.Beans.SourceBeans;

/**
 * ��ҳ����ʵ��
 * 
 * @author PApudding
 *
 */
public class WebEssay {
	private int id; // id
	private String essayTitle; // ���±���
	private String essayContent; // ��������
	private String essayField; // ����������

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
