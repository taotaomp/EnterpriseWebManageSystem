package cn.PApudding.Dao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import cn.PApudding.Beans.WebPage;
import cn.PApudding.Beans.WebPageToModelBindEntity;

public class HibernatePageTest {
	@Test
	public void pageTest() {
		WebPage page = new WebPage();
		WebPageToModelBindEntity webPageToModelBindEntity1 = new WebPageToModelBindEntity();
		webPageToModelBindEntity1.setModelRandomNumber(156);
		webPageToModelBindEntity1.setDataTableName("test");
		webPageToModelBindEntity1.setDataSourceField("test");
		webPageToModelBindEntity1.setWebPage(page);
		WebPageToModelBindEntity webPageToModelBindEntity2 = new WebPageToModelBindEntity();
		webPageToModelBindEntity2.setModelRandomNumber(1552);
		webPageToModelBindEntity2.setDataTableName("test2");
		webPageToModelBindEntity2.setDataSourceField("test2");
		webPageToModelBindEntity2.setWebPage(page);
		Set<WebPageToModelBindEntity>  bindEntities = new HashSet<WebPageToModelBindEntity>();
		bindEntities.add(webPageToModelBindEntity1);
		bindEntities.add(webPageToModelBindEntity2);
		
		page.setPageFileCode("testcode");
		page.setPageName("thisIsTestPage");
		page.setWebPageToModelBindEntities(bindEntities);
		
		Set<Object> objects = new HashSet<Object>();
		objects.add(webPageToModelBindEntity1);
		objects.add(webPageToModelBindEntity2);
		objects.add(page);
		
		HibernateUtils.saveObjects(objects);
	}
}
