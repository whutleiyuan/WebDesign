<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ly.model.UserManager" %>
<%@page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<title>所有用户</title>
<style type="text/css">
.container{
margin-top:20px;
border:1px solid;
border-radius: 5px; 
}

.table {
    margin-top:20px;
	margin-left: 20px;
	margin-right: 20px;
	margin-bottom:30px;
	width: 95%;
	padding: 10px;
	border:1px solid;
	background-color:#F0F8FF;
	}
#back{
margin-left:15px;
}
</style>
</head>
<body>
<% /* 得到所有用户的集合 */ 
   List<UserManager> list= (List<UserManager>)application.getAttribute("list");
  int count=list.size();
%>
<div class="container">
<table class="table table-bordered table-hover " >
<tr>
<td>序号</td>
<td>昵称</td>
<td>用户名</td>
<td>密码</td>
<td>删除用户</td>
</tr>
<%for(int i=0;i<list.size();i++){
	UserManager um=list.get(i); %>
	<form action="deleteUser" method="post">
	<tr>
	<td><input type="text" value="<%=um.getId()%>" name="id" readonly = "readonly" style="border:none;"/></td>
	<td><input type="text" value="<%=um.getNickname()%>" name="nickname" readonly = "readonly" style="border:none;"/></td>
    <td><input type="text" value="<%=um.getUsername() %>" name="username" readonly = "readonly" style="border:none;"/></td>
    <td><input type="text" value="<%=um.getPassword() %>" name="password" readonly = "readonly" style="border:none;"/></td>
    <td><input type="submit" class="btn btn-default" value="删除" onclick="deleteUser()"></td>
	</tr>
	    </form>
<%} %>	
</table>

<form action="backnav" method="post">
<input type="submit" class="btn btn-primary" value="退出" id="back">
</form>
</div>
 <script type="text/javascript">
function deleteUser(){
	targetForm=document.forms[0];
	targetForm.action="deleteUser";	
	}
	
</script> 
<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>