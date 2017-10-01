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
<title>邮件分发</title>
</head>
<body>
<form action="email" method="post" enctype="multipart/form-data">
<div class="container">
<div class="form-group">
<label class="txtUserNmae" >发件人昵称</label>
<input type="text" class="form-control" name="emailsentname" placeholder="收件人昵称">
</div>
<label class="txtUserNmae" >收件人</label>
<div class="input-group">
<input type="text" class="form-control" name="emailgetname" placeholder="收件人">
<span class="input-group-addon" name="emailgetname">@qq.com</span>
</div>
<div class="form-group">
<label class="txtUserNmae" >主题</label>
<input type="text" class="form-control" name="emailtitle" placeholder="主题">
</div>
<div class="form-group">
<label class="txtUserNmae" >内容</label>
<input type="text" class="form-control" name="emailcontent" >
</div>
<div class="form-group">
<label class="txtUserNmae" >附件</label>
<input type="file" class="form-control" name="file" >
</div>
<div class="form-group">
<label class="txtUserNmae" ></label>
<input type="submit" class="btn btn-primary" placeholder="发送" onclick="sentemail()">
</div>
</div>
</form>
<script type="text/javascript">
function senteamil(){
	targetForm=document.forms[0];
	targetForm.action="sentemail";
}
</script>
<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>