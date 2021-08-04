<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Login</title>
</head>
<body>
<%
	
%>
<div class="container">
	<div class="page-header" id="page-header">
		<h3>Inserire i dati per effettuare il login</h3>
	</div>
	
	<form action="/<%=application.getServletContextName()%>/controlloAdmin" method="post"
	id="userForm" class="form-horizontal">
	
	<!------------------------------------------------- Nome -->
	<div class="form-group">
		<label class="col-md-2 control-label">Nome</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<input type="text" name="nome" id="nome" 
			placeholder="Nome..."
			class="form-control" maxlength="10">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoNome"></div>
	</div>
	
	<!------------------------------------------------- Cognome -->
	<div class="form-group">
		<label class="col-md-2 control-label">Cognome</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<input type="text" name="cognome" id="cognome" 
			placeholder="Cognome..."
			class="form-control" maxlength="10">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCognome"></div>
	</div>
	
	<!------------------------------------------------- Codice -->
	<div class="form-group">
		<label class="col-md-2 control-label">Codice</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<input type="text" name="codice" id="codice" 
			placeholder="Codice..."
			class="form-control" maxlength="10">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCodice"></div>
	</div>
	
	<div class="row">
		<div class="col-md-4 col-md-offset-2">
			<button type="submit" class="btn btn-warning">
				Login&nbsp;<span class="glyphicon glyphicon-log-in"></span>
			</button>
			<script type="text/javascript" src="/js/funzioni.js"></script>
		</div>
	</div>
	</form>	
	<%= 
		session.getAttribute("tentativi")
	%>
</div>
</body>
</html>