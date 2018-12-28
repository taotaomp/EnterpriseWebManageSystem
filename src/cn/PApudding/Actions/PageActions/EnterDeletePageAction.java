package cn.PApudding.Actions.PageActions;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
/*
class WebPage 
	private int id; // id
	private String pageName; // ҳ�������
	private String pageFileCode; // ҳ����������
	private Set<String> pageModelNames; // ҳ���к��еİ�������Դ��ģ�����֣���*�ָ���

*/

/**
 * ���롰ɾ��ҳ�桱ҳ�������Action
 * 
 * @author PApudding
 *
 */
public class EnterDeletePageAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// �����ݿ��л�ȡWebPage
		List<Object> webPageList = HibernateUtils.getAllObjects("WebPage");
		ServletActionContext.getRequest().setAttribute("pages", webPageList);
		return SUCCESS;
	}
}
