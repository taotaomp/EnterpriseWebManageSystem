package cn.PApudding.Actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * ����վ�����ҳ�桱ʱ��Action
 * @author PApudding
 *
 */
public class EnterSiteManagePageAction extends ActionSupport{
	private List<Object> webPages;
	
	@Override
	public String execute() throws Exception {
		webPages = HibernateUtils.getAllObjects("WebPage");
		
		return SUCCESS;
	}
}
