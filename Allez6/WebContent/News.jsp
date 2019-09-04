<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="Model.ModelNotizia, java.util.*,Beans.Notizia"%>
<!DOCTYPE html>
<html>
<head>
<title>News</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/ProductsCard.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
</head>
<body>
<%
	ModelNotizia model = new ModelNotizia();
	Collection<Notizia> notizie = model.doRetrieveAll();

%>

<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">
	<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>



	<div class="container-cards"><%
						for(Notizia n : notizie){
							System.out.println( n.getImmagine());
						%>
							<div class="card">
							  <img src="<%= n.getImmagine()%>">
							  <h1><%= n.getTitolo() %></h1>
							  <p id="desc"><%= n.getNotizia() %></p>
							   <p><a href="NewsShow.jsp?titolo=<%= n.getTitolo() %>">Vai alla notizia</a></p>
							</div>
						
						<% }%></div>
	
</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>


</body>
</html>