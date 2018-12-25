package cn.PApudding.Actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * �������ݹ���ҳ���Action
 * 
 * @author PApudding
 *
 */
public class EnterContentManagePageAction extends ActionSupport {
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

		return SUCCESS;
	}
}
