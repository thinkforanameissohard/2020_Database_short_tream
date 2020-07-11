<%@ page language="java" import="java.sql.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="org.dao.DBBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>浏览作业</title>
<link type="text/css" rel="stylesheet" href="css/register.css">
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:300,700">
<link rel="stylesheet" href="css/style.min.css">
<link
	href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<link type="text/css" rel="stylesheet" href="css/work.css">
</head>
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

body {
	background-color: #CDDC39;
	background:
		url("https://pic2.zhimg.com/80/1d4b229e2e625a236a57fb44b67f6f7b_720w.jpg");
	background-size: 100%;
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
<%
request.setCharacterEncoding("utf-8");
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
/* Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=CouseManage", "sa","123456"); */
Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=CouseManage", "sa", "rxy");
String id=(String)session.getAttribute("id");
String sql="select * from homework where sno= '"+id+"'";
DBBean jdbc=new DBBean();
ResultSet rs=jdbc.executeQuery(sql);
rs.next();
		%>
<body>


	<center class="input2 safe">


		<form class="change" action="ceditsave.do"
			onsubmit="return is_empty()" method="post">
			<table id="table" style="width: 800px;">
				<tr>
					<th width="30%">上传者：</th>
					<td width="70%"><input name="hname" class="input2 Safe"
						type="text" value="<%=rs.getString(2)%>"></input></td>
				</tr>
				<tr>
					<th width="30%">学号：</th>
					<td width="70%"><input name="sno" class="input2 Safe"
						type="text" readonly value="<%=rs.getString(1)%>"></input></td>
				</tr>
				<tr>
					<th width="30%">课程号：</th>
					<td width="70%"><input name="cno" class="input2 Safe"
						type="text" value="<%=rs.getString(3)%>"></input></td>
				</tr>
				<tr>
					<th width="30%">上传时间：</th>
					<td width="70%"><input name="htime" class="input2 Safe"
						type="text" value="<%=rs.getString(6)%>"></input></td>
				</tr>
				<tr>
					<th width="30%">上传内容：</th>
					<td width="70%"><input name="hcontent" class="input2 Safe"
						type="text" value="<%=rs.getString(5)%>"></input></td>
					<br>

					<th>

						<button class="cancle" type="submit">
							<a href="浏览.jsp">浏览</a>
						</button>
						<button class="cancle" type="submit">
							<a href="浏览.jsp">下载</a>
						</button>
						<button class="cancle" type="cancle">取消</button>
					</th>
				</tr>
			</table>
		</form>

	</center>

</body>
</html>