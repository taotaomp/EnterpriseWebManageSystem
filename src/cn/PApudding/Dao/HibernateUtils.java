package cn.PApudding.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ����Hibernate��װһЩʵ�ù���
 * 
 * @author PApudding
 *
 */
public class HibernateUtils {
	/**
	 * ������������ݿ�
	 * 
	 * @param object �������
	 */
	public static void saveObject(Object object) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// �洢����
		session.save(object);
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
	}

	/**
	 * �����������һ�������ڴ������ݿ�
	 * 
	 * @param objects ��������
	 */
	public static void saveObjects(Set<Object> objects) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// �洢����
		for (Object object : objects) {
			session.save(object);
		}
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
	}

	/**
	 * ����ָ�����ݿ������е���Ŀ
	 * 
	 * @param databaseName
	 * @return List<Object>
	 */
	public static List<Object> getAllObjects(String databaseName) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ��ʼ��ѯ
		Query query = session.createQuery("from " + databaseName);
		List<Object> list = query.list();
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
		return list;
	}

	/**
	 * �����������ָ�������ݿ��л�ȡ��Ŀ
	 * 
	 * @param databaseName
	 * @param field
	 * @return List<Object>
	 */
	public static List<Object> getObjectsByField(String databaseName, String field) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// �趨�������е����֣��ڲ�ѯʱ��whereʹ��
		String fieldColumnName;
		switch (databaseName) {
		case "WebEssay": {
			fieldColumnName = "essayField";
			break;
		}
		case "WebLink": {
			fieldColumnName = "linkField";
			break;
		}
		case "WebMediaSource": {
			fieldColumnName = "mediaField";
			break;
		}
		default: {
			fieldColumnName = "";
		}
		}
		// ��ʼ��ѯ
		Query query = session.createQuery("from " + databaseName + " where " + fieldColumnName + " = " + field);
		List<Object> list = query.list();
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
		return list;
	}

	/**
	 * �����ݿ���ɾ�����󣨶���ͱ��ӳ����Hibernate����ά����
	 * 
	 * @param object
	 */
	public static void removeObject(Object object) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ɾ������
		session.delete(object);
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
	}

	/**
	 * �����ݿ��л�õ�������
	 * 
	 * @param sql
	 * @return Object ���������ѯ���Ķ������ж�������򷵻ص�һ��
	 */
	public static Object getSingleObjectBySql(String sql) {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ��ʼ��ѯ
		Query query = session.createQuery(sql);
		List<Object> list = query.list();
		Object object = null;
		if (list != null) {
			object = list.get(0);
		}
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
		return object;
	}

	/**
	 * ��ѯ���ݿ������е���������Դ
	 * 
	 * @return Map<String, List<String>>
	 * 		keys:	webEssayFields
	 *				webLinkFields
	 *				webMediaSourceFields
	 */
	public static Map<String, List<String>> getAllFields() {
		// ��ȡSession����
		Session session = HibernateGenerater.sessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ��ʼ��ѯ
		// �����ѯ���
		String webEssaySQL = "SELECT DISTINCT essayField FROM WebEssay";
		String webLinkSQL = "SELECT DISTINCT linkField FROM WebLink";
		String webMediaSourceSQL = "SELECT DISTINCT mediaField FROM WebMediaSource";
		// ��ѯ����
		List<String> webEssayFields = session.createSQLQuery(webEssaySQL).list();
		List<String> webLinkFields = session.createSQLQuery(webLinkSQL).list();
		List<String> webMediaSourceFields = session.createSQLQuery(webMediaSourceSQL).list();

//		List<List<String>> allFields = new ArrayList<List<String>>();
//		allFields.add(webEssayFields);
//		allFields.add(webLinkFields);
//		allFields.add(webMediaSourceFields);
		// ����ѯ�������ݷ�������
		Map<String, List<String>> allFields = new HashMap<String, List<String>>();
		allFields.put("webEssayFields", webEssayFields);
		allFields.put("webLinkFields", webLinkFields);
		allFields.put("webMediaSourceFields", webMediaSourceFields);

		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
		return allFields;
	}
}
