package com.ly.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ly.model.UserManager;
/**
 * 实现具体查询
 * @author leiyuan
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	@Override
	public boolean findUser(String username,String password) {
		String hql="from UserManager um where um.username=? and um.password=?";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//开始查询并把查询结果放在List集合中
		@SuppressWarnings("unchecked")
		List<UserManager> list=session.createQuery(hql).setParameter(0, username).setParameter(1, password).list();		
        if(list.size()!=0){
		return true;
	}else{
		tx.commit();//提交session
        session.close();//关闭session
        return false;
		
	}
    }

	@Override
	public boolean addUser(UserManager user) {
		//获得Hibernatte Session
				Session session=(Session)getSession();
				//开始事务
				Transaction tx=session.beginTransaction();
				//保存用户
			int id=(Integer)session.save(user);
			System.out.println("id的值是"+id);
			System.out.println(user.getUsername());
				if(id>0){
					tx.commit();//提交session
				    session.close();//关闭session
					return true;
				}else{
					tx.commit();//提交session
				     session.close();//关闭session
					 return false;
					
				}				 
					
				
	}

	@Override
	public List<UserManager> findNickname(String username, String password) {
		String hql="from UserManager um where um.username=? and um.password=?";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//开始查询并把查询结果放在List集合中
		@SuppressWarnings("unchecked")
		List<UserManager> list=session.createQuery(hql).setParameter(0, username).setParameter(1, password).list();		
        if(list.size()!=0){
		return list;
	}else{
		tx.commit();//提交session
        session.close();//关闭session
        return null;
		
	}
	}
}
