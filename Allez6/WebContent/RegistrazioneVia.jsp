 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "Model.ModelFalesia,java.util.*,Beans.Falesia" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrazione via</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<% 
	ModelFalesia model = new ModelFalesia();
	LinkedList<Falesia> falesie = (LinkedList<Falesia>) model.doRetrieveAll("nome");
	
%>
<script>
	function addVia(){
		$.get('RegViaServlet',{"falesia":$("#falesia").val(), "nome":$("#nome").val(),
		"grado":$("#grado").val(),"settore":$("#settore").val(),"lunghezza":$("#lunghezza").val(),
		"descrizione":$("#descrizione").val()},
		function(resp){		
			
			$("#nome").val("");
			$("#grado").val("");
			$("#settore").val("");
			$("#lunghezza").val("");
			$("#descrizione").val("");
			
		});
	}

</script>


<h1>Registrazione via</h1>


	<table>

		<tr>
			<td>Falesia:</td>
			<td><select id ="falesia">
				 <%
				 	for(Falesia f : falesie)
				 	{
				 		int indice = f.getIndice();
				 		
				 		String nome= f.getNome() +" ("+f.getRegione()+")";
				 		%><option value="<%=indice%>"><%=nome%></option><% 
				 	}
				 %>
			
			</select></td>
		</tr>
		
		<tr>
			<td>Nome:</td>
			<td><input type ="text" id = "nome" required/></td>
		</tr>
		
		<tr>
			<td>Grado:</td>
			<td><input type ="text" id = "grado" required/></td>
		</tr>
		
		<tr>
			<td>Settore:</td>
			<td><input type ="text" id = "settore" required/></td>
		</tr>
		
		<tr>
			<td>Lunghezza:</td>
			<td><input type ="number" id = "lunghezza" required min="1"/></td>
		</tr>
		
		<tr>
		 
		 	<td>Descrizione:</td>
			<td><textarea id = "descrizione"></textarea></td>
		</tr>
		
		
		<tr>
			 <td></td>
			 <td> <input type ="button" value = "registra" onclick = "addVia()"/> </td>
		 </tr>
		
		
	</table>


</body>
</html>