<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menu">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Corsi</a>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			<%
			String user = (String) session.getAttribute("username");
			%>
			<ul class="nav navbar-nav">
				
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="home.jsp">Home</a></li>
				<li><a href="logout.jsp"> <span
						class="glyphicon glyphicon-log-out"></span>Logout
				</a></li>

				<li></li>

			</ul>
		</div>
	</div>
</nav>