package cn.PApudding.Actions.ContentManageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.SourceBeans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

/**
 * ���洴������Դ�������action
 * 
 * @author PApudding
 *
 */
public class SaveCreateDataAction extends ActionSupport {
	// ����3�����������
	WebEssay webEssay = null;
	WebLink webLink = null;
	WebMediaSource webMediaSource = null;
	// �����ض���Ĳ�������
	private String databaseName; // ���ݿ���
	private String dataField; // ����Դ����Field��

	public WebEssay getWebEssay() {
		return webEssay;
	}

	public void setWebEssay(WebEssay webEssay) {
		this.webEssay = webEssay;
	}

	public WebLink getWebLink() {
		return webLink;
	}

	public void setWebLink(WebLink webLink) {
		this.webLink = webLink;
	}

	public WebMediaSource getWebMediaSource() {
		return webMediaSource;
	}

	public void setWebMediaSource(WebMediaSource webMediaSource) {
		this.webMediaSource = webMediaSource;
	}

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

	@Override
	public String execute() throws Exception {
		if (webEssay != null) {
			HibernateUtils.saveObject(webEssay);
			// �����ض������
			databaseName = "WebEssay";
			dataField = webEssay.getEssayField();

		}
		if (webLink != null) {
			HibernateUtils.saveObject(webLink);
			// �����ض������
			databaseName = "WebLink";
			dataField = webLink.getLinkField();
		}
		if (webMediaSource != null) {
			HibernateUtils.saveObject(webMediaSource);
			// �����ض������
			databaseName = "WebMediaSource";
			dataField = webMediaSource.getMediaField();
		}

		return SUCCESS;
	}
}
