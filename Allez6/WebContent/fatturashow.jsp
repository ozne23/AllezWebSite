<%@ page language="java" 
    pageEncoding="UTF-8" import = "Model.ModelFattura,Beans.Fattura,Beans.Utente,java.util.*,Beans.Utente,Beans.Vendita,Model.ModelVendita,Beans.Prodotto,Model.ModelProdotto,Beans.Item,Model.ModelItem"%>
<!DOCTYPE html>
<html>
<head>
<title>Fattura</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/fatturashow.css" type="text/css" rel="stylesheet">

<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
</head>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<body>
<%
	System.out.println(request.getParameter("fattura"));
	int codice = Integer.parseInt(request.getParameter("fattura"));
	ModelFattura model = new ModelFattura();
	Utente utente = (Utente) request.getSession().getAttribute("utente");
	String user = utente.getUsername();
	
	ModelVendita modelVendita = new ModelVendita();
	
	ModelProdotto modelProdotto = new ModelProdotto();
	
	ModelItem modelItem = new ModelItem();
	
	
	Fattura fattura = model.doRetrieveByKey(codice,user);
%>

<div id="all">
 <div id="top">
 	<img alt="" src="./LogoImg/logo_final_gecko.png">
 	<div>
 	<h2>Allez store</h2>
 	<p>Campus di Fisciano, Salerno
SA <%= fattura.getpIva() %></p> 
 	</div>
 </div>
 
 <div id="utente">
 	<h3>FATTURA #<%= fattura.getID() %></h3>
 	<h4><%= fattura.getData() %></h4>
 	<table>
 	
 	<tr>
 		<td><%= utente.getNome() %></td>
 	</tr>
 	
 	<tr>
 		<td><%= utente.getCognome() %></td>
 	</tr>
 	
 	<tr>
 		<td><%= utente.getProvincia() %>,<%= utente.getCittà() %>,<%= utente.getVia() %>,<%= utente.getCap() %></td>
 	</tr>
 	
 	<tr>
 		<td><%= utente.getTelefono() %></td>
 	</tr>
 	
 	<tr>
 		<td><%= utente.getEmail() %></td>
 	</tr>
 	
 	</table>
 	
 </div>
 
 <div id="articoli">
 			<%ArrayList<Vendita> vendite = modelVendita.doRetrieveByFattura(fattura.getID());%>
				
			
				<div >
				<table >
					<tr>
					<th>Prodotto</th>
				    <th>Prezzo</th>
				    <th>Colore</th> 
				    <th>Taglia</th>
				    <th>Qtà</th>
				    <th>iva</th>
				    <th>sconto</th>
				  </tr>
				  <%
		
					for(Vendita v : vendite){
						
						
					%>
				  
				  <tr>
				    <td data-title="Prodotto"><%= modelProdotto.doRetrieveByKey(v.getProdotto()).getNome()%></td>
				    <td data-title="Prezzo"><%= v.getPrezzoVendita()%>€</td> 
				    <td data-title="Colore"><%= v.getColore()%></td>
				    <td data-title="Taglia"><%= v.getTaglia()%></td>
				    <td data-title="Qtà"><%= v.getQuantità()%></td>
				    <td data-title="iva"><%= v.getIva()%></td>
				    <td data-title="Sconto"><%= (modelItem.doRetrieveByKey(v.getTaglia(),v.getColore(),v.getProdotto())).getSconto() %>%</td>

				  </tr>
				  
				  		
				  <%} %>
				  
				  
				  
				</table>
					
			
							
				
			</div>
 	
 </div>
 
 <div id="totale">
 	<h2>Totale: <%= fattura.getTotale()%></h2>
 </div>
 
 <div id="footerfattura">
 
 	<img src="./LogoImg/TemaGecko.png">
 	
 	<div>
 		<p><br><br>Grazie per aver effettuato un acquisto!</p>
 	</div>
 	
 
 </div>
 
 </div>

</body>
</html>