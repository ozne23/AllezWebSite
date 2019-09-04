<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="Model.ModelNotizia, java.util.*,Beans.Notizia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Falesia</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Notizia.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
</head>
<body>

<%
 	ModelNotizia model = new ModelNotizia();

	Notizia notizia = model.doRetrieveByKey(request.getParameter("titolo"));
%>

<header>
		<%@include file="WebsiteHeader.jsp" %>
		
	</header>
	
		<nav>
			<%@include file="NavigationBar.jsp" %>
		</nav>
		
		<div id="notizia">
		
			<h1><%= notizia.getTitolo() %></h1>
			<img src=<%= notizia.getImmagine() %>>
			<p><%= notizia.getNotizia() %></p>
		
		
		</div>
		
		
		
		<%@include file="WebsiteFooter.jsp" %>
		
</body>
</html>