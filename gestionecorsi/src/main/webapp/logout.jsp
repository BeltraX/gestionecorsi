<%
	session.invalidate();
	application.setAttribute("tentativi", 0);
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Login</title>
</head>
<body>
<div class="jumbotron">
		<h3>LOGOUT EFFETTUATO CON SUCCESSO</h3>
	</div>
	<div class="container-fluid">
		<h3>Per tornare alla pagina di login clicca qua </h3>
		<a href="index.jsp"><button class="btn btn-warning btn-lg">LOGIN</button></a>
	</div>
<footer>
<%@ include file="footer.html" %>
</footer>
</body>
</html>