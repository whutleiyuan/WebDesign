<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
<title>首页</title>
<style type="text/css">
#carouselcontainer{
margin-left:50px;
margin-top:40px;
}

body{
background-color:#eee;
}
.carousel-caption{
bottom:350px;
right:600px;
}

#textposition{
bottom:300px;
left:700px;
}
</style>
</head>
<body>
<div id="carouselcontainer" class="carousel" data-ride="carousel" data-interval="5000" style="width: 92%; height: 500px;">
	<ol class="carousel-indicators" >
		<li class="action" data-target="#carouselcontainer" data-slide-to="0"></li>
		<li data-target="#carouselcontainer" data-slide-to="1"></li>
        <li data-target="#carouselcontainer" data-slide-to="2"></li>
        <li data-target="#carouselcontainer" data-slide-to="3"></li>
	</ol>
	<div class="carousel-inner" style="width:100%;height: 500px;">
		<div class="item active" >
			<a href="#"><img src="./images/1.jpg" alt="" /></a>
			<div class="carousel-caption">
			     <h3>方便、快速的处理数据</h3>
			</div>
		</div>
		<div class="item">
			<a href="#"><img id="position" src="./images/6.jpg" alt=""></a>
			<div class="carousel-caption" id="textposition">
			     <h3>快速对数据归一化</h3>
			     
			</div>
		</div>
		<div class="item">
			<a href="#"><img id="position" src="./images/3.jpg" alt=""></a>
			<div class="carousel-caption">
			     <h3>整理、分发一步到位</h3>
			</div>
		</div>
		<div class="item">
			<a href="#"><img id="position" src="./images/41.jpg" alt=""></a>
			<div class="carousel-caption">
			     <h3>准确输出、精准定位</h3>
			</div>
		</div>
	</div>
	<a href="#carouselcontainer" data-slide="prev" class="left carousel-control">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a href="#carouselcontainer" data-slide="next" class="right carousel-control">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>
<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>