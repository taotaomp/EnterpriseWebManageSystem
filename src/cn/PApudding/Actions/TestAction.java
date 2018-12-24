package cn.PApudding.Actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.SiteGenerator.SiteJspGenerator;


public class TestAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		String ServletRealPath = ServletActionContext.getServletContext().getRealPath(".");
		SiteJspGenerator.generateJSP(ServletRealPath, "test.jsp", "<html><p>fuck</p></html>");
		return SUCCESS;
	}
}
