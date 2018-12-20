package cn.PApudding.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.PApudding.Beans.WebEssay;
import cn.PApudding.Beans.WebLink;
import cn.PApudding.Beans.WebMediaSource;

/**
 * 基于Hibernate封装一些实用工具
 * @author PApudding
 *
 */
public class HibernateUtils {
	/**
	 * 将对象存入数据库
	 * @param object 任意对象
	 * @return
	 */
	public static boolean saveObject(Object object) {
		Session session = null;
		try {
			//获取Session对象
			session = HibernateGenerater.SessionGenerate();
			//开始事务
			Transaction tx = session.beginTransaction();
			//存储对象
			session.save(object);
			//提交事务
			tx.commit();
			return true;		
		}catch (Exception e) {
			e.getStackTrace();
			return false;
		}finally {
			//关闭Session对象
			session.close();
		}
	}
}
