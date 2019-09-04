 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "Model.ModelProdotto,Model.ModelFattura,java.util.*,Beans.Fattura,Beans.Vendita,Model.ModelVendita"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/ShowOrderByClient.css" type="text/css" rel="stylesheet">



<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	ModelFattura modelFattura = new ModelFattura();
	Collection<Fattura> fatture = modelFattura.FattureUtente(request.getParameter("client"));
	ModelVendita modelVendita = new ModelVendita();
	ModelProdotto modelProdotto= new ModelProdotto();
	
	
%>
	
	
	<div id="ordini">
		
		<%
			for(Fattura f : fatture){
				ArrayList<Vendita> vendite = modelVendita.doRetrieveByFattura(f.getID());%>
				
				<h2 style="text-align:center">Ordine numero: <%= f.getID() %></h2>
				
				<div id="fattura">
				<table id="prodotti">
					<tr>
					<th></th>
					<th>Prodotto</th>
				    <th>Prezzo</th>
				    <th>Colore</th> 
				    <th>Taglia</th>
				    <th>Qtà</th>
				  </tr>
				  <%
		
					for(Vendita v : vendite){
						
						
					%>
				  
				  <tr>
				    <td><img src="<%= modelProdotto.doRetrieveByKey(v.getProdotto()).getImmagine()%>"/></td>
				    <td data-title="Prodotto"><%= modelProdotto.doRetrieveByKey(v.getProdotto()).getNome()%></td>
				    <td data-title="Prezzo"><%= v.getPrezzoVendita()%>€</td> 
				    <td data-title="Colore"><%= v.getColore()%></td>
				    <td data-title="Taglia"><%= v.getTaglia()%></td>
				    <td data-title="Qtà"><%= v.getQuantità()%></td>
				    
				  </tr>
				   <%} %>
				  
				  </table>
				  </div>
				   <%} %>
				  </div>
</body>
</html>