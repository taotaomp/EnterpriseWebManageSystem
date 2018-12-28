package cn.PApudding.Actions.PageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 删除站点页面的Action
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
		//待实现：删除本地文件
		HibernateUtils.removeObject(webLink);
		return SUCCESS;
	}
}
