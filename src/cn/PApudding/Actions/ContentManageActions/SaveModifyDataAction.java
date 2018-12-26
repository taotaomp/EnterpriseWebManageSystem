package cn.PApudding.Actions.ContentManageActions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.SourceBeans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 进入数据修改页面的请求
 * 
 * @author PApudding
 *
 */
public class SaveModifyDataAction extends ActionSupport {
	private String databaseName; // 数据库名
	private String dataField; // 数据源名（Field）
	private Object dataObject; // 用于接收数据对象的容器

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
		//创建3个对象的引用
		WebEssay webEssay = null;
		WebLink webLink = null;
		WebMediaSource webMediaSource = null;
		//根据数据库名来转换对象
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
