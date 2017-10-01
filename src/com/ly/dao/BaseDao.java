package com.ly.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 父类：spring依赖注入的sessionFactory()方法以及获得session
 * @author leiyuan
 *
 */

public class BaseDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		Session session=sessionFactory.openSession();
		return session;
	}

}
