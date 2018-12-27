package cn.PApudding.Actions.TemplateActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebTemplate;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ɾ��ģ�������Action
 * 
 * @author PApudding
 *
 */
public class DeleteTemplateAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		WebTemplate template = (WebTemplate) HibernateUtils
				.getSingleObjectBySql("FROM WebTemplate WHERE id = '" + id + "'");
		HibernateUtils.removeObject(template);
		return SUCCESS;
	}
}
