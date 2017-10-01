package com.ly.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ly.model.UserManager;

public class AdminDaoImpl extends BaseDao implements AdminDao{

	@Override
	public List<UserManager> checkAllUser() {
		String hql="from UserManager";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//开始查询并把查询结果放在List集合中
		@SuppressWarnings("unchecked")
		List<UserManager> list=session.createQuery(hql).list();		
        if(list.size()!=0){
		return list;
	}else{
		tx.commit();//提交session
        session.close();//关闭session
        return null;
		
	}
	}

	@Override
	public boolean deleteUser(UserManager um) {
		       //获得Hibernatte Session
				Session session=(Session)getSession();
				//开始事务
				Transaction tx=session.beginTransaction();
				//加载持久化实例
				UserManager user=session.get(UserManager.class, um.getId());
				//删除实例
				session.delete(user);
				tx.commit();//提交session
		        session.close();//关闭session
		return true;
	}


	@Override
	public List<UserManager> checkAllUser(String password) {
		String hql="from UserManager um where um.password=?";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//开始查询并把查询结果放在List集合中
		@SuppressWarnings("unchecked")
		List<UserManager> list=session.createQuery(hql).setParameter(0, password).list();		
        if(list.size()!=0){
		return list;
	}else{
		tx.commit();//提交session
        session.close();//关闭session
        return null;
		
	}
	}

	@Override
	public int affirmmodify(String password,  String nickname) {
		String hql="update from UserManager um set um.password=? where um.nickname=? ";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//执行更新
		int updateEntities=session.createQuery(hql).setParameter(0, password).setParameter(1, nickname).executeUpdate();
        tx.commit();//提交session
        if(updateEntities>0){
		return 20;
	}else{
        session.close();//关闭session
        return -1;
		
	}
}
}
