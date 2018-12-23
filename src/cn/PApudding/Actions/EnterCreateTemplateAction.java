package cn.PApudding.Actions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import cn.PApudding.Dao.HibernateUtils;
/* WebModel
	 int id; // id
	 String modelName; // �ؼ�����
	 String modelType; // �ؼ�����
	 String modelHtmlCode; // �ؼ���html����
	 String modeCssCode; // �ؼ���css��ʽ
	 String modelJs; // �ؼ���Javascript����
*/

/**
 * ���󡰴���ģ��ҳ�桱ʱ��Action
 * 
 * @author PApudding
 *
 */
public class EnterCreateTemplateAction extends ActionSupport {

	List<Object> listAllModelContainer;

	@Override
	public String execute() throws Exception {
		// �����ݿ��ж�ȡ���еĲ���
		listAllModelContainer = HibernateUtils.getAllObjects("WebModel");
		// �����в����Ĳ�������Request�����У�����JSP����
		ServletActionContext.getRequest().setAttribute("listAllModelContainer", listAllModelContainer);

		return SUCCESS;
	}
}
