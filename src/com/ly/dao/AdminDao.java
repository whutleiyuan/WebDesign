package com.ly.dao;

import java.util.List;

import com.ly.model.UserManager;

public interface AdminDao {
	/**
	 * @author leiyuan
	 * @return List<UserManager>
	 */
	public List<UserManager>checkAllUser();
/**
 * 
 * @param um
 * @return
 */
	public boolean deleteUser(UserManager um);

	/**
	 * 
	 * @param password 用户名
	 * @return
	 */
	public List<UserManager> checkAllUser(String password);

	/**
	 * 
	 * @param password 用户名密码
	 * @param username 用户名
	 * @return
	 */
	public int affirmmodify(String password, String username);

}
