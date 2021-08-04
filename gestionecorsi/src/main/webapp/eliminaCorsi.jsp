<%@page import="java.util.Date"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%@page import="com.milano.bc.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<meta charset="ISO-8859-1">
<title>Elimina Corsi</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">

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
					<th style="width: 200px;">Elimina</th>
				</tr>
			</thead>
			<tbody>
				<%
				CorsoBC corsoBC = new CorsoBC();
				Corso[] corsi = corsoBC.getCorsi();
				for (Corso i : corsi) {
					long dataInizio = i.getDataInizio().getTime();
					long dataOggi = new Date().getTime();
					if((dataInizio - dataOggi) > 0){
				%>
				<tr>
					<td><%=i.getNome()%></td>
					<td><%=i.getDataInizio()%></td>
					<td><%=i.getDataFine()%></td>
					<td><%=i.getCosto()%></td>
					<td><%=i.getCommento()%></td>
					<td><%=i.getAula()%></td>
					<td><%=i.getCodDocente()%></td>
					<td><form
								action="/<%=application.getServletContextName()%>/rimuoviCorso?codcorso=<%=i.getCodice()%>"
								method="post">
								<button type="submit" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
	</div>
<footer>
	<%@include file="footer.html" %>
</footer>
</body>
</html>