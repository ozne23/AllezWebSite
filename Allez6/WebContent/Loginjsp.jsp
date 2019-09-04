
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			function downScripts(){
				var script = document.createElement("script");
				script.src = "./JS/onFocus.js";
				document.body.appendChild(script);
				var script1 = document.createElement("script");
				script1.src = "./JS/onBlur.js";
				document.body.appendChild(script1);
				var script2 = document.createElement("script");
				script2.src = "./JS/validateLogin.js";
				document.body.appendChild(script2);
			}
	
	</script>
</head>

<body>

<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">
	<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>
		<div class="regDiv">
		<form name="loginForm" action="LoginServlet" method="post" onsubmit="return validateLogin()">
		
			<b><label class="el label">Username</label></b>
		     <input id="username" type="text" onblur = "onBlur(this)" onfocus = "onFocus(this)"  name="username" placeholder="enter username" class="el_ins"> <br>  
		     <b><label class="el label">Password</label></b>
		     <input id="password" type="password" onblur = "onBlur(this)" onfocus = "onFocus(this)" name="password" placeholder="enter password" class="el_ins"> 
		     <br>
			<br>
		     <%
		     	Boolean ten = (Boolean) session.getAttribute("tentativo");
		     	if(ten != null && ten==true)
		     	{
		     		session.removeAttribute("tentativo");
		     		%><p class="el label">Credenziali non corrette!</p><%
		     	}
		     %>
		     <div class="el">
		     <input type="submit" value="Log In" class="button"/>
		     <input type="reset" value="Reset"  class="button"/>
		     </div>
		</form>
	</div>


</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>


	

</body>
</html>