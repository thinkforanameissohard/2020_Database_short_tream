<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生作业管理系统</title>
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,700">
<link rel="stylesheet" href="css/style.min.css">
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<style type="text/css">
.glyphicon {
	margin-right: 5px;
}

.btn-wrapper {
	padding: 1em 0;
}

.thumbnail {
	margin-bottom: 20px;
	padding: 0px;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px;
}

.item.list-group-item {
	float: none;
	width: 100%;
	background-color: #fff;
	margin-bottom: 10px;
}

.item.list-group-item:nth-of-type(odd):hover, .item.list-group-item:hover
	{
	background: #428bca;
}

.item.list-group-item .list-group-image {
	margin-right: 10px;
}

.item.list-group-item .thumbnail {
	margin-bottom: 0px;
}

.item.list-group-item .caption {
	padding: 9px 9px 0px 9px;
}

.item.list-group-item:nth-of-type(odd) {
	background: #eeeeee;
}

.item.list-group-item:before, .item.list-group-item:after {
	display: table;
	content: " ";
}

.item.list-group-item img {
	float: left;
}

.item.list-group-item:after {
	clear: both;
}

.list-group-item-text {
	margin: 0 0 11px;
}

.htmleaf-header {
	background-color: #CDDC39;
	background:
		url("https://pic2.zhimg.com/80/v2-d6cd650d4886b6dd7e9f5f62591f8b41_720w.jpg");
	background-size: 100%;
}

body {
	background-color: white;
	color: #000000;
}

#footer {
	bottom: 20px;
	position: fixed;
	text-align: center;
	left: 38%;
}

.btn-wrapper {
	text-align: center;
}

.thumbnail {
	padding: 10px;
}

.col-md-6 {
	text-align: center;
}

.item.list-group-item {
	left: 10%;
	width: 80%;
}
</style>
<style type="text/css">
#table th {
	display: block;
	width: 80px;
}

#table tr {
	display: inline-flex;
	margin-top: 10px;
	margin-bottom: 10px;
	margin-left: 60px;
	font-size: 16px;
}

input {
	border-radius: 5px;
}

.input1 {
	margin-left: 67px;
	margin-right: 60px;
}

.change {
	left: 800px;
	display: block;
	margin-left: 750px;
	margin-top: 100px;
}

.input2 {
	width: 300px;
	text-align: center;
}

textarea {
	text-align: left;
}
</style>
</head>

<body>

	<header class="header htmleaf-header">
	<h1>
		学生作业管理管理<span>Welcome to our system</span>
	</h1>
	</header>
	<center>

		<form>

			<input type="button" value="上传作业"><a href="上传.html">上传作业</a></input>
			<br> <input type="button" value="浏览作业"><a href="浏览.jsp">浏览作业</a></input>
			<br> <input type="button" value="下载作业"><a
				href="下载.html">下载作业</a></input><br>
		</form>
		<br>
		<button class="submit" type="cancle" style="color: green">取消</button>
	</center>


</body>
</html>