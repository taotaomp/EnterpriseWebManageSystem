package cn.PApudding.Actions.PageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ɾ��վ��ҳ���Action
 * 
 * @author PApudding
 *
 */
public class DeleteSiteAction extends ActionSupport {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		WebLink webLink = (WebLink) HibernateUtils.getSingleObjectBySql("FROM WebLink WHERE id= '"+id+"'");
		//��ʵ�֣�ɾ�������ļ�
		HibernateUtils.removeObject(webLink);
		return SUCCESS;
	}
}
