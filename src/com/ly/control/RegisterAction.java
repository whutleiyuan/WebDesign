package com.ly.control;

import org.apache.struts2.ServletActionContext;

import com.ly.model.UserManager;
import com.ly.service.MyService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 该控制器用来处理注册用户
 * @author leiyuan
 *
 */

public class RegisterAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 277999393921351567L;
    //将用户请求封装成对象
	private UserManager user;
	//用来封装用户请求
	private String nickname;
	private String username;
	private String password;
	//处理用户请求，并返回相应结果
	private MyService ms;

	public UserManager getUser() {
		return user;
	}

	public void setUser(UserManager user) {
		this.user = user;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyService getMs() {
		return ms;
	}

	public void setMs(MyService ms) {
		this.ms = ms;
	}
	

	public String execute()throws Exception{
		//将表单的请求存到user对象中去
		user.setNickname(nickname);
		user.setUsername(username);
		user.setPassword(password);
		//调用业务逻辑组件的registerUser()方法
		int result=ms.registerUser(user);
		ServletActionContext.getRequest().setAttribute("issucc", "147");

		if(result>0){
			return INPUT;	
		}
		return ERROR;
	}
	
public String back(){
	
	return INPUT;
	
}

}
