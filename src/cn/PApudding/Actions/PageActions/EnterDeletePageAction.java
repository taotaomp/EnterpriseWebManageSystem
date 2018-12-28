package cn.PApudding.Actions.PageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
/*
class WebPage 
	private int id; // id
	private String pageName; // 页面的名字
	private String pageFileCode; // 页面的整体代码
	private Set<String> pageModelNames; // 页面中含有的绑定了数据源的模块名字（以*分隔）

*/

/**
 * 进入“删除页面”页面请求的Action
 * 
 * @author PApudding
 *
 */
public class EnterDeletePageAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// 从数据库中获取WebPage
		List<Object> webPageList = HibernateUtils.getAllObjects("WebPage");
		ServletActionContext.getRequest().setAttribute("pages", webPageList);
		return SUCCESS;
	}
}
