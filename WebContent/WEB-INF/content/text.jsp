<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="./bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" />
<title>Insert title here</title>
<style type="text/css">
.container{
margin-top:20px;
margin-bottom:10px;
border:1px solid;
border-radius: 5px; 
}

input{
margin-right:20px;
}

.form-group{
margin-left:700px;
}

.sort{
margin-top:0px;
}

.drag{
display:inline-block;
padding:10px;
background-color:#aaa;
margin: 3px;
}
div>div{
display:inline-block;
padding:10px;
background-color:#aaa;
margin:3px;
}
</style>
</head>
<body>
	<%
     //得到所有的表头参数 
	    List list = (List) request.getAttribute("list1");
	//得到跟踪待处理对话框下一步的参数
	    String flag=(String)session.getAttribute("flag");
	//得到跟踪待处理确定按钮的参数
	    String status=(String)session.getAttribute("status");
    //得到跟踪表头处理对话框显示与隐藏的参数
        String norsort=(String)session.getAttribute("norsort");
    //得到跟踪归一化对话框显示与隐藏的参数
        String nor=(String)session.getAttribute("nor");
	//得到处理之后的表头
	    List tablelist = (List) application.getAttribute("tablelist");
	//得到排序后的表头
	    List norlist = (List) request.getAttribute("norlist");
	%>
<%if(status!=null){ %>
<form action="tablenormalization" method="post" id="one">
<div class="container">
<div class="checkbox">
<label>1、请选择要处理的表：</label>
<label>
<input type="checkbox" value="tableone" name="checkbox"><span>表一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
<input type="checkbox" value="tabletwo" name="checkbox"><span>表二&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
<input type="checkbox" value="tablethree" name="checkbox"><span>表三&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
</label>
</div>
</div>
<input type="submit" value="确定" class="btn btn-info col-lg-3" style="margin-left:500px;" onclick="tablenor()">
<%} %>
</form>
<form method="post" action="back" id="back"></form>
<%if(flag!=null){ %>
<div class="container">
<span>2、待处理：</span><br>
<form action="backandnext" method="post" id="two">
<%
		for(int i=0;i<list.size();i++){
		%> 
					<input type="text" value="<%=list.get(i)%>" name="tableheader" readonly = "readonly"/>
<%} %>
</form>
			<div class="form-group" >
			
				<input type="submit" class="btn btn-success" value="返&nbsp;&nbsp;回" onclick="backnor()" form="back" />
				<input type="submit" class="btn btn-success" value="下一步" onclick="next()" form="two"/>
			</div>
</div>
<%} %>

<%if(norsort!=null){ %>
<div class="container">
<span>2、表头处理</span><br>
<%
		for(int i=0;i<tablelist.size();i++){
		%>
		 <div class="drag" draggable="true" ondragstart="dsHandler(event);">
			<input type="text" value="<%=tablelist.get(i)%>" name="tableheader" readonly = "readonly"/>
		</div>
<%} %>
<form action="upstep" method="post" id="upstep"></form>
<form action="tablesort" method="post" id="nextstep">
<div id="dest" style="width:800px;height:400px;border:1px solid black;float:left">
<h4 ondragleave="return false">自定义排序</h4>
</div>
</form>
<img id="gb" draggable="false" src="./images/garbage.png" alt="垃圾桶" style="float:left;"/>
<input type="submit" class="btn btn-success" value="上一步" onclick="upstep()" form="upstep" style="float:left;margin-top:50px;margin-bottom:10px;margin-left:20px" />
<input type="submit" class="btn btn-success" value="下一步" onclick="nextstep()" form="nextstep" style="float:left;margin-top:20px;margin-bottom:10px;margin-left:20px" />
</div>
<%} %>

<%if(nor!=null){ %>
<div class="container">
<span>2、各表归一化</span><br>
<%for(int i=0;i<norlist.size();i++){%>
	<input type="text" value="<%=norlist.get(i)%>" name="tableheader" readonly = "readonly" style="width:100px;"/>
<%} %>
<div class="form-group" >
<form action="norupstep" method="post" id="norup"></form>
<form action="nornextstep" method="post" id="nornext"></form>
<input type="submit" class="btn btn-success" value="上一步" onclick="norupstep()" form="norup"  />
<input type="submit" class="btn btn-success" value="完&nbsp;&nbsp;成" onclick="nornextstep()" form="nornext"  />
</div>
</div>
<%} %>
</body>
 <script type="text/javascript">
 /* 选中表后对应操作按钮的监听 */
function tablenor(){
	targetForm=document.forms[1];
	targetForm.action="tablenor";	
	}

 /* 待处理对话框的返回按钮监听事件 */
function backnor(){
	targetForm=document.forms[2];
	targetForm.action="backnor";	
	}

 /* 待处理对话框的下一步按钮监听事件 */
function next(){
	targetForm=document.forms[3];
	targetForm.action="next";	
	}
 
 /* 表头处理对话框中的上一步按钮监听事件 */
 function upstep(){
	targetForm=document.forms[4];
	targetForm.action="upstep";	
	}
 
 /* 表头处理对话框中的下一步按钮监听事件 */
  function nextstep(){
	targetForm=document.forms[5];
	targetForm.action="nextstep";	
	}
 /* 各表归一化对话框对应的上一步按钮 */
  function norupstep(){
	targetForm=document.forms[6];
	targetForm.action="norupstep";	
	}
 
 /* 各表归一化对话框的下一步按钮 */
   function nornextstep(){
	targetForm=document.forms[7];
	targetForm.action="nornextstep";	
	}
</script>

<script type="text/javascript">
</script>
<script type="text/javascript">
var dest = document.getElementById("dest");
//开始拖动的时间监听器
var dsHandler = function(evt){
	//将被拖动元素的innerHtml属性设置成被拖动的数据
	evt.dataTransfer.setData("Text/plain","<item>"+evt.target.innerHTML);	
}
dest.ondrop = function(evt){
	var text=evt.dataTransfer.getData("Text/plain");
	//如果该text以<item>开头
	if(text.indexOf("<item>")== 0){
		//创建一个新的div元素
		var newEle=document.createElement("div");
		//以当前时间为该元素生成一个id
		newEle.id=new Date().getUTCMilliseconds();
		//该元素内容为托过来的数据
		newEle.innerHTML = text.substring(6);
		//设置钙元素允许拖动
		newEle.draggable="true";
		//为该元素设置动作监听器
		newEle.ondragstart = function(evt){
			evt.dataTransfer.setData("Text/plain","<remove>"+newEle.id);	

		}
		dest.appendChild(newEle);
	}
}
//当吧被拖动元素"放"到垃圾桶上时触发该方法
document.getElementById("gb").ondrop = function(evt){
	var id=evt.dataTransfer.getData("Text/plain");
	//如果id以<remove>开头
	if(id.indexOf("<remove>")==0){
		//根据托过来的数据获取被拖动的元素
		var target = document.getElementById(id.substring(8));
		//删除被拖动的元素
		dest.removeChild(target);
		
	}
}
document.ondragover=function(evt){
	return false;
}

document.ondrop = function(evt){
	return false;
}
</script>
<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>