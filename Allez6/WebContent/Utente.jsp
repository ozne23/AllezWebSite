<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Model.ModelFattura,Beans.Fattura,Beans.Utente,java.util.*,Beans.Vendita,Model.ModelVendita,Model.ModelProdotto"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pagina utente</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Utente.css" type="text/css" rel="stylesheet">

<link href="./css/Icon-Container.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

</head>
<body>


<script>

$(document).ready(function(){
	$("#ButtonOrdini").click(function(){
		
		$("#ordini").toggle(1000);
		
	});
	$(".ButtonStampa").click(function(){
		 window.location.href="./fatturashow.jsp?fattura=" +$(this).attr('id');
		
		
	});


		
});

</script>




<%
	Utente user = (Utente) request.getSession().getAttribute("utente");
	ModelFattura modelFattura = new ModelFattura();
	ModelVendita modelVendita = new ModelVendita();
	ModelProdotto modelProdotto= new ModelProdotto();
	
		ArrayList<Fattura> fatture = modelFattura.FattureUtente(user.getUsername());
	

%>


<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>

<section id  = "body">

   <nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>

		<div id="anagrafica">
			<h2 style="text-align:center">Anagrafica</h2>
			
		<!--  <h1 class="titolo">Nome:</h1><p><%= user.getNome() %></p>
			<h1 class="titolo">Cognome:</h1><p><%= user.getCognome() %></p>
			<h1 class="titolo">Nome utente:</h1><p><%= user.getUsername() %></p>
			<h1 class="titolo">Telefono:</h1><p><%= user.getTelefono() %></p>
			<h1 class="titolo">E-mail:</h1><p><%= user.getEmail() %></p>
			<h1 class="titolo">Indirizzo:</h1><p><%= user.getProvincia() %>,<%= user.getCittà() %>,<%= user.getVia() %>,<%= user.getCap() %></p>
			-->	
			<table>
			<tr>
				<td>Nome</td>
				<td ><%= user.getNome() %><td>
			
			</tr>
			<tr>
				<td>Cognome</td>
				<td><%= user.getCognome() %><td>
			
			</tr>
			<tr>
				<td>Nome utente:</td>
				<td ><%= user.getUsername() %><td>
			
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
			
			<!--   <tr>
				<td><%= user.getNome() %></td>
				<td><%= user.getCognome() %><td>
				<td><%= user.getUsername() %></td>
				<td><%= user.getTelefono() %></td>
				<td><%= user.getEmail() %></td>
				<td><%= user.getProvincia() %>,<%= user.getCittà() %>,<%= user.getVia() %>,<%= user.getCap() %></td>
			
			</tr>-->
			
			</table>			
		
		</div>	
		
		<button class="UtenteButton" id="ButtonOrdini" " >Visualizza ordini</button>
	
	<div id="ordini">
		
		<%
			for(Fattura f : fatture){
				ArrayList<Vendita> vendite = modelVendita.doRetrieveByFattura(f.getID());%>
				
				<h2 style="text-align:center" id ="codice-fattura">Ordine numero: <%= f.getID() %></h2>
			
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
				
				<h2 style="text-align: center" id="tot">Totale: <%= f.getTotale() %>€</h2>
					<button class="UtenteButton ButtonStampa"  id= <%=f.getID() %>  >Stampa fattura</button>
			
							
				
			</div>
			<% }%>
		
				
		</div>
		
		
	

</section>

<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>
</body>
</html>