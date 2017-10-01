package com.ly.service;

import java.util.List;

import com.ly.model.UserManager;

/**
 * 管理员对用户进行处理的业务逻辑
 * @author leiyuan
 *
 */
public interface AdminService {
/**
 * 
 * @param username 管理员用户名
 * @param password 管理员密码
 * @return （>0用户存在，<0用户不存在）
 */
public 	int userValidate(String username, String password);
/**
 * @author leiyuan
 * @return List<UserManager>
 */
public List<UserManager> checkAllUser();
/**
 * 删除指定用户
 * @param um
 * @return（>0删除成功，<0失败）
 */
public int deleteUser(UserManager um);

/**
 * 
 * @param password 用户密码
 *  @param nickname	 用户呢称
 * @return (大于0密码正确可以修改密码，小于0密码错误返回当前页面
 */
public int modifypass(String password,String nickname);

/**
 * 
 * @param password 用户密码
 * @param username 用户名
 * @return
 */
public int affirmmodify(String password, String username);
}

