package cn.PApudding.Beans;

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
	private Set<String> pageModelNames; // 页面中含有的绑定了数据源的模块名字

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
