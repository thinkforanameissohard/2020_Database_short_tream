<%@ page contentType="text/html; charset=utf-8" import="java.sql.*" errorPage="error.jsp"%>
<html>
	<head>
		<meta charset="UTF-8">
		<link type="text/css" rel="stylesheet" href="css2/register.css">
		<title>分享</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "admin1", "123456789");
			String bno = request.getParameter("bno");
			String btime= request.getParameter("btime");
			String bno1 = request.getParameter("bno1");
			String bcontent = request.getParameter("introduction");
			Statement stmt = con.createStatement();
			String sql = "insert into bbs2(bno,btime,bno1,bcontent) values('" + bno + "','" + btime + "','" + bno1 + "','" + bcontent + "')";
			int i = stmt.executeUpdate(sql);
			if (i == 1) {
				out.println("<h2>分享成功！</h2><br/>");
				out.println("<a href='评论.jsp'>返回评论</a>");
			} else {
				out.println("<h2>分享失败！</h2><br/>");
				out.println("<a href='分享.html'>重新分享</a>");
			}
			stmt.close();
			con.close();
		%>
	</body>
</html>