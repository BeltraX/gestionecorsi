<%@page import="com.milano.bc.model.Docente"%>
<%@page import="com.milano.bc.DocenteBC"%>
<%@page import="com.milano.bc.model.Corso"%>
<%@page import="com.milano.bc.CorsoBC"%>
<%@page import="com.milano.architecture.dao.CorsoDAO"%>
<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Inserisci Corsisti</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
<%
	
%>
<div class="container">
	<div class="page-header" id="page-header">
		<h3>Inserire i dati del corsista</h3>
		<%
			if(session.getAttribute("flag") != null){
		%>
		<h3>Reinserire i dati del corsista correttamente</h3>
		<%
			}
		%>
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
			class="form-control" maxlength="30">
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
			class="form-control" maxlength="30">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCognome"></div>
	</div>
	
	<!------------------------------------------------- Corso -->
	
	<div class="form-group">
		<label class="col-md-2 control-label" for="corso">Corso</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			
			<%
				CorsoBC corsoBC = new CorsoBC();
				Corso[] corsi = corsoBC.getCorsi();
			%>
			<select name="corso" id="corso">
			<% 
				for(int i = 0; i < corsi.length; i++){
			%>
  				<option value="<%=corsi[i].getCodice()%>"><%=corsi[i].getNome()%></option>
  			<%
				}
  			%>
			</select>
			&nbsp;
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  				Crea Nuovo Corso
			</button>
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoCorso"></div>
	</div>
	
	
	
	<!------------------------------------------------- PreFormativi -->
	<div class="form-group">
		<label class="col-md-2 control-label">precedenti formativi</label>
		<div class="col-md-5 inputGroupContainer">
			<div class="input-group">
			<input type="radio" id="preformativisi" name="preformativi" value="1">
			<label for="preformativi">Si</label>
         	<input type="radio" id="preformativino" name="preformativi" value="0"
         	checked>
         	<label for="preformativino">No</label>
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoPreFormativi"></div>
	</div>
	
	
	
	<div class="row">
		<div class="col-md-4 col-md-offset-2">
			<button type="submit" class="btn btn-warning">
				Inserisci Corsista
				&nbsp;<span class="glyphicon glyphicon-log-in" ></span>
			</button>
		</div>
	</div>
	
	</form>
</div>
<footer>
	<%@include file="footer.html"%>
</footer>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h3 class="modal-title" id="exampleModalLabel">Crea Nuovo Corso</h3>
        <%
			if(session.getAttribute("flagCorso") != null){
		%>
		<h3>Reinserire i dati del corso correttamente</h3>
		<%
			}
		%>
      </div>
      <div class="modal-body">
        <form action="/<%=application.getServletContextName()%>/inserisciCorsi" method="post"
		id="insCorsoForm" class="form-horizontal">
			<div class="form-group">
				<label class="col-md-2 control-label">Corso</label>
				<div class="col-md-5 inputGroupContainer">
					<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="corso" id="corso" 
					placeholder="Corso..."
					class="form-control" maxlength="30">
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
					placeholder="DD/MM/YYYY..."	class="form-control"
					maxlength="10">
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
					placeholder="DD/MM/YYYY..."	class="form-control"
					maxlength="10">
					</div>
				</div>
			<div class="col-md-7 control-label" id="infoDataFine"></div>
			</div>
			
			<!------------------------------------------------- Costo -->
			<div class="form-group">
				<label class="col-md-2 control-label">Costo</label>
				<div class="col-md-5 inputGroupContainer">
					<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-euro"></i>
					</span>
					<input type="text" name="costo" id="costo" 
					placeholder="00.00"
					class="form-control" maxlength="11">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCosto"></div>
			</div>
	
			<!------------------------------------------------- Commento -->
			<div class="form-group">
				<label class="col-md-2 control-label">Commenti</label>
				<div class="col-md-5 inputGroupContainer">
					<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-pencil"></i>
					</span>
					<textarea name="commento" id="commento"
						placeholder="Commento..." cols="40" rows="3"
						class="form-control" style="resize: none"
						maxlength="200"></textarea>
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCommento"></div>
			</div>
			
			<!------------------------------------------------- Aula -->
			<div class="form-group">
				<label class="col-md-2 control-label">Aula</label>
				<div class="col-md-5 inputGroupContainer">
					<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-door"></i>
					</span>
					<input type="text" name="aula" id="aula" 
					placeholder="Aula..."
					class="form-control" maxlength="30">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoAula"></div>
			</div>
	
			<!------------------------------------------------- Docente -->
			<div class="form-group">
				<label class="col-md-2 control-label">Docente</label>
				<div class="col-md-5 inputGroupContainer">
					<div class="input-group">
					<%
						DocenteBC docenteBC = new DocenteBC();
						Docente[] docenti = docenteBC.getDocenti();
					%>
					<select name="docente" id="docente">
					<% 
						for(int i = 0; i < docenti.length; i++){
					%>
  						<option value="<%=docenti[i].getCodDocente()%>">
  						<%=docenti[i].getNomeDocente()%>&nbsp;<%=docenti[i].getCognomeDocente()%></option>
  					<%
						}
  					%>
  					</select>
  					
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDocente"></div>
			</div>
			
			<div class="row">
				<div class="col-md-4 col-md-offset-2">
					<button type="submit" class="btn btn-warning">
						Inserisci Corso
						&nbsp;<span class="glyphicon glyphicon-log-in" ></span>
					</button>
				</div>
			</div>
				
		</form>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>