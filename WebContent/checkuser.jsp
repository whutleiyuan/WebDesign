<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<title>查看用户</title>
<style type="text/css">
.container{
position: absolute;   
top: 50%;   
left:45%;  
margin: -150px 0 0 -150px;   
color:#000000;
display:block;

}

.btn{
margin-left:100px;
}
#back1{
margin-left:70px;
}
</style>
</head>
<body>
<form action="admin" method="post">
	<div class="container">
		<div class="row">
			<div class="form-group ">
				<label for="textUserName" class="col-sm-1">用户名</label> 
				<div class="col-sm-3">
				<input type="text"class="form-control" name="username" id="textUserName" placeholder="管理员用户名" autofocus="" required="true" />
			</div>
			</div>
			</div>
			<div class="row">
			<div class="form-group " >
			<br>
				<label for="textPassWord" class="col-sm-1">密&nbsp;&nbsp;&nbsp;码</label>
				<div class="col-sm-3">
				 <input type="password" class="form-control" name="password" id="textPassWord" placeholder="管理员密码" required="true"  />
			</div>
			</div>
			</div>
			<div class="form-group" >
			<br>
				<input type="submit" class="btn btn-primary col-sm-1" value="登陆" onclick="validateUser()"/>
				<input type="submit" class="btn btn-primary col-sm-1" value="返回" form="back" id="back1">
			</div>
	</div>
	</form>
	
<form action="backnav" method="post" id="back">
</form>
<script type="text/javascript">
function validateUser(){
	targetForm=document.forms[1];
	targetForm.action="validateUser";
}
</script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>