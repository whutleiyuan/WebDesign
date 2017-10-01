<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
<style type="text/css">
.table{
margin-left:20px;
margin-right:20px;
width:95%;
padding:10px;
}

#btn-zero{
margin-left:350px;
/* width:50%; */
}

#btn-sort{
margin-left:510px;
}

.btn{
margin-left:20px;
}
</style>
<title></title>
</head>
<body>
<%
	  /* 得到所有的表头参数 */
		List list = (List) application.getAttribute("list");
	  /*  得到选中的表头参数 */
	    List tablelist=(List) request.getAttribute("tablelist");
	%>
<%-- <%=flag %> --%>
<h5 class="col-lg-1">抽出的表头：</h5>
<form action="normalization" method="post" id="tableheader"> 
<table class="table table-bordered table-hover"style="text-align：center">
<!-- 下面动态列出表头 -->
		<tr>
		<%
		for(int i=0;i<list.size();i++){
		
		%> 
			<td>
			<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>
			<input type="checkbox"  name="checkbox" value="<%=i %>" />
			<input type="text" name="headersort" style="width:30px;margin-left:33px;"/>
			 </td>
		<%
			}
		%>
		</tr>
</table>
	<input type="submit" value="归一化" class="btn btn-primary" onclick="document.getElementById('tableheadernor').submit();"  />

</form>
	<%-- <h5 class="col-lg-1">自定义排序</h5>
	<table class="table table-bordered table-hover"style="text-align：center">
	<tr>
	<%for(int i=1;i<11;i++)
{
%>
<td><input type="text"></td>
<%if(i%5==0){%>
<tr>
<%}%>
<%}%>
</tr>
</table>
<input type="button" id="btn-sort" class="btn btn-default" value="确认"/>
<%}%>
<h5 class="col-lg-1">重新选择表头处理方式：</h5>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mymodal2" data-backdrop="static"  id="btn-yes" >表头处理</button>
<form action="normalization" method="post" id="tableheader">    
    <div class="modal fade" id="mymodal2">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">表头处理</h4>
			</div>
			<div class="modal-body">
<div class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-lg-1">请选择你要处理的表:</label>
		<div class="col-lg-1">
			<select class="form-control" name="tableitem">
				<option value="1">表1</option>
				<option value="1">表2</option>
				<option value="1">表3</option>
				<option value="1">表4</option>
			</select>
		</div>
	</div>
</div>
<!-- <h5>此处列出查询出来的表头并给每个表头中空白地方补0（此处类容可动态改变）</h5> -->
<div class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-lg-1">请选择表头排序方式:</label>
		<div class="col-lg-11">
			<select class="form-control" name="tablesort">
				<option value="1">自定义排序（在弹出一个对话框在对话框中用户自己选择表头的顺序）</option>
				<option value="2">默认排序</option>
				<option value="3">对表头出现大小降序</option>
			</select>
		</div>
	</div>
</div>
 			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">关闭</button>
				<input  type="button" value="确认" class="btn btn-default" onclick="document.getElementById('tableheader').submit();"/>
			</div>
		</div>
	</div>
</div>
<h5 class="col-lg-1">归一化处理：</h5>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mymodal1" data-backdrop="static"  id="btn-yes" >归一 化</button>
 <div class="modal fade" id="mymodal1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">归一化</h4>
			</div>
			<div class="modal-body">
			<h5>正在进行归一化，请稍等</h5>
				<br>
				<div class="progress">
				    <div class="progress-bar-info" style="width:<%=50 %>%">50%</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">关闭</button>
				<button class="btn btn-default">保存</button>
			</div>
		</div>
		</div>
	</div> --%>
<!-- </form> -->
<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>