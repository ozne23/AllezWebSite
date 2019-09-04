<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="Model.ModelFalesia, java.util.*,Beans.Falesia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Falesia</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/FalesiaCampania.css" type="text/css" rel="stylesheet">
<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<link href="./css/videoframe.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

</head>
<body>
<!-- Indice della via trovato nel database! una falesia di indice = falesia di caserta quindi troverà 
tutte le vie con quel dato indice -->

<%
	ModelFalesia model = new ModelFalesia();
	
	Collection<Falesia> falesie = model.doRetrieveByGroup();
	
	ArrayList<String> regioni = new ArrayList<String>();
%>
<script>

$(document).ready(function(){
	$('.rowCard').click(function() {
	      window.location.href='./falesiashow.jsp?falesia=' + $(this).attr('id');
	});
	});

</script>

	<header>
		<%@include file="WebsiteHeader.jsp" %>
	</header>
	
		<nav>
			<%@include file="NavigationBar.jsp" %>
		</nav>
		<div class ="SlideShow">
			<%@include file="ImgSlideShowFalesia.jsp" %>
		</div>
		<%for(Falesia f: falesie){ 
				if(regioni.indexOf(f.getRegione()) == -1){
			%>
		
					<div class="rowCard" id = <%= f.getRegione() %>>
					<% regioni.add(f.getRegione()); %>
		        <div class="card-image">
		          <img src= "<%=f.getImmagine() %>">
		          
		        </div>
		        
		        <div class="post-content">
		        	<h1>Falesia <%=f.getRegione() %></h1>
		        	 <p> </p>
		        	  <br>
		        	  <br>
		        	  
		        	  <h2>Vai alle falesie!</h2>
		        </div>
	</div>
	
	<%}} %>
	
	<div id ="video-container">
	<video id = "video-frame"  controls>
  		<source src="./Video/1.mp4" type="video/mp4">
	</video>
	</div>
	
	
	
	
	
	
	
	
	<!--  
	<div class="rowCard" id ="Caserta">
	        <div class="card-image">
	          <img src="./images/falesia/falesiacaserta.jpg">
	          
	        </div>
	        
	        <div class="post-content">
	        	<h1>Falesie Caserta</h1>
	        	 <p> </p>
	        	  <br>
	        	  <br>
	        	  
	        	  <h2>Vai alle falesie!</h2>
	        </div>
	</div>
	
	<div class="rowCard" id="Napoli">
	<div class="card-image">
	          <img src="./images/falesia/falesianapoli.jpg">
	        </div>
	        
	<div class="post-content">
		<h1>Falesie Napoli</h1>
	        	 <p> </p>
	        	   
	        	   <br>
	        	  <br>
	        	  
	        	  <h2>Vai alle falesie!</h2>
	        </div>
	        
	        
	</div>
	
	
	<div class="rowCard" id="Salerno">
	        <div class="card-image">
	          <img src="./images/falesia/falesiasalerno.jpg">
	        </div>
	        
	        <div class="post-content">
	        	<h1>Falesie Salerno</h1>
	        	 <p></p>
	        </div>
	</div>
-->
	<footer>
		<%@include file="WebsiteFooter.jsp" %>
	</footer>
</body>
</html>