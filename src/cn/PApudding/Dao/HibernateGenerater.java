package cn.PApudding.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 创建Hibernate实例的类
 * @author PApudding
 *
 */
public class HibernateGenerater {
	
	//创建Hibernate实例
	private static SessionFactory sessionFactory = null;
	static {
		Configuration configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	/**
	 * 创建一个Hibernate的Session对象
	 * @return Session对象
	 */
	public static Session sessionGenerate() {
		return sessionFactory.openSession();
	}
}
