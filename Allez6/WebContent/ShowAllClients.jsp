 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Model.ModelUtente,Beans.Fattura,Beans.Utente,java.util.*,Beans.Vendita,Model.ModelVendita,Model.ModelProdotto"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/Utente.css" type="text/css" rel="stylesheet">

<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%
	ModelUtente model = new ModelUtente();
	Collection<Utente> utenti =  model.doRetrieveAll();
%>

<%for(Utente user: utenti){ %>
	<div id="anagrafica">
			<h2 style="text-align:center">Anagrafica</h2>
		
			<table>
			<tr>
				<td>Nome</td>
				<td><%= user.getNome() %><td>
			
			</tr>
			<tr>
				<td>Cognome</td>
				<td><%= user.getCognome() %><td>
			
			</tr>
			<tr>
				<td>Nome utente:</td>
				<td><%= user.getUsername() %><td>
			
			</tr>
			<tr>
				<td>Telefono</td>
				<td><%= user.getTelefono() %><td>
			
			</tr>
			<tr>
				<td>E-mail</td>
				<td><%= user.getEmail() %><td>
			
			</tr>
			<tr>
				<td>Indirizzo</td>
				<td><%= user.getProvincia() %>,<%= user.getCittà() %>,<%= user.getVia() %>,<%= user.getCap() %><td>
			
			</tr>
			
		
			
			</table>			
		
		</div>	
	<%} %>

</body>
</html>