package cn.PApudding.Actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebPage;
import cn.PApudding.Dao.HibernateUtils;
/*
class WebPage 
	private int id; // id
	private String pageName; // ҳ�������
	private String pageFileCode; // ҳ����������
	private Set<String> pageModelNames; // ҳ���к��еİ�������Դ��ģ�����֣���*�ָ���

*/

/**
 * ���롰�޸�ҳ�桱ҳ�������Action
 * 
 * @author PApudding
 *
 */
public class EnterModifyPageAction extends ActionSupport {
	private String queryPageName; // �����޸ĵ�WebPage��

	@Override
	public String execute() throws Exception {
		// �����ݿ��л�ȡWebPage
		WebPage webPage = (WebPage) HibernateUtils
				.getSingleObjectBySql("FORM WebPage WHERE pageName = " + queryPageName);
		ServletActionContext.getRequest().setAttribute("WebPage", webPage);
		return SUCCESS;
	}
}
