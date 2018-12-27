package cn.PApudding.Actions.ContentManageActions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;
/**
 * 进入新建数据请求的action
 * @author PApudding
 *
 */
public class EnterCreateDataAction extends ActionSupport{
	private String databaseName;
	
	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	@Override
		public String execute() throws Exception {
		//从数据库中获取全部的数据源名称（作用域）
		Map<String, List<String>> fieldsContainer = HibernateUtils.getAllFields();
		List<String> webEssayFields = fieldsContainer.get("webEssayFields");
		List<String> webLinkFields = fieldsContainer.get("webLinkFields");
		List<String> webMediaSourceFields = fieldsContainer.get("webMediaSourceFields");
		//得到HTTP请求对象
		HttpServletRequest request = ServletActionContext.getRequest();
		//将得到的数据源分类填充到请求对象中
		request.setAttribute("webEssayFields", webEssayFields);
		request.setAttribute("webLinkFields", webLinkFields);
		request.setAttribute("webMediaSourceFields", webMediaSourceFields);
		request.setAttribute("databaseName",databaseName);
		
		return SUCCESS;
		}
}
