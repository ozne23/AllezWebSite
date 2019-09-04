<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/Icons.css" type="text/css" rel="stylesheet">
</head>
<body>
<!-- TUTTI I SEGUENTI VANNO TRASFORMATI IN BUTTONS -->
<div class = "icon-container">
	<div class="row">
		  <div class="column">
		   <button class="iconButton" onclick="window.location.href = 'SearchServlet?testo=Beal';"> 
		   	<img class = "icons-img"  src="./Icons/BealLogo.png"  >
		   </button> 
		  </div>
		  <div class="column">
		  	 <button class="iconButton" onclick="window.location.href = 'SearchServlet?testo=Black+Diamond';">
		    	<img class = "icons-img"  src="./Icons/BlackDiamondLogo.png">
		  	 </button>
		  </div>
		  <div class="column">
		  	 <button class="iconButton" onclick="window.location.href = 'SearchServlet?testo=La+Sportiva';">
		    	<img class = "icons-img"  src="./Icons/LaSportivaLogo.png" >
		     </button>
		  </div>
		  <div class="column">
		   <button  class="iconButton" onclick="window.location.href = 'SearchServlet?testo=Petzl';">
		    	<img class = "icons-img"  src="./Icons/PetzlLogo.png" >
		    </button>
		  </div>
		  <div class="column">
		  	 <button class="iconButton" onclick="window.location.href = 'SearchServlet?testo=Wild+climb';">
		    	<img class = "icons-img"  src="./Icons/wildclimb.jpg" >
		     </button>	
		  </div>
	</div>
	
</div>	
</body>
</html>