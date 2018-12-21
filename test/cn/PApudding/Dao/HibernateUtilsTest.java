package cn.PApudding.Dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.PApudding.Beans.WebEssay;

public class HibernateUtilsTest {
	@Before
	public void loadDB() {
		WebEssay webEssay = new WebEssay();
		webEssay.setEssayTitle("这里是测试文章1");
		webEssay.setEssayField("文章源1");
		webEssay.setEssayContent("人生试金石\n程序员的思维修炼\n软件工程导论");
		HibernateUtils.saveObject(webEssay);
		webEssay = new WebEssay();
		webEssay.setEssayTitle("这里是测试文章2");
		webEssay.setEssayField("文章源2");
		webEssay.setEssayContent("物联网工程设计与实施\nLinux从入门到精通");
		HibernateUtils.saveObject(webEssay);
	}
	
	@Test
	public void testGetAllObjects() {
		List<Object> list = HibernateUtils.getAllObjects("WebEssay");
		for(Object o :list) {
			WebEssay essay = (WebEssay)o;
			System.out.println(essay.getEssayTitle()+"\n"
					+essay.getEssayField()+"\n"
					+essay.getEssayContent()
					);
		}
		
	}
}
