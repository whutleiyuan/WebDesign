package com.ly.service;

import java.util.List;

import com.ly.dao.AdminDao;
import com.ly.dao.UserDao;
import com.ly.model.UserManager;

/**
 * 实现业务逻辑组件接口中的类，完成对用户的验证
 * @author leiyuan
 *
 */

public class MyServiceImpl implements MyService {
	String nickname;
	//业务逻辑组件调用UserDao来查询用户
    private UserDao udl;
    //注入AdminDao组件
    private AdminDao adl;
	public AdminDao getAdl() {
		return adl;
	}
	public void setAdl(AdminDao adl) {
		this.adl = adl;
	}
	public UserDao getUdl() {
		return udl;
	}
	//spring注入UserDao所需要的setter方法
	public void setUdl(UserDao udl) {
		this.udl = udl;
	}

	@Override
	public int validateLogin(String username, String password) {
		// TODO Auto-generated method stub
		//得到findUser()方法，判断用户是否存在
		boolean  isExist=udl.findUser(username, password);
		if(isExist){
			return 10;
		}
		return -1;
		
	}
	@Override
	public int registerUser(UserManager user) {
		String nick=user.getNickname();
		String username=user.getUsername();
         //查询出所有用户比较当前用户是否已经存在
		List<UserManager> list=adl.checkAllUser();
		for(int i=0;i<list.size();i++){
			UserManager um=list.get(i);
			if(nick.equals(um.getNickname())||username.equals(um.getUsername())){
				//此用户以存在直接返回注册失败
				return -1;
			}
			}
		//得到addUser（）方法，向数据库中添加用户
		boolean isExist=udl.addUser(user);
		if(isExist){
			return 11;
		}
		return -1;

	}
	@SuppressWarnings("unused")
	@Override
	public String Nickname(String username,String password) {
		// TODO Auto-generated method stub
		List<UserManager> list=udl.findNickname(username, password);
		//对List循环遍历。找到当前登录用户的昵称
		for(int i=0;i<list.size();i++){
			UserManager um=list.get(i);
			nickname=um.getNickname();
			System.out.println("当前登陆用户的昵称："+nickname);
			return nickname;
		}
		return null;
	}

}
