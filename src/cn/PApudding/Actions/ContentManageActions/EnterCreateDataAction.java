package cn.PApudding.Actions.ContentManageActions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;
/**
 * �����½����������action
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
		//�����ݿ��л�ȡȫ��������Դ���ƣ�������
		Map<String, List<String>> fieldsContainer = HibernateUtils.getAllFields();
		List<String> webEssayFields = fieldsContainer.get("webEssayFields");
		List<String> webLinkFields = fieldsContainer.get("webLinkFields");
		List<String> webMediaSourceFields = fieldsContainer.get("webMediaSourceFields");
		//�õ�HTTP�������
		HttpServletRequest request = ServletActionContext.getRequest();
		//���õ�������Դ������䵽���������
		request.setAttribute("webEssayFields", webEssayFields);
		request.setAttribute("webLinkFields", webLinkFields);
		request.setAttribute("webMediaSourceFields", webMediaSourceFields);
		request.setAttribute("databaseName",databaseName);
		
		return SUCCESS;
		}
}
