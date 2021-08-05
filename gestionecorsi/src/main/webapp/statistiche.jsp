<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.milano.bc.model.Docente"%>
<%@page import="com.milano.bc.model.Corsista"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%@page import="com.milano.bc.CorsistaBC"%>
<%@page import="com.milano.bc.DocenteBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Statistiche</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<%@include page="nav.jsp"  %>
	<div class="container">
		<table class="table table-hover" style="width: 100%;">
			<thead>
				<tr>
					<th style="width: 300px;">Numero corsisti totali</th>
					<th style="width: 300px;">Corso pi&ugrave frequentato</th>
					<th style="width: 300px;">Data inizio ultimo corso</th>
					<th style="width: 300px;">AVG durata</th>
					<th style="width: 300px;">Numero commenti</th>
				</tr>
			</thead>
			<tbody>
				<%
				CorsistaBC corsistaBC = new CorsistaBC();
				CorsoBC corsoBC = new CorsoBC();
				%>
				<tr>
					<td><%=corsistaBC.getTotale()%></td>
					<td><%=corsoBC.getMigliorCorso()%></td>
					<td><%=corsoBC.getDataUltimoCorso()%></td>
					<td><%=corsoBC.getAvgCorso()%></td>
					<td><%=corsoBC.getNumCommenti()%></td>
				</tr>
			</tbody>
		</table>
		<h3>Docenti con pi&ugrave tipologie di corso</h3>
		<table class="table table-hover" style="width: 100%;">
			<thead>
				<tr>
					<th style="width: 300px;">Nome</th>
					<th style="width: 300px;">Cognome</th>
					<th style="width: 300px;">CV</th>
					<th style="width: 300px;">Codice</th>
				</tr>
			</thead>
			<tbody>
				<%
				DocenteBC docenteBC = new DocenteBC();
				HashSet<Docente> docenti = docenteBC.getNumCorsi();
				for(Docente d:docenti){
				%>
				<tr>
					<td><%=d.getNomeDocente()%></td>
					<td><%=d.getCognomeDocente()%></td>
					<td><%=d.getCvDocente()%></td>
					<td><%=d.getCodDocente()%></td>
				</tr>
				<%
					} 
				%>
			</tbody>
		</table>
	</div>
	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>