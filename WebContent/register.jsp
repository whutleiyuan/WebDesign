<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<title>管理员注册</title>
<style type="text/css">
body,h1,div,label,input{
color:#000000;
font-size:16px;
font-height:16px;
}

body{
background-image:url("./images/back.jpg");
background-repeat:no-repeat;
background-position:0% 0%;
}


.home{
position: absolute;   
top: 45%;   
left:50%;   
margin: -150px 0 0 250px;   
width: 300px;   
height: 400px; 
color:#000000;
border:2px solid;
border-radius: 7px;  
background-color:#F0F8FF;
display:block;

}

h1{
font-size:24px;
}

.homeform label{
font-famliy:宋体;
font-weight:600;
font-size:16px;
margin-left:15px;
}

.homeform input{
border:none;
border-bottom:1px solid;
padding:5px;
margin-top:30px;
margin-bottom:30px;
text-align:center;
font-height:10px;
background:#F0FFFF;

}

#submit{
width: 100px;   
min-height: 35px;      
background-color: #4a77d4;   
border: 1px solid #3762bc;   
color: #fff;   
padding: 9px 14px;   
font-size: 15px;   
line-height: normal;   
border-radius: 5px;  
margin-top:3px; 
margin-left:15px;
margin-right:15px;   

}

</style>
</head>
<body>
<div class="home">
	<h1>用户注册</h1>
	<div class="homeform">
		<form action="register" method="post" id="register">
		    <label for="nickname">昵&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
			<input type="text" name="nickname" required="true"  autofocus=""/><br>
			<label for="username">用户名：</label>
			<input type="text" name="username" required="true" /><br>
			<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
			<input type="password" name="password" required="true" /><br>
			</form>
			<div class="form-group" >
			<input type="submit" value="返回" id="submit" onclick="back()" form="back">
			<input type="submit" value="注册" id="submit" style="float:right;" form="register">
			</div>
	</div>
</div>
<form action="registerback" method="post" id="back"></form>
<script type="text/javascript">
function back(){
	targetForm=document.forms[0];
	targetForm.action="back";
}
</script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>