<%@page import="java.util.ArrayList"%>
<%@page import="com.milano.bc.model.CorsoCorsista"%>
<%@page import="com.milano.bc.CorsoCorsistaBC"%>
<%@page import="com.milano.bc.model.Corso"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<meta charset="ISO-8859-1">
<title>Elenco corsi per corsista</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<%@include file="nav.jsp"%>
	<div class="container">
		<div class="page-header" id="page-header">
			<h3>Corsi per il corsista</h3>
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 300px;">Nome</th>
						<th style="width: 300px;">Data Inizio</th>
						<th style="width: 300px;">Data Fine</th>
						<th style="width: 300px;">Costo</th>
						<th style="width: 300px;">Eventuali Commenti</th>
						<th style="width: 300px;">Aula</th>
						<th style="width: 300px;">Codice Docente</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Corso> corsi = (ArrayList<Corso>)session.getAttribute("corsi");
						for(Corso c : corsi){
					%>
					<tr>
						<td><%=c.getNome()%></td>
						<td><%=c.getDataInizio()%></td>
						<td><%=c.getDataInizio()%></td>
						<td><%=c.getCosto()%></td>
						<td><%=c.getCommento()%></td>
						<td><%=c.getAula()%></td>
						<td><%=c.getCodDocente()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<a href="statistiche.jsp">
				<button class="btn btn-success">Ritorna alla pagina delle statistiche</button>
			</a>
		</div>
	</div>
	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>