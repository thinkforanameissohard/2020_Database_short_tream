<%@ page contentType="text/html; charset=utf-8" import="java.sql.*"
	errorPage="error.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>上传作业</title>
</head>
<body>
	<%
			request.setCharacterEncoding("utf-8");
			String hname = request.getParameter("hname");
			String sno = request.getParameter("sno");
			String tno = request.getParameter("tno");
			String cno = request.getParameter("cno");
			String htime = request.getParameter("htime");
			String hcontent = request.getParameter("hcontent");
		/* 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "admin1", "000000"); */
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=CouseManage", "sa", "rxy");
			Statement stmt = con.createStatement();
			String sql = "insert into homework(hname,sno,tno,cno,htime,hcontent) values('" + hname + "','" + sno + "','" + tno + "','" + cno + "','" + htime + "','" + hcontent + "')";
			int i = stmt.executeUpdate(sql);
			if (i == 1) {
				out.println("<h2>上传成功！</h2><br/>");
				out.println("<a href='sbase.jsp'>返回首页</a>");
			} else {
				out.println("<h2>上传失败！</h2><br/>");
				out.println("<a href='上传.html'>重新上传</a>");
			}
			stmt.close();
			con.close();		
		%>
</body>
</html>