<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="Model.ModelProdotto,java.util.*,Beans.Prodotto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<%
	ModelProdotto model = new ModelProdotto();
	String x = request.getParameter("codice");
	int cod = Integer.parseInt(x);
	Prodotto p = (Prodotto)  model.doRetrieveByKey(cod);
%> 


<script>
function ModProdotto(){	
		$.post('ModProdottoServlet',{ "nome": $("#nome").val(), "marca": $("#marca").val(),
			"descrizione": $("#desc").val(), "img": $("#img").val(), "codice": $("#cod").val(),"categoria": $("#categoria").val()},
		function(resp){	
		});
	}
</script>

			<table>
				<tr>
				<td> Nome: <input type ="text" id ="nome" value ="<%=p.getNome() %>"> <td>
				</tr>
				<tr>
				<td> Marca: <input type = "text" id = "marca" value ="<%= p.getMarca() %>"> <td>
				</tr>
				<tr>
				<td> Img: <input type = "file" id = "img" value ="<%= p.getImmagine() %>"><td>
				</tr>
				<tr>
				<td> Descrizione: <input type = "text" id = "desc" value ="<%= p.getDescrizione() %>"><td>
				</tr>
				<tr>
				<td> Codice <input type = "text" id = "cod" value ="<%= p.getCodice() %>"><td>
				</tr>
				<tr>
				<td> Categoria <input type = "text" id = "categoria" value ="<%= p.getCategoria() %>"><td>
				</tr>
				<tr>
				<td>  <input type ="button" value = "registra" onclick = "ModProdotto()"><td>
				</tr>		
			</table>
</body>
</html>