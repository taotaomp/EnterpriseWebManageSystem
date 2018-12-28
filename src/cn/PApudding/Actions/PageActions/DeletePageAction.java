package cn.PApudding.Actions.PageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Dao.HibernateUtils;

/**
 * É¾³ýÒ³ÃæÇëÇóµÄAction
 * 
 * @author PApudding
 *
 */
public class DeletePageAction extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		WebPage webPage = (WebPage) HibernateUtils.getSingleObjectBySql("FROM WebPage WHERE id= '"+id+"'");
		HibernateUtils.removeObject(webPage);
		return SUCCESS;
	}
}
