<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/allcss.jsp"  %>
</head>
<body>
<% String str1 = (String)session.getAttribute("name");

if(str1 == null){
	response.sendRedirect("userLogin.jsp");
} else{
%>

<%@include file="components/userNavbar.jsp" %>
		<h1 style="color:red ">Welcome To Home Page</h1>
		
		<%} %>
</body>
</html>