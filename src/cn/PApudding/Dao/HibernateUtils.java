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
	 */
	public static void saveObject(Object object) {
		// 获取Session对象
		Session session = HibernateGenerater.sessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 存储对象
		session.save(object);
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
	}

	/**
	 * 将多个对象在一次事务内存入数据库
	 * 
	 * @param objects 对象数组
	 */
	public static void saveObjects(Set<Object> objects) {
		// 获取Session对象
		Session session = HibernateGenerater.sessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 存储对象
		for (Object object : objects) {
			session.save(object);
		}
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
	}

	/**
	 * 返回指定数据库中所有的项目
	 * 
	 * @param databaseName
	 * @return List<Object>
	 */
	public static List<Object> getAllObjects(String databaseName) {
		// 获取Session对象
		Session session = HibernateGenerater.sessionGenerate();
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
		Session session = HibernateGenerater.sessionGenerate();
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
		Session session = HibernateGenerater.sessionGenerate();
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
		Session session = HibernateGenerater.sessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 开始查询
		Query query = session.createQuery(sql);
		List<Object> list = query.list();
		Object object = null;
		if (list != null) {
			object = list.get(0);
		}
		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
		return object;
	}

	/**
	 * 查询数据库中现有的所有内容源
	 * 
	 * @return Map<String, List<String>>
	 * 		keys:	webEssayFields
	 *				webLinkFields
	 *				webMediaSourceFields
	 */
	public static Map<String, List<String>> getAllFields() {
		// 获取Session对象
		Session session = HibernateGenerater.sessionGenerate();
		// 开始事务
		Transaction tx = session.beginTransaction();
		// 开始查询
		// 定义查询语句
		String webEssaySQL = "SELECT DISTINCT essayField FROM WebEssay";
		String webLinkSQL = "SELECT DISTINCT linkField FROM WebLink";
		String webMediaSourceSQL = "SELECT DISTINCT mediaField FROM WebMediaSource";
		// 查询操作
		List<String> webEssayFields = session.createSQLQuery(webEssaySQL).list();
		List<String> webLinkFields = session.createSQLQuery(webLinkSQL).list();
		List<String> webMediaSourceFields = session.createSQLQuery(webMediaSourceSQL).list();

//		List<List<String>> allFields = new ArrayList<List<String>>();
//		allFields.add(webEssayFields);
//		allFields.add(webLinkFields);
//		allFields.add(webMediaSourceFields);
		// 将查询到的数据放入容器
		Map<String, List<String>> allFields = new HashMap<String, List<String>>();
		allFields.put("webEssayFields", webEssayFields);
		allFields.put("webLinkFields", webLinkFields);
		allFields.put("webMediaSourceFields", webMediaSourceFields);

		// 提交事务
		tx.commit();
		// 关闭Session对象
		session.close();
		return allFields;
	}
}
