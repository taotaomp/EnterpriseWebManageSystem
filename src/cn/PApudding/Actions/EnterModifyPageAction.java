package cn.PApudding.Actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
/*
class WebPage 
	private int id; // id
	private String pageName; // 页面的名字
	private String pageFileCode; // 页面的整体代码
	private Set<String> pageModelNames; // 页面中含有的绑定了数据源的模块名字（以*分隔）

*/

/**
 * 进入“修改页面”页面请求的Action
 * 
 * @author PApudding
 *
 */
public class EnterModifyPageAction extends ActionSupport {
	private String queryPageName; // 即将修改的WebPage名

	@Override
	public String execute() throws Exception {
		// 从数据库中获取WebPage
		WebPage webPage = (WebPage) HibernateUtils
				.getSingleObjectBySql("FORM WebPage WHERE pageName = " + queryPageName);
		ServletActionContext.getRequest().setAttribute("WebPage", webPage);
		return SUCCESS;
	}
}
