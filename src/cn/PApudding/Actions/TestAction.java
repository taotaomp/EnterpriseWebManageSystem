package cn.PApudding.Actions;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebEssay;
import cn.PApudding.Beans.WebLink;
import cn.PApudding.Beans.WebMediaSource;
import cn.PApudding.Dao.HibernateUtils;

public class TestAction extends ActionSupport {

	private WebEssay webEssay = new WebEssay();

	public WebEssay getWebEssay() {
		return webEssay;
	}

	public void setWebEssay(WebEssay webEssay) {
		this.webEssay = webEssay;
	}

	@Override
	public String execute() throws Exception {
		HibernateUtils.saveObject(new WebEssay());
		HibernateUtils.saveObject(new WebLink());
		HibernateUtils.saveObject(new WebMediaSource());
		return SUCCESS;
	}

	public String test1() throws Exception {
		System.out.println(webEssay.getEssayTitle());
		System.out.println(webEssay.getEssayContent());
		System.out.println(webEssay.getEssayField());
		return SUCCESS;
	}

}
