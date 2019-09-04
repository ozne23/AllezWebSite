  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import = "Model.ModelFattura,Beans.Fattura,java.util.*,Beans.Vendita,Model.ModelVendita,Model.ModelProdotto"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/AdminFatture.css" type="text/css" rel="stylesheet">
<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
</head>
<body>
<%	
	ModelFattura modelFattura = new ModelFattura();
	ModelVendita modelVendita = new ModelVendita();
	ModelProdotto modelProdotto= new ModelProdotto();
	Collection<Fattura> fatture = modelFattura.doRetrieveByDate(request.getParameter("datainizio"),request.getParameter("datafine"));
	System.out.println("Cia2o");
%>
	<section id  = "body">
			<div id="ordini">
		
		<%
			for(Fattura f : fatture){
				System.out.println("Ciao1");
				ArrayList<Vendita> vendite = modelVendita.doRetrieveByFattura(f.getID());%>
				
				<h2 style="text-align:center"> Ordine numero: <%= f.getID() %></h2>
				
				<div id="fattura">
				<table id="prodotti">
					<tr>
					<th></th>
					<th>Prodotto</th>
				    <th>Prezzo</th>
				    <th>Colore</th> 
				    <th>Taglia</th>
				    <th>Qtà</th>
				    <th>Cliente</th>
				    <th>Data</th>
				  </tr>
				  <%
		
					for(Vendita v : vendite){
						System.out.println("Ciao1");
						
					%>
				  
				  <tr>
				    <td><img src="<%= modelProdotto.doRetrieveByKey(v.getProdotto()).getImmagine()%>"/></td>
				    <td data-title="Prodotto"><%= modelProdotto.doRetrieveByKey(v.getProdotto()).getNome()%></td>
				    <td data-title="Prezzo"><%= v.getPrezzoVendita()%>€</td> 
				    <td data-title="Colore"><%= v.getColore()%></td>
				    <td data-title="Taglia"><%= v.getTaglia()%></td>
				    <td data-title="Qtà"><%= v.getQuantità()%></td>
				    <td data-title="Utente"><%= f.getUtente()%></td>
				     <td data-title="Data"><%= f.getData()%></td>
				    
				  </tr>
				  <%} %>
  
				</table>

			</div>
			<% }%>
		
	
		</div>
		</section>

</body>
</html>