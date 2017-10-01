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
<style type="text/css">
.table {
	margin-left: 20px;
	margin-right: 20px;
	width: 95%;
	padding: 10px;
}

#btn-zero {
	margin-left: 350px;
	/* width:50%; */
}

#btn-sort {
	margin-left: 510px;
}

.btn {
	margin-left: 20px;
}

input{
width:100px;
text-align:center;
}
</style>
<title>表头结果</title>
</head>
<body>
	<%
	  /* 得到所有的表头参数 */
		List list = (List) application.getAttribute("list");
	  /* 得到选中的表头参数 */
	    List tablelist=(List) application.getAttribute("tablelist");
	    String isfulfill=(String) request.getAttribute("isfulfill");
	  /* 表头对应的数据 */
	    String hasValue=(String) request.getAttribute("flag");
	    Map<String,List> map=(Map<String,List>) request.getAttribute("map");
	    
	%>
	<div  style="overflow-x: scroll;">
	<h5 class="col-lg-1">抽出的表头：</h5>
	<form action="tablenormalization" method="post" id="tableheadernor">
	<table class="table table-bordered " >
		<!-- 下面动态列出表头 -->
		<tr>
		<%
		for(int i=0;i<list.size();i++){
		   if(i!=list.size()/2){
		%> 
			<td>
			<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>
			<input type="checkbox"  name="checkbox" value="<%=i %>" />
			<input type="text" name="headersort" style="width:30px;margin-left:33px;"/>
			 </td>
			 <%}else{ %>
			 <tr>
			 <td>
			<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>
			<input type="checkbox"  name="checkbox" value="<%=i %>" />
			<input type="text" name="headersort" style="width:30px;margin-left:33px;"/>
			 </td>
			 <%} %>
			 <%} %>
		</tr>
	</table>
	<input type="submit" value="归一化" class="btn btn-default" onclick="document.getElementById('tableheadernor').submit();"  />
	</form>
			<!-- 显示选中的表头 -->
	<form action="table" method="post">
	<table class="table table-bordered table-hover" >
	<%if(tablelist!=null){ %>
			<tr>
		<%
		for(int i=0;i<tablelist.size();i++){
		%>
		     <th>
			<input type="text" value="<%=tablelist.get(i)%>" name="tableheader" readonly = "readonly"/>
			 </th>
	      				<%} %>
	      				</tr>
		<%} %>
			 	  
	</table>
		<% if(tablelist!=null){ %>
		<input type="submit" value="填充数据" class="btn btn-default" onclick="fulfilldata()"/>
		<% } %>
		 </form>
		 
		 <!-- 对选中的表头进行数据填充 -->
	<form action="savetable" method="post">
 		<table class="table table-bordered table-hover" >
       <%if(isfulfill!=null){ %>
		<%
		for(int i=0;i<tablelist.size();i++){
		%>
		     			<tr>		     
		     <td>
			<input type="text" value="<%=tablelist.get(i)%>" name="tableheader" readonly = "readonly"/>
			 </td>
           <% if(hasValue!=null){       	    		
 			 for (Map.Entry<String, List> entry : map.entrySet()) {
				 String tablekey=entry.getKey();
 				  if(tablekey.equals(tablelist.get(i))){  
				  List  listTest=entry.getValue();%>				  			
				 <%  for(int j=0;j<listTest.size();j++){%>				 
			 	<td><%=listTest.get(j)%></td>
			<% }}}}%> 
			 </tr>
				      <%} %>
		<%} %>
			 	  
	</table>
	 <% if(hasValue!=null){ %>
	<h5 class="col-lg-1">请输入表名：</h5>
	<input type="text" name="tablename"  required="true" placeholder="表的名字：" style="margin-left:20px;"/>
	<br>
	<input type="submit" value="保存" class="btn btn-default" onclick="saveTable()"/>
  <% } %>
	</form>
	</div>
	<script type="text/javascript">
	function fulfillData(){
		targetForm=document.forms[1];
		targetForm.action="fulfillData";
	}	
	</script>
	
	<script type="text/javascript">	
	function saveTable(){
		targetForm=document.forms[1];
		targetForm.action="saveTable";
	}
	
	</script>
	<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>