<%@page import="com.milano.bc.model.Corso"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Home</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">

</head>
<body>
	<%@ include file="nav.jsp" %>

	<div class="container">
		<div class="page-header" id="page-header">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Data inizio</th>
						<th style="width: 200px;">Data fine</th>
						<th style="width: 200px;">Costo</th>
						<th style="width: 200px;">Commento</th>
						<th style="width: 200px;">Aula</th>
						<th style="width: 200px;">Codice docente</th>
					</tr>
				</thead>
				<tbody>
					<%
					CorsoBC cbc = new CorsoBC();
					Corso[] corsi = cbc.getCorsi();
					for (Corso i : corsi) {
					%>
					<tr>
						<td><%=i.getNome()%></td>
						<td><%=i.getDataInizio()%></td>
						<td><%=i.getDataFine()%></td>
						<td><%=i.getCosto()%></td>
						<td><%=i.getCommento()%></td>
						<td><%=i.getAula()%></td>
						<td><%=i.getCodDocente()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>