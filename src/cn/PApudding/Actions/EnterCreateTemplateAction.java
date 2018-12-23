package cn.PApudding.Actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.PApudding.Dao.HibernateUtils;
/* WebModel
	 int id; // id
	 String modelName; // 控件名称
	 String modelType; // 控件类型
	 String modelHtmlCode; // 控件的html代码
	 String modeCssCode; // 控件的css样式
	 String modelJs; // 控件的Javascript代码
*/

/**
 * 请求“创建模板页面”时的Action
 * 
 * @author PApudding
 *
 */
public class EnterCreateTemplateAction extends ActionSupport {

	List<Object> listAllModelContainer;

	@Override
	public String execute() throws Exception {
		// 从数据库中读取所有的部件
		listAllModelContainer = HibernateUtils.getAllObjects("WebModel");
		// 将所有部件的部件放入Request请求中，方便JSP接收
		ServletActionContext.getRequest().setAttribute("listAllModelContainer", listAllModelContainer);

		return SUCCESS;
	}
}
