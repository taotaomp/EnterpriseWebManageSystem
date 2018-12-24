package cn.PApudding.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * ����Hibernateʵ������
 * @author PApudding
 *
 */
public class HibernateGenerater {
	
	//����Hibernateʵ��
	private static SessionFactory sessionFactory = null;
	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	/**
	 * ����һ��Hibernate��Session����
	 * @return Session����
	 */
	public static Session sessionGenerate() {
		return sessionFactory.openSession();
	}
}
