package cn.PApudding.Actions.PageActions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 绑定数据源的请求的action
 * 
 * @author PApudding
 *
 */
public class EnterCreatePageBindDataSourceAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// 得到HTTP请求对象
		HttpServletRequest request = ServletActionContext.getRequest();

		// 从数据库中获取全部的数据源名称（作用域）
		Map<String, List<String>> fieldsContainer = HibernateUtils.getAllFields();
		List<String> webEssayFields = fieldsContainer.get("webEssayFields");
		List<String> webLinkFields = fieldsContainer.get("webLinkFields");
		List<String> webMediaSourceFields = fieldsContainer.get("webMediaSourceFields");
		// 将得到的数据源分类填充到请求对象中
		request.setAttribute("webEssayFields", webEssayFields);
		request.setAttribute("webLinkFields", webLinkFields);
		request.setAttribute("webMediaSourceFields", webMediaSourceFields);

		// 从数据库中获取选定的模板
		WebTemplate webTemplate = (WebTemplate) HibernateUtils
				.getSingleObjectBySql("FROM WebTemplate WHERE id = '" + id + "'");
		// 将得到的模板放入请求对象
		request.setAttribute("webTemplate", webTemplate);
		return SUCCESS;
	}
}
