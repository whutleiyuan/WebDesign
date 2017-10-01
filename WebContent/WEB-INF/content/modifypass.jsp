<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet" href="./iconfont/iconfont.css" />
	
<title>修改密码</title>
<style type="text/css">
html body{
overflow:hidden;
}
 .home{
	margin: 0 auto;
	font-size: 16px;
	text-decoration:none;	
}
/*为页面顶层的内容设置样式*/
.home-page-top{
	position:relative;
	border-bottom: 0px solid #33AECC;
	height:55px;
	background-color:RGB(14,124,249);
	z-index:1000;
}
/*为顶层标题设置样式*/
.page-logo{
	margin-left: 10px;
	color:#fff;
	line-height:45px;
	font-size:16px;
}
/*为用户设置样式*/
.home-page-username{
	float:right;
	color:#fff;
	line-height:45px;
	margin-right:200px;
}

input{
margin-left:50px;
border:none;
background-color:RGB(14,124,249);
}

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

.zhineng{
height:100px;
background-color:RGB(245,245,245);
line-height:100px;
}
.zhineng a{
margin-left:450px;
}
.zhineng a span{
color:RGB(14,124,249);
}

#one{
margin-left:50px;
margin-bottom:50px;
text-align:center;
}

.form-group{
margin-top:30px;
}

.btn{
margin-left:50px;
background-color:RGB(14,124,249);
color:#fff;

}

#footer{
background-color:RGB(245,245,245);
padding:none;
margin:430px 0 0 0;
height:100px;
width:100%;
}

p{
margin-top:10px;
font-size:14px;
line-height:20px;
text-align:center;
}

.error{
color:red;
}
</style>
</head>
<body>
	<div class="home">
		<div class="home-page-top">
			<span class="page-logo">多任务人机交互系统</span>
			<!-- 在标题栏将用户名一起显示出来 -->
			<ul class="home-page-username">
				<li class=username-content>欢迎你！&nbsp;<span
					style="font-size: 13px"><%=session.getAttribute("nickname")%></span>
				<input type="submit"  value="退出" form="back">
				</li>
			</ul>
		</div>
		<div class="zhineng">
		<a href="##"> <i class="iconfont-left icon-zhineng1" style="font-size:30px;"></i>
		 <span>恭喜你！现在可在下方修改密码</span>
		</a>
		</div>
		
		<form action="affirmmodify" method="post">
		<div class="container">
		<span id="one">请设置新密码：</span>
		<div class="row">
			<div class="form-group ">				
				<div class="col-sm-3">
				<input type="password"class="form-control" name="password" id="textUserName" placeholder="用户密码" autofocus="" required="true" />
			</div>
			</div>
			</div>
			
		<span id="one">再次输入新密码：</span>
		<div class="row">
			<div class="form-group ">				
			<div class="col-sm-3">
				<input type="password"class="form-control" name="rpassword" id="textUserName" placeholder="用户密码" autofocus="" required="true" />					      
			</div>	        			
			</div>
			<s:fielderror class="error" style="float:left;"/>	
			</div>
			<br>
			<input type="submit" class="btn col-sm-1" value="确认"  >
			<br>		
		</div>
		</form>
		
		<div id="footer">
		<p id="yejiao">2017年本科生毕业论文设计</p>
		<p>系统设计人：武汉理工大学电信1306班雷远；指导老师：黄龙庭</p>
		</div>
		</div>	
<form action="backnav" method="post" id="back"></form>
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