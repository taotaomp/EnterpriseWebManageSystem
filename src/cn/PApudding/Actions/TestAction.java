package cn.PApudding.Actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;
import cn.PApudding.SiteGenerator.SiteJspGenerator;


public class TestAction extends ActionSupport{
	ArrayList<String> testList = new ArrayList<String>() ;
	public ArrayList<String> getTestList() {
		return testList;
	}
	public void setTestList(ArrayList<String> testList) {
		this.testList = testList;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(testList);
//		String ServletRealPath = ServletActionContext.getServletContext().getRealPath(".");
//		SiteJspGenerator.generateJSP(ServletRealPath, "test.jsp", "<html><p>fuck</p></html>");
//		
//		WebPage page = new WebPage();
//		WebPageToModelBindEntity webPageToModelBindEntity1 = new WebPageToModelBindEntity();
//		webPageToModelBindEntity1.setModelRandomNumber(156);
//		webPageToModelBindEntity1.setDataTableName("test");
//		webPageToModelBindEntity1.setDataSourceField("test");
//		webPageToModelBindEntity1.setWebPage(page);
//		WebPageToModelBindEntity webPageToModelBindEntity2 = new WebPageToModelBindEntity();
//		webPageToModelBindEntity2.setModelRandomNumber(1552);
//		webPageToModelBindEntity2.setDataTableName("test2");
//		webPageToModelBindEntity2.setDataSourceField("test2");
//		webPageToModelBindEntity2.setWebPage(page);
//		Set<WebPageToModelBindEntity>  bindEntities = new HashSet<WebPageToModelBindEntity>();
//		bindEntities.add(webPageToModelBindEntity1);
//		bindEntities.add(webPageToModelBindEntity2);
//		
//		page.setPageFileCode("testcode");
//		page.setPageName("thisIsTestPage");
//		page.setWebPageToModelBindEntities(bindEntities);
//		
//		Set<Object> objects = new HashSet<Object>();
//		objects.add(webPageToModelBindEntity1);
//		objects.add(webPageToModelBindEntity2);
//		objects.add(page);
//		
//		HibernateUtils.saveObjects(objects);
		return SUCCESS;
	}
}
