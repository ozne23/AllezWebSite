<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  name="viewport" content="width=device-width, initial-scale=1.0">
<title>Abbigliamento</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Sidebar.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<meta http-equiv="cache-control" content="no-cache">

<meta http-equiv="expires" content="0">

<meta http-equiv="pragma" content="no-cache">


</head>

<body>
	
	<header>
		<%@include file="WebsiteHeader.jsp" %>
		
	</header>
	
		<nav>
			<%@include file="NavigationBar.jsp" %>
		</nav>
		
			<%@include file = "productsCard.jsp" %>
	
	
		
			
		

		
			<%@include file="WebsiteFooter.jsp" %>
		

</body>

</html>