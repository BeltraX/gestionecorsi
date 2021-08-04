<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Inserisci Corsisti</title>
</head>
<body>
<%
	
%>
<div class="container">
	<div class="page-header" id="page-header">
		<h3>Inserire i dati del corsista</h3>
	</div>
	
	<form action="/<%=application.getServletContextName()%>/inserisciCorsisti" method="post"
	id="insForm" class="form-horizontal">
	
	<!------------------------------------------------- Nome -->
	<div class="form-group">
		<label class="col-md-2 control-label">Nome</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
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
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="cognome" id="cognome" 
			placeholder="Cognome..."
			class="form-control" maxlength="10">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCognome"></div>
	</div>
	
	<!------------------------------------------------- Corso -->
	<div class="form-group">
		<label class="col-md-2 control-label">Corso</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="corso" id="corso" 
			placeholder="Corso..."
			class="form-control" maxlength="10">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCorso"></div>
	</div>
	
	<!------------------------------------------------- DataInizio -->
	<div class="form-group">
		<label class="col-md-2 control-label">Data Inizio</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
			</span>
			<input type="text" name="datainizio" id="datainizio" 
			placeholder="DD/MM/YYYY..."	class="form-control">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoDataInizio"></div>
	</div>
	
	<!------------------------------------------------- DataFine -->
	<div class="form-group">
		<label class="col-md-2 control-label">Data Fine</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-calendar"></i>
			</span>
			<input type="text" name="datafine" id="datafine" 
			placeholder="DD/MM/YYYY..."	class="form-control">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoDataFine"></div>
	</div>
	
	<!------------------------------------------------- Commento -->
	<div class="form-group">
		<label class="col-md-2 control-label">Commenti</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon"></i>
			</span>
			<textarea name="commento" id="commento"
						placeholder="Commento..." cols="40" rows="3"
						class="form-control" style="resize: none">
						</textarea>
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCommento"></div>
	</div>
	
	<!------------------------------------------------- PreFormativi -->
	<div class="form-group">
		<label class="col-md-2 control-label">precedenti formativi</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCommento"></div>
	</div>
	
	</form>
</div>

</body>
</html>