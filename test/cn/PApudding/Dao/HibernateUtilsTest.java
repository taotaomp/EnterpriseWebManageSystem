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
		webEssay1.setEssayTitle("�����ǲ�������152");
		webEssay1.setEssayField("����Դ1");
		webEssay1.setEssayContent("�����Խ�ʯ\n����Ա��˼ά����\n������̵���");
		HibernateUtils.saveObject(webEssay1);
		webEssay2 = new WebEssay();
		webEssay2.setEssayTitle("�����ǲ�������2");
		webEssay2.setEssayField("����Դ2");
		webEssay2.setEssayContent("���������������ʵʩ\nLinux�����ŵ���ͨ");
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
