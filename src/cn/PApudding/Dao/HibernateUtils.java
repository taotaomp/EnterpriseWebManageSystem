package cn.PApudding.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.PApudding.Beans.WebEssay;
import cn.PApudding.Beans.WebLink;
import cn.PApudding.Beans.WebMediaSource;

/**
 * ����Hibernate��װһЩʵ�ù���
 * @author PApudding
 *
 */
public class HibernateUtils {
	/**
	 * ������������ݿ�
	 * @param object �������
	 * @return
	 */
	public static boolean saveObject(Object object) {
		Session session = null;
		try {
			//��ȡSession����
			session = HibernateGenerater.SessionGenerate();
			//��ʼ����
			Transaction tx = session.beginTransaction();
			//�洢����
			session.save(object);
			//�ύ����
			tx.commit();
			return true;		
		}catch (Exception e) {
			e.getStackTrace();
			return false;
		}finally {
			//�ر�Session����
			session.close();
		}
	}
}
