package cn.PApudding.Actions.ContentManageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.SourceBeans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ���������޸�ҳ�������
 * 
 * @author PApudding
 *
 */
public class SaveModifyDataAction extends ActionSupport {
	private String databaseName; // ���ݿ���
	private String dataField; // ����Դ����Field��
	private Object dataObject; // ���ڽ������ݶ��������

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDataField() {
		return dataField;
	}

	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public String execute() throws Exception {
		//����3�����������
		WebEssay webEssay = null;
		WebLink webLink = null;
		WebMediaSource webMediaSource = null;
		//�������ݿ�����ת������
		switch (databaseName) {
		case "WebEssay": {
			webEssay = (WebEssay) dataObject;
			HibernateUtils.updateObject(webEssay);
			break;
		}
		case "WebLink": {
			webLink = (WebLink) dataObject;
			HibernateUtils.updateObject(webLink);
			break;
		}
		case "WebMediaSource": {
			webMediaSource = (WebMediaSource) dataObject;
			HibernateUtils.updateObject(webMediaSource);
			break;
		}
		default:
			return ERROR;
		}
		return SUCCESS;
	}
}
