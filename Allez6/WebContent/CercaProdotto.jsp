<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Prodotto</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#cerca').click(function() {
	      window.location.href='./ModificaProdotto.jsp?codice=' + $("#codice-prodotto").val();
	});
	});

</script>
	<table>
				<tr> Codice Prodotto: </tr>
				<tr>
					<td><input type ="text" id = "codice-prodotto"></td>
					<td> <button id = "cerca"> Cerca </button></td>
			         
				</tr>
				</table>
</body>
</html>