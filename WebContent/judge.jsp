<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 try{
	   request.setCharacterEncoding("UTF-8");
	   String name=request.getParameter("name");
	   String password=request.getParameter("password");
	  /*  System.out.print(name);
	   System.out.print(password); */
	   session.removeAttribute("name");
	   session.setAttribute("name", name);
	   if (name.equals("jsj") || name.equals("Administrator"))
	   {
	 	   response.sendRedirect("index.do");
	   }
	   else
	   {
		   response.sendRedirect("fail.html");
	   } 
	 }catch(Exception e)
	 {
		 response.sendRedirect("login.html");
	 }
  
   
 %>
</body>
</html>