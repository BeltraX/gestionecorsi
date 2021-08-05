<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Error 404</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
	<div class="jumbotron">
		<h3>Error404</h3>
	</div>
	<div class="container-fluid">
		<h3>Per tornare alla home clicca qua </h3>
		<a href="home.jsp"><button class="btn btn-warning btn-lg">HOME</button></a>
	</div>
<footer>
<%@ include file="footer.html" %>
</footer>
</body>
</html>