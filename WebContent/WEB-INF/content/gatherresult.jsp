<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %> 
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<title>汇总结果</title>
<style type="text/css">
.table {
	margin-left: 20px;
	margin-right: 20px;
	margin-bottom:30px;
	width: 95%;
	padding: 10px;
	border:1px solid;
	background-color:#F0F8FF;
}

.btn {
	margin-left: 20px;
}

input{
width:100px;
text-align:center;
}
span{
	margin-left: 20px;
}

.container{
margin-top:20px;
border:1px solid;
border-radius: 5px; 
}

.vergraph{
border:1px solid;
border-top:none;
border-right:none;
height:150px;
width:200px;
margin-left:350px;
margin-top:-5px;
margin-bottom:20px;
}

.graph{
margin-top:49.2px;
margin-left:15px;
width:20px;
height:100px;
margin-bottom:0px;
padding-left:0px;
background:	#48D1CC;
}
</style>
</head>
<body>
	<%
	  /* 获得未汇总的表头 */
		List list = (List) application.getAttribute("list");	
    /* 获得分类选择 */
        String classifysel=(String)request.getAttribute("classify");
    /* 过的归类选择 */
       String classify=(String)request.getAttribute("classifysel");
	%>
		<div class="container">
	    <span>未汇总:</span>
		<table class="table table-bordered table-hover " >
		<!-- 下面动态列出表头 -->
		<tr>
		<%
		for(int i=0;i<list.size();i++){
		   if(i!=list.size()/2){
		%> 
			<td>
			<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>		
			 </td>
			 <%}else{ %>
			 <tr>
			 <td>
			<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>			
			 </td>
			 <%} %>
			 <%} %>
		</tr>
	</table>
	
	
	<span>已汇总:</span>
	<form action="date" method="post">
	<table class="table table-bordered table-hover" >
	<tr>
	<td>
			<input type="submit" class="btn btn-info " value="第1天" name="time" onclick="hasgather()"/>	
			<input type="submit" class="btn btn-success" value="第2天" name="time" onclick="hasgather()"/>
			<input type="submit" class="btn btn-primary" value="第3天" name="time" onclick="hasgather()"/>
			<input type="submit" class="btn btn-primary" value="第4天" name="time" onclick="hasgather()"/>
			<input type="submit" class="btn btn-primary" value="第5天" name="time" onclick="hasgather()"/>
			<input type="submit" class="btn btn-primary" value="第6天" name="time" onclick="hasgather()"/>
			<input type="submit" class="btn btn-primary" value="第7天" name="time" onclick="hasgather()"/>	
	</td>
	</tr>
	</table>
	</form>
	<!-- 归类选项 -->
	<form action="classify" method="post">
	<table class="table table-bordered table-hover" >
	<% if(classifysel !=null){ %>
	<span>数据透视:</span>
		<tr>
	<td>
			<input type="submit" class="btn btn-info " value="按客户分类" name="classify" onclick="classify()"/>	
			<input type="submit" class="btn btn-success" value="按队分类" name="classify" onclick="classify()"/>
			<input type="submit" class="btn btn-primary" value="按件数分类" name="classify" onclick="classify()"/>				
	</td>
		</tr>
	<%} %>
	</table>
	</form>	
	<!-- 归类之后所得相关信息的直方图 -->
	<%if(classify!=null){ %>
	<div class="vergraph">
	<p>
		<input type="text" class="graph" value="10" style="border:none;" />	
	    <input type="text" class="graph" value="10" style="border:none;" />	
	    <input type="text" class="graph" value="10" style="border:none;"/>	
	    <input type="text" class="graph" value="10" style="border:none;"/>	
	    
	</p>
	</div>
	<%} %>
	<form action="gather" method="post" >
			
				<button type="submit" class="btn btn-primary" >汇总</button>
				<button type="submit" class="btn btn-primary" name="classify" value="classify">归类</button>
					
</form>
</div>
<script type="text/javascript">
function classify(){
	targetForm=document.forms[0];
	targetForm.action="classify";	
}

function hasgather(){
	targetForm=document.forms[1];
	targetForm.action="hasgather";
} 
</script>
	<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>