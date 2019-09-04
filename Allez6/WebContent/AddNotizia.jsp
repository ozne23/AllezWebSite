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



			<form  method="POST" action="SalvaNotizie" enctype="multipart/form-data" id ="salve-notizia"> 
				<table>
				 <tr>
					<td>Immagine:</td>
					<td><input type = "file" name = "file" size = "50" required></td>
				</tr>
				<tr>
					<td> Titolo</td>
					<td>
						<input type ="text" name="titolo" required>
			         </td>
				</tr>
				<tr>
					<td>Notizia: </td>
					<td><textarea rows = "10" cols = "50" name="notizia" placeholder ="Scrivi..." required></textarea> </td>
				</tr>
				<tr>
					
					<td></td>
					<td><input type = "submit" value = "Submit" /></td>
				</tr>
				</table>
				</form>
				
	
				
				
				
           

</body>
</html>