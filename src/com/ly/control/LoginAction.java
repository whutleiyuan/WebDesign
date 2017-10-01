package com.ly.control;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import com.ly.service.MyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	/**
	 * 用户登录
	 * @author leiyuan
	 */
	private static final long serialVersionUID = 4093039412534691422L;
	public String nickname;//当前登陆用户的昵称
	//用来封装用户请求参数的两个成员变量
	private String username;
	private String password;
	//用来封装登陆界面复选框的状态
	private String checkbox;
	//系统所需要的业务逻辑组件
	private MyService ms;

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
	
	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String execute() throws Exception{
		//将用户名和密码保存在session中
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("username", getUsername());
		session.put("password", getPassword());
		//调用业务逻辑组件的validateLogin方法进行用户的登陆验证
		int result=ms.validateLogin(getUsername(), getPassword());		
	   /*	System.out.println(getUsername());*/
		if(result>0){
			//调用业务逻辑组件的Nickname()方法得到当前登录用户的昵称
			nickname=ms.Nickname(getUsername(), getPassword());
			//将用户昵称放置在request范围中
			ServletActionContext.getRequest().setAttribute("nickname", nickname);
			//将将用户昵称放置在session范围中
			session.put("nickname", nickname);
			if(getCheckbox()!=null){
				//记住密码处于被选中状态时添加Cookie
				//将用户名添加到cookie中
				CookieUtil.addCookie(ServletActionContext.getResponse(), "username", getUsername(), 24*3600);
				//将密码添加到Cookie中
				CookieUtil.addCookie(ServletActionContext.getResponse(), "password", getPassword(), 24*3600);
				/*//下面的语句用来验证是否添加了Cooki*e
				Cookie[] cookies=ServletActionContext.getRequest().getCookies();
				for(Cookie ck:cookies){
					if(ck.getName().equals("password")){
						System.out.println(ck.getValue());
					}
				}*/
				System.out.println("复选框被选中时");
				
			}else{
				//记住密码处于未选中状态时
				CookieUtil.addCookie(ServletActionContext.getResponse(), "username", null, 0);//消除Cookie中的用户名
				CookieUtil.addCookie(ServletActionContext.getResponse(), "password", null, 0);//消除Cookie中的密码
				System.out.println("复选框未被选中时");
			}
			return SUCCESS;
			
		}
		return ERROR;
		
}
}	
