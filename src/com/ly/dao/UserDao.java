package com.ly.dao;
import java.util.List;

import com.ly.model.UserManager;
public interface UserDao {
     /**
      * 查询出用户表中的用户
      * @param username 用户名
      * @param password 密码
      */
	public boolean findUser(String username,String password);
	/**
	 * 该方法用来注册用户（将数据存进数据库中）
	 * @param user
	 * @return
	 */
	public boolean addUser(UserManager user);
	
	/**
	 * 查询出登陆用户的昵称
	 *@param username 用户名
	 *@param password 密码
	 */
	public List<UserManager> findNickname(String username,String password);
}
