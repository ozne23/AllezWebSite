 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="Model.ModelProdotto, java.util.*, Beans.Prodotto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione Item</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

</head>
<body>
<%
	ModelProdotto model = new ModelProdotto(); 
ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) model.doRetrieveAll("nome");

%>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<script>
	/*function addItem(){
		$.post('RegItemServlet',{"taglia":$("#taglia").val(),
		"colore":$("#colore").val(),"prodotto":$("#prodotto").val(),"sconto":$("#sconto").val(),"disponibilità":$("#disponibilità").val(),
		"prezzo":$("#prezzo").val(), "immagine":$("#immagine").val()},
		function(resp){		
		});
	}*/
</script>

	<h1>Registrazione Item</h1>
	<form  method="POST" action="RegItemServlet" enctype="multipart/form-data">
	<table>

		<tr>
			<td>Prodotti:</td>
			<td><select name="prodotto">
				 <%
				 	for(Prodotto p : prodotti)
				 	{
				 		int codice = p.getCodice();
				 		String nome = codice +" "+p.getNome()+"("+p.getMarca()+")";
				 		%><option value="<%=codice %>"><%=nome%></option><% 
				 	}
				 %>
			
			</select></td>
		</tr>
		
		<tr>
			<td>Taglia:</td>
			<td><input type ="text" name = "taglia" required/></td>
		</tr>
		
		<tr>
			<td>Colore:</td>
			<td><input type ="text" name = "colore" required/></td>
		</tr>
		
		
		
		<tr>
			<td>Sconto:</td>
			<td><input type ="number" name = "sconto" required/></td>
		</tr>
		
		<tr>
		 
		 	<td>Disponibilità:</td>
			<td><input type ="number" name = "disp" required></td>
		</tr>
		
		
		<tr>
			 <td>Prezzo:</td>
			 <td> <input type ="number" name = "prezzo"required/> </td>
		 </tr>
		<tr>
			 <td>Immagine:</td>
			 <td> <input type = "file" name = "file" size = "50" required/> </td>
		 </tr>
		 <tr>
			 <td></td>
			<td><input type = "submit" value = "Submit" /></td>
		 </tr>
		
	</table>
	</form>


</body>
</html>