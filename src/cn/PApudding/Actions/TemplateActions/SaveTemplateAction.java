package cn.PApudding.Actions.TemplateActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/*
class WebTemplate
	int id; // id
	String templateName; // 模板的名称
	String templateType; // 模板的类型
	String templateFileCode; // 模板的整体代码
*/
/**
 * 请求“保存创建的模板页面”时的Action
 * 
 * @author PApudding
 *
 */
public class SaveTemplateAction extends ActionSupport {
	private WebTemplate webTemplate;

	public WebTemplate getWebTemplate() {
		return webTemplate;
	}

	public void setWebTemplate(WebTemplate webTemplate) {
		this.webTemplate = webTemplate;
	}

	@Override
	public String execute() throws Exception {
		// 将模板保存到数据库中
		HibernateUtils.saveObject(webTemplate);
		return SUCCESS;
	}
}
