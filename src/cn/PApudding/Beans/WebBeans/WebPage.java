package cn.PApudding.Beans.WebBeans;

import java.util.HashSet;
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
	private Set<WebPageToModelBindEntity> webPageToModelBindEntities = new HashSet<WebPageToModelBindEntity>(); // ҳ���ģ������ݿ�ӳ��ʵ��

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

	public Set<WebPageToModelBindEntity> getWebPageToModelBindEntities() {
		return webPageToModelBindEntities;
	}

	public void setWebPageToModelBindEntities(Set<WebPageToModelBindEntity> webPageToModelBindEntities) {
		this.webPageToModelBindEntities = webPageToModelBindEntities;
	}

	

	

}
