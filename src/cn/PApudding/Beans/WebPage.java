package cn.PApudding.Beans;

import java.util.Set;

/**
 * ҳ��ʵ��
 * 
 * @author PApudding
 *
 */
public class WebPage {
	private int id; // id
	private String pageName; // ҳ�������
	private String pageFileCode; // ҳ����������
	private Set<String> pageModelNames; // ҳ���к��еİ�������Դ��ģ������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageFileCode() {
		return pageFileCode;
	}

	public void setPageFileCode(String pageFileCode) {
		this.pageFileCode = pageFileCode;
	}

	public Set<String> getPageModelNames() {
		return pageModelNames;
	}

	public void setPageModelNames(Set<String> pageModelNames) {
		this.pageModelNames = pageModelNames;
	}

	

}
