package cn.PApudding.Actions.TemplateActions;

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

	

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
}
