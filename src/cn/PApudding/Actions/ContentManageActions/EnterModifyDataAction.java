package cn.PApudding.Actions.ContentManageActions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Dao.HibernateUtils;

/**
 * �����޸����ݽ��������Action
 * 
 * @author PApudding
 *
 */
public class EnterModifyDataAction extends ActionSupport {
	private String databaseName; // ���ݿ���
	private String dataName; // ���ݶ�λ��

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	@Override
	public String execute() throws Exception {

		String sql;
		switch (databaseName) {
		case "WebEssay": {
			sql = "FROM " + databaseName + " WHERE essayTitle = " + dataName;
			break;
		}
		case "WebLink": {
			sql = "FROM " + databaseName + " WHERE linkName = " + dataName;
			break;
		}
		case "WebMediaSource": {
			sql = "FROM " + databaseName + " WHERE mediaName = " + dataName;
			break;
		}
		default:
			return ERROR;
		}
		// ��ȡ����
		Object object = HibernateUtils.getSingleObjectBySql(sql);

		ServletActionContext.getRequest().setAttribute("data", object);
		ServletActionContext.getRequest().setAttribute("databaseName", databaseName);
		return SUCCESS;
	}
}
