<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp">
<link type="text/css" rel="stylesheet" href="./CSS/navigation.css" />
<link type="text/css" rel="stylesheet" href="./iconfont/iconfont.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<title>多任务人机交互系统</title>
<style type="text/css">
.sysmenu-item{
	position: relative; 
	margin: 0; 
	padding: 0;
	text-decoration:none!important;
}

.sysmenu-item a{
	padding: 12px 5px 12px 15px;
	display:block;
	border-left: 5px solid transparent; 
	color: #c2c2c2;
	border-bottom: 1px solid #e5e5e5;
}
.sysmenu-item a span{
	margin-left: 8px;
	font-size:14px;
	text-decoration:none;
}
.sysmenu-item:hover > a,.menu-item.active > a{
	color: #fff; 
	background: #4E5465; 
	border-left-color: #33AECC;
	transition: all .3s; 
	-webkit-transition: all .3s;
}
.sysmenu-item a span li{ 
	padding: 0;
	margin-right: 10px;
	float:right;
	}
.btn{
margin-left:50px;
margin-top:20px;
width:100px;
border:none;
color:#D3D3D3;
background-color:#D3D3D3;
}
</style>
</head>
<body onload="loadPage();">
	<div class="home">
		<!-- 定义首页面最上面的标题 -->
		<div class="home-page-top">
			<span class="page-logo">多任务人机交互系统</span>
			<!-- 在标题栏将用户名一起显示出来 -->
			<ul class="home-page-username">
				<li class=username-content>欢迎你！&nbsp;<span
					style="font-size: 13px"><%=session.getAttribute("nickname")%></span></li>
			</ul>
		</div>
		<!-- 导航菜单栏 -->
		<div class="home-side">
			<ul class="home-side-menu">
				<li class="header-menu-item">主菜单</li>
				<li class="menu-item" onclick="showMenu('caidanyangshi');">
				<a href="javascript:;"> <i class="iconfont-left icon-data"></i> <span>数据归一化</span>
						<i class="iconfont-right icon-jiantou"></i>
				</a>
					<ul class="menu-item-child" id="caidanyangshi"
						style="display: block">
						<!-- 子菜单1 -->
						<li><a href="normalization.jsp" data-id="normalization.jsp">
								<i class="iconfont-left icon-wendang"></i> <span>归一化</span>
						</a></li>
						<!-- 子菜单2 -->						
					</ul></li>
				<!-- 一级菜单2插入点 -->
				<li class="menu-item" onclick="showMenu('data')"><a
					href="javascript:;"> <i class="iconfont-left icon-data"></i> <span>归类与汇总</span>
						<i class="iconfont-right icon-jiantou"></i>
				</a>
					<ul class="menu-item-child" id="data" style="display: block;">
						<li><a href="gather.jsp" data-id="gather.jsp"> <i
								class="iconfont-left icon-wendang"></i> <span>汇总</span>
						</a></li>
						<li><a href="classify.jsp" data-id="classify.jsp"> <i
								class="iconfont-left icon-wendang"> <span>归类</span>
							</i>
						</a></li>
					</ul></li>
				<li class="menu-item" onclick="showMenu('outData');"><a
					href="javascript:void(0);"> <i class="iconfont-left icon-data"></i>
						<span>分解与分发</span> <i class="iconfont-right icon-jiantou"></i>
				</a>
					<ul class="menu-item-child" id="outData" style="display: block;">
						<li><a href="javascript:void(0);"> <i
								class="iconfont-left icon-wendang"></i> <span>分解</span>
						</a></li>
						<li><a href="distribute.jsp" data-id="distribute.jsp"> <i
								class="iconfont-left icon-wendang"> <span>分发</span>
							</i>
						</a></li>
					</ul></li>
				<!-- 下面为系统操作的菜单设计 -->
				<li class="header-menu-item">系统维护</li>
				<li class="sysmenu-item" onclick="showMenu('userManager')"><a
					href="##"> <i class="iconfont-left icon-data"></i> <span>用户管理</span>
						<i class="iconfont-right icon-jiantou"></i>
				</a>
					<ul class="menu-item-child" id="userManager"
						style="display: block;">
						<li><a href="checkuser.jsp"  target="_self"> 
						<i class="iconfont-left icon-wendang"></i> <span>查看用户</span>
						</a></li>
						<li><a href="modifypass.jsp" target="_self"> <i
								class="iconfont-left icon-wendang"> <span>修改密码</span>
							</i>
						</a></li>
					</ul></li>
				<!-- 系统管理 -->
				<li class="sysmenu-item" onclick="showMenu('systemManager')"><a
					href="javascript:;"> <i class="iconfont-left icon-data"></i> <span>系统管理</span>
						<i class="iconfont-right icon-jiantou"></i>
				</a>
					<ul class="menu-item-child" id="systemManager"
						style="display: block;">
						<li>
						<form action="exitsystem" method="post" >
						<input type="submit" class="btn btn-default" value="退出" onclick="exitSystem()">
						</form>
						</li>
					</ul></li>
			</ul>
		</div>
		<!-- 选项卡布局 -->
		<section class="layout-main">
		<div class="layout-main-tab">
			<button class="tab-btn">
				<i class="iconfont-left icon-home"></i>
			</button>
			<nav class="tab-nav">
			<div class="tab-nav-content" style="margin-left: 0px;">
				<a href="javascript:void(0);" class="content-tab active"
					data-id="home.jsp"> 首页 </a>
			</div>
			</nav>

		</div>
		<div class="layout-main-body">
			<iframe name="iframe" width="100%" height="100%" class="body-iframe"
				src="home.jsp" frameborder="0" data-id="home.jsp" seamless=""></iframe>
		</div>
		</section>
	</div>
	<script type="text/javascript">
function exitSystem(){
	targetForm=document.forms[1];
	targetForm.action="exitSystem";	
	}	
</script> 
	<script type="text/javascript" src="./js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="./js/common.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>