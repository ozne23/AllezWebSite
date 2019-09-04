<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type">
<title>Registrazione Prodotto </title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<script>
/*function addProdotto(){
	$.post('RegProdServlet',{ "nome": $("#nome").val(), "marca": $("#marca").val(),
		"descrizione": $("#descrizione").val(), "categoria": $("#categoria").val(),"img": $("#img").val(),"destination": $("#dest").val()},
	function(resp){	
	});
}*/
</script>

<h1>Registrazione prodotto</h1>
				<form  method="POST" action="RegProdServlet" enctype="multipart/form-data"> 
				<table>
				 <tr>
					<td>>Immagine:</td>
					<td><input type = "file" name = "file" size = "50"></td>
				</tr>
				<tr>
					<td> prodotto</td>
					<td>
						<input type ="text" name="nome">
			         </td>
				</tr>
				<tr>
					<td> Marca del prodotto</td>
					<td>
						<input type ="text" name="marca">
			         </td>
				</tr>
				<tr>
					<td>Descrizione:</td>
					<td><textarea  name = "descrizione" ></textarea></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><select name="categoria" >
						<option value="abbigliamento">Abbigliamento</option>
						<option value="sicurezza">Sicurezza</option>
						<option value="attrezzatura">Attrezzatura</option>
					
						</select>
					</td>
				</tr>  
				
				<tr>
					<td></td>
					<td><input type = "submit" value = "Submit" /></td>
				</tr>
				</table>
				</form>
	
				
				
				
           </form>


	<!--
	aFUNZIONA
	<h1>Registrazione prodotto</h1>
				<form  method="POST" action="RegProdServletBis"> 
				<table>
				<tr>
					<td> prodotto</td>
					<td>
						<input type ="text" name="nome">
			         </td>
				</tr>
				<tr>
					<td> Marca del prodotto</td>
					<td>
						<input type ="text" name="marca">
			         </td>
				</tr>
				<tr>
					<td>Descrizione:</td>
					<td><textarea  name = "descrizione" ></textarea></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><input type="text"  name="categoria" ></td>
				</tr>
				<tr>
					<td></td>
					<td><input type = "submit" value = "Submit" /></td>
				</tr>
				</table>
				</form>
				
				 <form method="POST" action="RegProdServlet" enctype="multipart/form-data" >
				 <table>
				 <tr>
					<td>>Immagine:</td>
					<td><input type = "file" name = "file" size = "50"></td>
				</tr>
				
				
				<tr>
					<td></td>
					<td><input type = "submit" value = "Upload File" /></td>
				</tr>
           </table>
           </form>  -->
	

		
		<!--<table>
				<tr>
					<td> prodotto</td>
					<td>
						<input type ="text" id ="nome">
			         </td>
				</tr>
				<tr>
					<td> Marca del prodotto</td>
					<td>
						<input type ="text" id ="marca">
			         </td>
				</tr>
				<tr>
					<td>Descrizione:</td>
					<td><textarea  id = "descrizione" ></textarea></td>
				</tr>
				<tr>
					<td>Categoria:</td>
					<td><input type="text"  id = "categoria" ></td>
				</tr>
				<tr>
					<td>Immagine:</td>
					<td><input type="file"  id = "img" ></td>
					<td><input  value="./images" id ="destination"></td>
				</tr>
				 <tr>
			 <td></td>
			 <td> <input type ="button" value = "registra" onclick = "addProdotto()"> </td>
		 </tr>
			</table>  -->
			
		
</body>
</html>