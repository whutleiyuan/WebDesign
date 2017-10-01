<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ly.control.CookieUtil" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
 <link type="text/css" rel="stylesheet" href="./CSS/Loginin.css"/>
 <style type="text/css">
 /*使用内部CSS为登录按钮设置样式*/
    #submit{
    width: 300px;   
    min-height: 35px;   
    display: block;   
    background-color: #4a77d4;   
    border: 1px solid #3762bc;   
    color: #fff;   
    padding: 9px 14px;   
    font-size: 15px;   
    line-height: normal;   
    border-radius: 5px;   
    margin: 0;   
    }   
</style>
</head>
<body>
<!-- 声明一个变量用来存储cookie中的用户名 -->
<%! public String username_; %>
<!-- 声明一个变量用了存储cookie中的密码 -->
<%! public String password_;%>
<!-- 获取Cookie -->
<%
Cookie loginName=CookieUtil.getCookieByName(request, "username");
Cookie loginPassword=CookieUtil.getCookieByName(request, "password");
if(loginName!=null){
	username_=loginName.getValue();
		}else{
			username_="";
		}
if(loginPassword!=null){
	password_=loginPassword.getValue();
}else{
	password_="";
}
%>
<div id="loginin">
<h1>欢迎登陆</h1>
<form action="login" method="post">
<fieldset>
<div>
<input id="username" name="username" type="text" required="true" value="<%=username_%>" placeholder="用户名:" autofocus=""/>
</div>
<div>
<input id="password" name="password" type="password" value="<%=password_%>"  placeholder="密  码:"/>
</div>
</fieldset>
<fieldset>
<input type="checkbox" checked="checked"  name="checkbox" > 
          <span>记住密码</span>
</fieldset>
<fieldset id="chaolianjie">
<a href="#" style="text-decoration:none!important">找回密码</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.jsp"  style="text-decoration:none!important" >注册</a>
</fieldset>
<fieldset>
<input id="submit"  type="submit" value="登录" />
</fieldset>
</form>
</div>
</body>
</html>