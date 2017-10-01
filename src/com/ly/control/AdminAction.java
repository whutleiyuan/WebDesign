package com.ly.control;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ly.model.UserManager;
import com.ly.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员拥有的权限对用户进行操作
 * @author leiyuan
 *
 */

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
    //封装序号
	private int id;
	//封装昵称
	private String nickname;
	//封装管理员用户名
	private String username;
	//封装管理员密码
	private String password;
	//封装第二次输入的密码
	private String rpassword;
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	//管理员处理的业务逻辑组件
	private AdminService as;
	//存储用户
	private UserManager user;
	public UserManager getUser() {
		return user;
	}
	public void setUser(UserManager user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public AdminService getAs() {
		return as;
	}
	public void setAs(AdminService as) {
		this.as = as;
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
	
	 //  返回首页
  public String execute(){
	return INPUT;
	 
	  
  }
  
  public String deleteUser(){
	/*  System.out.println("用户名是"+getUsername());*/
	  user.setId(getId());
	  user.setNickname(getNickname());
	  user.setUsername(getUsername());
	  user.setPassword(getPassword());
	  int issucc=as.deleteUser(user);
	  if(issucc>0){
		  List<UserManager> list=as.checkAllUser();
		  if(list!=null){
			  ServletActionContext.getServletContext().setAttribute("list", list);
				Map<String,Object> session=ActionContext.getContext().getSession();
				  if(getUsername().equals(session.get("username"))&&getPassword().equals(session.get("password"))){						
					  session.remove("username");
						session.remove("password");
						return ERROR;
				  }
	  }else{
		  Map<String,Object> session=ActionContext.getContext().getSession();
		  if(getUsername().equals(session.get("username"))&&getPassword().equals(session.get("password"))){						
			  session.remove("username");
				session.remove("password");
		  return ERROR;
	  }
	  }
		  return INPUT;
  }else{
	  return null;
  }
	
  }
  
 //验证管理员登陆
  public String validateUser(){
	  int isExist=as.userValidate(getUsername(),getPassword());
	  if(isExist>0){
		  List<UserManager> list=as.checkAllUser();
		  if(list!=null){
			  ServletActionContext.getServletContext().setAttribute("list", list);
			  return INPUT;
		  }else{		
			  return INPUT; 
		  }
	  }else{
		  return ERROR;  
	  }	  
  }
  
  //退出系统
  public String exitSystem(){
	  Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("username");
		session.remove("password");
	return INPUT;
	  
  }
  
 public String modifypass(){
	 //调用业务逻辑组件modifypass()方法来验证用户名密码和修改密码
	  Map<String,Object> session=ActionContext.getContext().getSession();
	  //得到用户呢称
	 nickname=(String) session.get("nickname");
	System.out.println("当前登陆用户的昵称qac："+nickname);
	 int issucc=as.modifypass(getPassword(),nickname);
	 if(issucc>0){
			return INPUT;

	 }
	return ERROR;
	 
 }
 
 public String affirmmodify(){
	 //调用业务逻辑组件的affirmmodify()方法修改密码
	  Map<String,Object> session=ActionContext.getContext().getSession();
	  //得到用户名
	 nickname=(String) session.get("nickname");
	 int issucc=as.affirmmodify(getPassword(),nickname);
	 if(issucc>0){
		return ERROR;
	 }
	return INPUT;
	 
 }
}
