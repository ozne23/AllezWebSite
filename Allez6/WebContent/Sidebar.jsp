<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/Sidebar.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
</head>
<body>

<script>
	$(document).ready(function(){
	  $("#buttonFilter").click(function(){
	    $("#FilterBar").slideToggle("slow");
	  });
	});

</script>

<div id = "sidebar">
	
		<button id="buttonFilter">Filtri    <i class="fas fa-filter"></i></button>
</div>

<div id = "FilterBar">
	
	<p>Ordinamento:</p>
	<select>
		<option value="nomeAZ">Nome A-Z</option>
  		<option value="nomeZA">Nome Z-A</option>
	</select>

</div>
</body>
</html>