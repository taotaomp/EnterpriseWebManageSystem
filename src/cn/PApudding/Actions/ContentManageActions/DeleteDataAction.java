package cn.PApudding.Actions.ContentManageActions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.SourceBeans.WebEssay;
import cn.PApudding.Beans.SourceBeans.WebLink;
import cn.PApudding.Beans.SourceBeans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

/**
 * 请求删除一个数据的Action
 * 
 * @author PApudding
 *
 */
public class DeleteDataAction extends ActionSupport {
	private String databaseName; // 数据库名
	private String dataName; // 数据定位名

	// 用于重定向的参数放置
	private String dataField; // 数据源名（Field）

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
			// 设置SQL
			sql = "FROM " + databaseName + " WHERE essayTitle = " + "'" + dataName + "'";
			// 获取对象
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// 删除对象
			HibernateUtils.removeObject(object);
			// 重定向参数配置
			WebEssay webEssay = (WebEssay) object;
			dataField = webEssay.getEssayField();
			break;
		}
		case "WebLink": {
			// 设置SQL
			sql = "FROM " + databaseName + " WHERE linkName = " + "'" + dataName + "'";
			// 获取对象
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// 删除对象
			HibernateUtils.removeObject(object);
			// 重定向参数配置
			WebLink webLink = (WebLink) object;
			dataField = webLink.getLinkField();
			break;
		}
		case "WebMediaSource": {
			// 设置SQL
			sql = "FROM " + databaseName + " WHERE mediaName = " + "'" + dataName + "'";
			// 获取对象
			Object object = HibernateUtils.getSingleObjectBySql(sql);
			// 删除对象
			HibernateUtils.removeObject(object);
			// 重定向参数配置
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
