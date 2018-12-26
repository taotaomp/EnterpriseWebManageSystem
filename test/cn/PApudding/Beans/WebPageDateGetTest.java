package cn.PApudding.Beans;

import java.util.Set;

import org.junit.Test;

import cn.PApudding.Beans.WebBeans.WebPage;
import cn.PApudding.Beans.WebBeans.WebPageToModelBindEntity;
import cn.PApudding.Dao.HibernateUtils;

public class WebPageDateGetTest {
	@Test
	public void getWebPageData() {
		WebPage page;
		page = (WebPage) HibernateUtils.getSingleObjectBySql("from WebPage where pageName = 'Catalina'");
		System.out.println(page.getPageFileCode());
		Set<WebPageToModelBindEntity> bindEntities = page.getWebPageToModelBindEntities();
		for (WebPageToModelBindEntity wtbe :bindEntities) {
			System.out.println(wtbe.getDataSourceField()+"\n"+
					wtbe.getDataTableName()+"\n"+
					wtbe.getModelRandomNumber());
		}
		
	}
}
