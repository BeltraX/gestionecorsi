<%@page import="com.milano.bc.model.Corso"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%
CorsoBC cbc = new CorsoBC();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Home</title>
<%

%>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp"/>
	<div class="container">

		<table class="table table-hover" style="width: 100%;">
			<thead>
				<tr>
					<th style="width: 200px;">Codice</th>
					<th style="width: 200px;">Nome</th>
				</tr>
			</thead>
			<tbody>
				<%
				Corso[] corsi = cbc.getCorsi();
				for (Corso i : corsi) {
				%>
				<tr>
					<%
					int codice = i.getCodice();
					String nome = i.getNome();
					%>
					<td><%=codice%></td>
					<td><%=nome%></td>
					<td>
						<form
							action="/<%=application.getServletContextName()%>/aggiungicarrello"
							method="post">
							<input type="hidden" name="id" value="<%=codice%>">
							<button type="submit" class="btn btn-primary btn-xm">
								<span class="glyphicon glyphicon-pencil"></span>
							</button>
						</form>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>