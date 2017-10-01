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
<style type="text/css">
body {
	background-color: #eee;
	margin-bottom: 0px;
}

.jumbotron {
	margin-bottom: 0px;
}
</style>
<title>归一化</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Normalization</h1>
			<p>简单、直观的对数据进行快速处理。让数据处理变得更简单</p>
			<p>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#mymodal" data-backdrop="static">归一化</button>
			</p>
			<form action="normalization" method="post" id="tableheader">
			<div class="modal fade" id="mymodal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">归一化</h4>
						</div>
						<div class="modal-body">
							<h5>点击下方按钮，在归一化之前对表头进行预处理</h5>
							<div class="modal-footer">								
									<input type="button" value="是" class="btn btn-default"
									onclick="document.getElementById('tableheader').submit();" />
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br>
	</div>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript"
		src="./bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>