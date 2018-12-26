package cn.PApudding.Beans.WebBeans;

import java.util.HashSet;
import java.util.Set;

/**
 * 页面实体
 * 
 * @author PApudding
 *
 */
public class WebPage {
	private int id; // id
	private String pageName; // 页面的名字
	private String pageFileCode; // 页面的整体代码
	private Set<WebPageToModelBindEntity> webPageToModelBindEntities = new HashSet<WebPageToModelBindEntity>(); // 页面和模块的数据库映射实体

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
