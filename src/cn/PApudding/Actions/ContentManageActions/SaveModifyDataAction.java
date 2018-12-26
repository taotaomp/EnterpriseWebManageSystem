package cn.PApudding.Actions.ContentManageActions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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

	@Override
	public String execute() throws Exception {
		if (webEssay != null) {
			HibernateUtils.updateObject(webEssay);
		}
		if (webLink != null) {
			HibernateUtils.updateObject(webLink);
		}
		if (webMediaSource != null) {
			HibernateUtils.updateObject(webMediaSource);
		}
		return SUCCESS;
	}
}
