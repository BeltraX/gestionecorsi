<input type="checkbox" id="hamburger" />
<label class="menuicon" for="hamburger"> <span></span>
</label>

<div id="bar">
	<div id="logo">
		<a href="#"><img src="img\sadly.png" alt="your logo"
			title="your logo" height="54"></a>
	</div>
	<!--/fine logo-->
</div>
<!--/fine bar-->

<nav class="menu-visibility">
	<ul>
		<li><a class="active" href="home.jsp">home</a></li>
		<li><a class="submenu" href="#">sezioni</a>
			<ul>
				<li><a href="inserisciCorsisti.jsp">nuovo corso</a></li>
				<li><a href="eliminaCorsi.jsp">elimina</a></li>
				<li><a href="statistiche.jsp">statistiche</a></li>
			</ul></li>
		<%
		String user = (String) session.getAttribute("username");
		%>
		<li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;<%=user%></a></li>
		<li><a href="logout.jsp"> <span
				class="glyphicon glyphicon-log-out"></span>logout
		</a></li>
	</ul>
</nav>
