<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "Model.ModelItem ,java.util.*,Beans.Item"%>
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
	ModelItem model = new ModelItem();
	String taglia = request.getParameter("taglia");
    String colore = request.getParameter("colore");
	String x = request.getParameter("prodotto");
	System.out.println(taglia + colore + x);
	int cod = Integer.parseInt(x);
	Item i = (Item)  model.doRetrieveByKey(taglia,colore,cod);
%> 

<script>
function ModItem(){	
		$.post('ModItemServlet',{ "taglia": $("#taglia").val(), "colore": $("#colore").val(),
			"prodotto": $("#prodotto").val(), "sconto": $("#sconto").val(), "disp": $("#disp").val(),"prezzo": $("#prezzo").val(),
			"img": $("#img").val()},
		function(resp){	
		});
	}
</script>

			<table>
			
			<tr>
				<td>Taglia:<input type ="text" id = "taglia"  value ="<%= i.getTaglia() %>"></td>	
			</tr>
			<tr>
				<td>Colore:<input type ="text" id = "colore"  value ="<%= i.getColore() %>"></td>	
			</tr>
			<tr>
				<td>Prodotto:<input type ="text" id = "prodotto"  value ="<%= i.getProdotto() %>"></td>	
			</tr>
			<tr>
				<td>Sconto:<input type ="text" id = "sconto"  value ="<%= i.getSconto() %>"></td>	
			</tr>
			<tr>
				<td>Disponibilità:<input type ="text" id = "disp"  value ="<%= i.getDisponibilità() %>"></td>	
			</tr>
			<tr>
				<td>Prezzo:<input type ="text" id = "prezzo"  value ="<%= i.getPrezzo() %>"></td>	
			</tr>
			<tr>
				<td>Immagine:<input type ="text" id = "img"  value ="<%= i.getImmagine() %>"></td>	
			</tr>
			
			<tr>
				<td>  <input type ="button" value = "registra" onclick = "ModItem()"><td>
				</tr>	
			
			
			</table>




</body>
</html>