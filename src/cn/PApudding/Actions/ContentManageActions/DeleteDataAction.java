package cn.PApudding.Actions.ContentManageActions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.SourceBeans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ����ɾ��һ�����ݵ�Action
 * 
 * @author PApudding
 *
 */
public class DeleteDataAction extends ActionSupport {
	private String databaseName; // ���ݿ���
	private String dataName; // ���ݶ�λ��

	// �����ض���Ĳ�������
	private String dataField; // ����Դ����Field��

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

	public String getDataField() {
		return dataField;
	}

	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	@Override
	public String execute() throws Exception {

		String sql;
		switch (databaseName) {
		case "WebEssay": {
			// ����SQL
			sql = "FROM " + databaseName + " WHERE essayTitle = " + "'" + dataName + "'";
			// ��ȡ����
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// ɾ������
			HibernateUtils.removeObject(object);
			// �ض����������
			WebEssay webEssay = (WebEssay) object;
			dataField = webEssay.getEssayField();
			break;
		}
		case "WebLink": {
			// ����SQL
			sql = "FROM " + databaseName + " WHERE linkName = " + "'" + dataName + "'";
			// ��ȡ����
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// ɾ������
			HibernateUtils.removeObject(object);
			// �ض����������
			WebLink webLink = (WebLink) object;
			dataField = webLink.getLinkField();
			break;
		}
		case "WebMediaSource": {
			// ����SQL
			sql = "FROM " + databaseName + " WHERE mediaName = " + "'" + dataName + "'";
			// ��ȡ����
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// ɾ������
			HibernateUtils.removeObject(object);
			// �ض����������
			WebMediaSource webMediaSource = (WebMediaSource) object;
			dataField = webMediaSource.getMediaField();
			break;
		}
		default:
			return ERROR;
		}

		return SUCCESS;
	}
}
