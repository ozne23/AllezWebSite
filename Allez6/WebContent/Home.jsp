
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Allez!</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>




</head>
<body>


<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">
	<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>
		<div class ="SlideShow">
			<%@include file="ImgSlideShow.jsp" %>
		</div>
		
		<%@include file="HomePresentation.jsp" %>
		
		<div class = "icon-container">
			<%@include file="Icons.jsp" %><header>
	
	
	
</header>
		</div>
<p>
</p>


</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>
</body>
</html>