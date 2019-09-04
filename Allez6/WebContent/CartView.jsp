<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
</head>
<body>

 


<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">
	<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>
		
		
		<%@include file="Cart.jsp" %>
	
	



</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>

</body>
</html>