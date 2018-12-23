package cn.PApudding.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 基于Hibernate封装一些实用工具
 * 
 * @author PApudding
 *
 */
public class HibernateUtils {
	/**
	 * 将对象存入数据库
	 * 
	 * @param object 任意对象
	 * @return
	 */
	public static boolean saveObject(Object object) {
		Session session = null;
		try {
			// 获取Session对象
			session = HibernateGenerater.SessionGenerate();
			// 开始事务
			Transaction tx = session.beginTransaction();
			// 存储对象
			session.save(object);
			// 提交事务
			tx.commit();
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		} finally {
			// 关闭Session对象
			session.close();
		}
	}

	/**
	 * 返回指定数据库中所有的项目
	 * 
	 * @param databaseName
	 * @return List<Object>
	 */
	public static List<Object> getAllObjects(String databaseName) {
		// 获取Session对象
		Session session = HibernateGenerater.SessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 开始查询
		Query query = session.createQuery("from " + databaseName);
		List<Object> list = query.list();
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
		return list;
	}

	/**
	 * 根据作用域从指定的数据库中获取项目
	 * 
	 * @param databaseName
	 * @param field
	 * @return List<Object>
	 */
	public static List<Object> getObjectsByField(String databaseName, String field) {
		// 获取Session对象
		Session session = HibernateGenerater.SessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 设定作用域列的名字，在查询时供where使用
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
		// 开始查询
		Query query = session.createQuery("from " + databaseName + " where " + fieldColumnName + " = " + field);
		List<Object> list = query.list();
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
		return list;
	}

	/**
	 * 从数据库中删除对象（对象和表的映射由Hibernate负责维护）
	 * 
	 * @param object
	 */
	public static void removeObject(Object object) {
		// 获取Session对象
		Session session = HibernateGenerater.SessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 删除对象
		session.delete(object);
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
	}

	/**
	 * 从数据库中获得单个对象
	 * 
	 * @param sql
	 * @return Object 单个满足查询语句的对象，若有多个对象则返回第一个
	 */
	public static Object getSingleObjectBySql(String sql) {
		// 获取Session对象
		Session session = HibernateGenerater.SessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 开始查询
		Query query = session.createQuery(sql);
		List<Object> list = query.list();
		Object object = null;
		if(list!=null) {
			object = list.get(0);
		}
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
		return object;
	}
}
