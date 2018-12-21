package cn.PApudding.Dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.PApudding.Beans.WebEssay;

public class HibernateUtilsTest {
	@Before
	public void loadDB() {
		WebEssay webEssay = new WebEssay();
		webEssay.setEssayTitle("�����ǲ�������1");
		webEssay.setEssayField("����Դ1");
		webEssay.setEssayContent("�����Խ�ʯ\n����Ա��˼ά����\n������̵���");
		HibernateUtils.saveObject(webEssay);
		webEssay = new WebEssay();
		webEssay.setEssayTitle("�����ǲ�������2");
		webEssay.setEssayField("����Դ2");
		webEssay.setEssayContent("���������������ʵʩ\nLinux�����ŵ���ͨ");
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
