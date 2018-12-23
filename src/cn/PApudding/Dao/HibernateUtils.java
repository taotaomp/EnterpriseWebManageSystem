package cn.PApudding.Dao;

import java.util.List;

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
	 * @return
	 */
	public static boolean saveObject(Object object) {
		Session session = null;
		try {
			// ��ȡSession����
			session = HibernateGenerater.SessionGenerate();
			// ��ʼ����
			Transaction tx = session.beginTransaction();
			// �洢����
			session.save(object);
			// �ύ����
			tx.commit();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		} finally {
			// �ر�Session����
			session.close();
		}
	}

	/**
	 * ����ָ�����ݿ������е���Ŀ
	 * 
	 * @param databaseName
	 * @return List<Object>
	 */
	public static List<Object> getAllObjects(String databaseName) {
		// ��ȡSession����
		Session session = HibernateGenerater.SessionGenerate();
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
		Session session = HibernateGenerater.SessionGenerate();
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
		Session session = HibernateGenerater.SessionGenerate();
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
		Session session = HibernateGenerater.SessionGenerate();
		// ��ʼ����
		Transaction tx = session.beginTransaction();
		// ��ʼ��ѯ
		Query query = session.createQuery(sql);
		List<Object> list = query.list();
		Object object = null;
		if(list!=null) {
			object = list.get(0);
		}
		// �ύ����
		tx.commit();
		// �ر�Session����
		session.close();
		return object;
	}
}
