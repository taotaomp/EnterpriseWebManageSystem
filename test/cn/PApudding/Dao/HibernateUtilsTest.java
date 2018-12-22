package cn.PApudding.Dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.PApudding.Beans.WebEssay;

public class HibernateUtilsTest {
	private WebEssay webEssay1,webEssay2;
	
	@Before
	public void loadDB() {
		webEssay1 = new WebEssay();
		webEssay1.setEssayTitle("这里是测试文章152");
		webEssay1.setEssayField("文章源1");
		webEssay1.setEssayContent("人生试金石\n程序员的思维修炼\n软件工程导论");
		HibernateUtils.saveObject(webEssay1);
		webEssay2 = new WebEssay();
		webEssay2.setEssayTitle("这里是测试文章2");
		webEssay2.setEssayField("文章源2");
		webEssay2.setEssayContent("物联网工程设计与实施\nLinux从入门到精通");
		HibernateUtils.saveObject(webEssay2);
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
	
	@Test
	public void removeTestData() {
		HibernateUtils.removeObject(webEssay1);
		HibernateUtils.removeObject(webEssay2);
	}
}
