<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>



	<h1>Rimuovi Prodotto</h1>
	
		
			<table>
				<tr>
					<td> Inserire Codice Prodotto</td>
					<td> <input type ="text" id ="codice" > </td>
					<tr>
					<tr>
					<td><input type = "button"  value = "cancella" onclick = "cancProdotto()"><td>
					</tr>
			</table>
<script>
function cancProdotto(){
	$.post('CancProdServlet',{ "cod": $("#codice").val()},
	function(resp){	
		$("#codice").val("");
	});
}
</script>
</body>
</html>