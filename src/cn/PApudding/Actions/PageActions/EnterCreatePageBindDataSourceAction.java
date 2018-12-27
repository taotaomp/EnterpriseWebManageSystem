package cn.PApudding.Actions.PageActions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ������Դ�������action
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
		// �õ�HTTP�������
		HttpServletRequest request = ServletActionContext.getRequest();

		// �����ݿ��л�ȡȫ��������Դ���ƣ�������
		Map<String, List<String>> fieldsContainer = HibernateUtils.getAllFields();
		List<String> webEssayFields = fieldsContainer.get("webEssayFields");
		List<String> webLinkFields = fieldsContainer.get("webLinkFields");
		List<String> webMediaSourceFields = fieldsContainer.get("webMediaSourceFields");
		// ���õ�������Դ������䵽���������
		request.setAttribute("webEssayFields", webEssayFields);
		request.setAttribute("webLinkFields", webLinkFields);
		request.setAttribute("webMediaSourceFields", webMediaSourceFields);

		// �����ݿ��л�ȡѡ����ģ��
		WebTemplate webTemplate = (WebTemplate) HibernateUtils
				.getSingleObjectBySql("FROM WebTemplate WHERE id = '" + id + "'");
		// ���õ���ģ������������
		request.setAttribute("webTemplate", webTemplate);
		return SUCCESS;
	}
}
