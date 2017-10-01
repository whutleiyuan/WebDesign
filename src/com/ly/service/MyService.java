package com.ly.service;

import com.ly.model.UserManager;

/**
 * 业务逻辑组件接口，用来实现对用户Action得到参数的处理
 * @author leiyuan
 *
 */

public interface MyService {
	//定义一个用于验证用户登录的方法
	public int validateLogin(String username,String password);
	//定义一个用于注册用户的方法
	public int registerUser(UserManager user);
	//定义一个找到当前登录用户昵称的方法
	public String Nickname(String username,String password); 

}
