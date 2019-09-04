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
<link href="./css/Contatti.css" type="text/css" rel="stylesheet">

<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<meta charset="UTF-8">
<title>Contatti</title>
</head>
<body>

		<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">
	<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>
	<div id="googleContainer">
		<div id ="google-position">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.695944147321!2d14.789829215406685!3d40.76871177932573!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc5c7456b88bd%3A0x80bab96149d2993d!2sUniversit%C3%A0+degli+Studi+di+Salerno!5e0!3m2!1sit!2sit!4v1562072876195!5m2!1sit!2sit" 
				    width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>	
	</div>
	<div id = "contact-div">
		<table id = "field-container">
		<tr>
			<td><address>
			<a href="mailto:allez@example.it">Contatta!</a>.<br> 
			Vieni a trovarci:<br>
			Campus di Fisciano, Salerno<br>
			SA
			</address></td>
		</tr>
		</table>
		</div>	



</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>

</body>
</html>