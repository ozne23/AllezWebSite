<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Beans.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<%
	Utente usr = (Utente) session.getAttribute("utente");

%>

</head>
<body>

<script>
	$(document).ready(function(){
	  $("#menu").click(function(){
		
	    $(".navigation-list-menu").slideToggle("slow");
	    $(".navigation-list-menu").css("display","grid");
	  });
	  
	  $(window).resize(function() {
		    /*If browser resized, check width again */
		    if ($(window).width() >600) {
		    	$(".navigation-list-menu").css("display","none");}
		 });
	});

</script>


	<ul class = "navigation-list">
		<li class="menuButton"><a id="menu"><i class="fas fa-bars"></i></a></li> 
		<li><a class = "active navButton" href ="./Home.jsp">Home</a></li>
			<li class = "dropdown navButton">
				<a href ="javascript: void(0)" class = "dropbtn navButton"> Negozio</a>
					<div class = "dropdown-content navButton">
						<a href = "./NegozioAbbigliamento.jsp?categoria=abbigliamento"> Abbigliamento</a>
						<a href = "./NegozioAbbigliamento.jsp?categoria=attrezzatura"> Attrezzatura</a>
						<a href = "./NegozioAbbigliamento.jsp?categoria=sicurezza"> Sicurezza</a>
					</div>
			</li>
		<li class = "dropdown">
			<a href ="./FalesiaCampania.jsp" class = "dropbtn navButton"> Falesie</a>
				
		</li>
		<li class ="util navButton"><a href ="News.jsp">Notizie</a></li>
		<li class ="util navButton"><a href ="Contatti.jsp">Contatti</a></li>
		  
		<%
			if(usr!=null){
		%>
			<li class = "dropdown navButton">
				<a href ="javascript: void(0)" class = "  dropbtn navButton"> <%= usr.getNome()%></a>
					<div class = "dropdown-content navButton">
						<a href = "./Utente.jsp"> Area utente</a>
						<a href = "./LogoutServlet"> Logout</a>
					</div>
			</li>
			
			<%
				
				if(usr.getTipo()==1){ %>
				<li><a class = "navButton" href ="./AdminPage.jsp">Pannello admin</a></li>
			
			<%}%>
			
		<% }else{%>
			<li class ="util navButton"><a href ="Loginjsp.jsp">Login</a></li>
			<li class ="util navButton"><a href ="Registrazione.jsp">Registrazione</a></li>
			<%} %>
		<li class ="util navButton"><a href ="CartView.jsp"><i class="fas fa-shopping-cart"></i></a></li>
		
		
	</ul>	
	
	<ul class = "navigation-list-menu">
		<li><a class = "navButton-menu" href ="./Home.jsp">Home</a></li>
		<li class ="navButton-menu"><a href ="Contatti.jsp">Contatti</a></li>
		
		<li class = "dropdown navButton-menu">
				<a href ="javascript: void(0)" class = "dropbtn navButton-menu"> Negozio</a>
					<div class = "dropdown-content navButton-menu">
						<a href = "./NegozioAbbigliamento.jsp?categoria=abbigliamento"> Abbigliamento</a>
						<a href = "./NegozioAbbigliamento.jsp?categoria=attrezzatura"> Attrezzatura</a>
						<a href = "./NegozioAbbigliamento.jsp?categoria=sicurezza"> Sicurezza</a>
					</div>
			</li>
		<li class = "dropdown">
			<a href ="./FalesiaCampania.jsp" class = "dropbtn navButton-menu"> Falesie</a>
				
		</li>
		<%
			if(usr!=null){
		%>
			<li class = "dropdown navButton">
				<a href ="javascript: void(0)" class = "dropbtn navButton-menu"> <%= usr.getNome()%></a>
					<div class = "dropdown-content navButton-menu">
						<a href = "./Utente.jsp"> Area utente</a>
						<a href = "./LogoutServlet"> Logout</a>
					</div>
			</li>
			
		<% }else{%>
			<li class ="util navButton-menu"><a href ="Loginjsp.jsp">Login</a></li>
			<li class ="util navButton-menu"><a href ="Registrazione.jsp">Registrazione</a></li>
			<%} %>
			
			
		<% 
			if(usr != null){
			if(usr.getTipo()==1){ %>
			<li><a class = "navButton-menu" href ="./AdminPage.jsp">Pannello admin</a></li>
			
			<%}}%>
		<li class ="util navButton-menu"><a href ="CartView.jsp"><i class="fas fa-shopping-cart"></i></a></li>
	
	</ul>

</body>
</html>