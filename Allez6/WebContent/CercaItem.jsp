<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#cerca').click(function() {
	      window.location.href='./ModificaItem.jsp?taglia='+$("#taglia-item").val()+"&colore="+$("#colore-item").val()+"&prodotto="+$("#prodotto-item").val();
	});
	});
	

</script>
	<table>
			
				<tr>
					<td> Taglia : <input type ="text" id = "taglia-item"></td>
				</tr>
				<tr>
					<td>Colore: <input type ="text" id = "colore-item"></td>
				</tr>
				<tr>
					<td>Prodotto: <input type ="text" id = "prodotto-item"></td>
				</tr>
				<tr>
				<td> <button id = "cerca"> Cerca </button></td>   
				</tr>
				</table>
</body>
</html>