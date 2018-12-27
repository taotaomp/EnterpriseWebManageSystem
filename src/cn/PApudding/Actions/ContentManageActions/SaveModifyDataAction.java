package cn.PApudding.Actions.ContentManageActions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
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
	// 创建3个对象的引用
	WebEssay webEssay = null;
	WebLink webLink = null;
	WebMediaSource webMediaSource = null;
	//用于重定向的参数放置
	private String databaseName;	//数据库名
	private String dataField;	//数据源名（Field）

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
			HibernateUtils.updateObject(webEssay);
			//配置重定向参数
			databaseName="WebEssay";
			dataField=webEssay.getEssayField();
			//URL转码
			dataField = java.net.URLDecoder.decode(dataField, "UTF-8");

		}
		if (webLink != null) {
			HibernateUtils.updateObject(webLink);
			//配置重定向参数
			databaseName="WebLink";
			dataField=webLink.getLinkField();
			//URL转码
			dataField = java.net.URLDecoder.decode(dataField, "UTF-8");
		}
		if (webMediaSource != null) {
			HibernateUtils.updateObject(webMediaSource);
			//配置重定向参数
			databaseName="WebMediaSource";
			dataField=webMediaSource.getMediaField();
			//URL转码
			dataField = java.net.URLDecoder.decode(dataField, "UTF-8");
		}
		
		
		return SUCCESS;
	}
}
