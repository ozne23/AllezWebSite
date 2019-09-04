
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- LOGINJSP CON SESSIONE. USARE QUESTO AL POSTO DI LOGIN.JSP -->
<head>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<meta charset="UTF-8">
<link href="./css/Login.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<script>
	window.onload = downScripts;
	function downScripts() {
		var script = document.createElement("script");
		script.src = "./JS/onFocus.js";
		document.body.appendChild(script);
		var script1 = document.createElement("script");
		script1.src = "./JS/onBlur.js";
		document.body.appendChild(script1);
		var script2 = document.createElement("script");
		script2.src = "./JS/validateRegistrazione.js";
		document.body.appendChild(script2);
	}
</script>
</head>

<body>

	<header>
		<%@include file="WebsiteHeader.jsp"%>
	</header>

	<section id="body">
		<nav>
			<%@include file="NavigationBar.jsp"%>
		</nav>
		<div class="regDiv">
			<form name="regForm" action="RegistrationServlet" method="post" onsubmit="return validateRegistrazione()">
				
				<b><label class="el label">Nome</label></b> 
				<input type="text" name="nome" onblur="onBlur(this)" onfocus="onFocus(this)" class="el_ins" required /> <br> 
				<b><label class="el label">Cognome</label></b>
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="cognome" class="el_ins" required /> <br> 
				<b><label class="el label">E-mail</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="email" class="el_ins" required /> <br> 
				<b><label class="el label">Username</label></b>
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="username" class="el_ins" required /> <br> 
				<b><label class="el label">Password</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="password" name="password" placeholder="deve avere almeno 8 caratteri" class="el_ins" required /> <br> 
				<b><label class="el label">Conferma password</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="password" name="conpassword" class="el_ins" required> <br> 
				<b><label class="el label">Telefono</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="tel" name="telefono" class="el_ins" required> <br> 
				<b><label class="el label">CAP</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="cap" class="el_ins" required> <br> 
				<b><label class="el label">Provincia</label></b>
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="provincia" class="el_ins" required> <br> 
				<b><label class="el label">Via</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="via" class="el_ins" required> <br>
				<b><label class="el label">Città</label></b>
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="text" name="citta" class="el_ins" required> <br> 
				<b><label class="el label">Data di nascita</label></b> 
				<input onblur="onBlur(this)" onfocus="onFocus(this)" type="date" name="data" class="el_ins" required> <br> 
				<b><label class="el label">Sesso</label></b><br> 
				M<input onblur="onBlur(this)" onfocus="onFocus(this)" type="radio" name="sesso" value="M" required> 
				F<input onblur="onBlur(this)" onfocus="onFocus(this)" type="radio" name="sesso" value="F" required> 
				<br>
				<br>

				<div class="el">
					<input type="submit" value="Conferma" class="button" /> 
					<input type="reset" value="Reset" class="button" />
				</div>
			</form>
		</div>


	</section>

	<footer>
		<%@include file="WebsiteFooter.jsp"%>
	</footer>




</body>
</html>