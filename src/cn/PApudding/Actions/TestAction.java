package cn.PApudding.Actions;



import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebEssay;
import cn.PApudding.Dao.HibernateUtils;


public class TestAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		WebEssay webEssay = new WebEssay();
		HibernateUtils.saveObject(webEssay);
		return SUCCESS;
	}
	
}
