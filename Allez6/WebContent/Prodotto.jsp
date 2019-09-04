<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import = "Model.ModelProdotto,java.util.*,Beans.Prodotto,Model.ModelItem,java.util.*,Beans.Item,Model.ModelCommentoProdotto,Beans.CommentoProdotto" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="cache-control" content="no-cache">

<meta http-equiv="expires" content="0">

<meta http-equiv="pragma" content="no-cache">
<link rel="icon" href="./LogoImg/favicon.ico" />
<meta charset="UTF-8">
<%
	ModelProdotto model = new ModelProdotto();

	ModelItem  modelItem = new ModelItem();

	Prodotto p = model.doRetrieveByKey(Integer.parseInt(request.getParameter("CodProdotto")));
	
	
	ArrayList<Item> items = modelItem.doRetrieveByProd(p.getCodice());
	
	ModelCommentoProdotto modelCommenti = new ModelCommentoProdotto();
	
	ArrayList<CommentoProdotto> commenti = modelCommenti.doRetrieveByProdotto(p.getCodice());
	
	String immagineInit = p.getImmagine();
	
	
	if(items.size() >0){
		immagineInit = items.get(0).getImmagine();
	}
	
	
%>
<title><%= p.getNome()%></title>

<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/Sidebar.css" type="text/css" rel="stylesheet">
<link href="./css/Product.css" type="text/css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<script>
	function myFunction(){
		
		$.get('DisponibilitaServlet', {"prodotto": <%= p.getCodice()%>, "colore": $("#color").val(), "taglia": $("#taglia").val()},
				function(resp){
				
					console.log(resp);
					
					if(resp.disponibilità<=0)
					{
						$(".cart-button").css("background-color", "#9fa1a3");
						$(".cart-button").attr("onClick"," ");
					}else
					{
						$(".cart-button").css("background-color", "#9BD770");
						$(".cart-button").attr("onClick","addCart()");
					}
			
					$("#disp").text("Disponibilità: "+resp.disponibilità);
					
					if(resp.prezzo >0 )
						$("#price").text(resp.prezzo + "€");
					else $("#price").text("");
					
					if(resp.sconto >0)
					{
						$("#sconto").text("sconto: "+resp.sconto + "%");
					}else $("#sconto").text("");
					
					if(resp.immagine != null){
						$("#imgItem").attr("src",resp.immagine);
					}else{
						$("#imgItem").attr("src", "<%= p.getImmagine()%>");
					}
					
			
				});
	}
	
	
	
	
	function addCart(){
		
		
		$.get('CartServlet', {"prodotto": <%= p.getCodice() %>, "colore": $("#color").val(), "taglia": $("#taglia").val()},
				function(resp){
			$("#divAcquEffettuato").show();
			$(".cart-button").attr("onclick","");
		});
		
	}
	
	$(document).ready(function(){
		
		
		
		
		
		$("#CommentiButton").click(function(){
			
			$("#commentiProdotto").toggle(1000);
			
		});
		
		
		$("#Commenta").click(function(){
					
					$.post("SalvaCommentoProdotto",{"prodotto":<%= p.getCodice() %>,"commento":$("#commentoUtente").val()});
					
					$("#commentoUtente").val("");
					
					
					
				});
		
	});
	
	function elimminaDiv(){
		$("#divAcquEffettuato").hide();
	}

</script>




	<header>
		<%@include file="WebsiteHeader.jsp" %>
		
	</header>
	
		<nav>
			<%@include file="NavigationBar.jsp" %>
		</nav>
		
			<div class="container">
 
				
					  <div class="left-column">
					    <img id="imgItem" data-image="black" src="<%= immagineInit%>" alt="">
					  </div>
					 
					 
			
					  <div class="right-column">
					 
				
					    <div class="product-description">
					      <h1><%= p.getNome() %></h1>
					      <p><%= p.getDescrizione()  %></p>
					    </div>
					    
					    Colore:
					    <select id="color" onchange="myFunction()">
					    	<% for(Item i : items){%>
					    		
					    		<option value="<%= i.getColore()%>"><%= i.getColore()%></option>
					    	
					    	<%} %>
					    
					    </select>
					    
					    Taglia:
					    <select id="taglia" onchange="myFunction()">
					    	<% for(Item i : items){%>
					    		
					    		<option value="<%= i.getTaglia()%>"><%= i.getTaglia()%></option>
					    	
					    	<%} %>
					    
					    </select>
					    
					   <% if(items.size()<=0) {%>
					    
						   <h4 id="disp" class="inline"> Disponibilità: 0</h4>
						  
						    <div class="product-price">
						      <h3 id="price"></h3>
						      <a  class="cart-button-non-disp">Aggiungi al carrello</a>
						    </div>
					    
					    <%}else{ %>
					    
						    <h4 id="disp" class="inline"> Disponibilità: <%= items.get(0).getDisponibilità() %></h4>
						  
						    <div class="product-price">
						      <h3 id="price"> <%= items.get(0).getPrezzo() %>€</h3>
						      <h3 id="sconto">sconto: <%= items.get(0).getSconto() %>%</h3>
						      <%if(items.get(0).getDisponibilità() <= 0) {%>
						      	<a class="cart-button"  style="background-color:#9fa1a3">Aggiungi al carrello</a>
						      <%}else{ %>
						      	<a href="#" class="cart-button" onClick="addCart()">Aggiungi al carrello</a>
						      <%} %>
						    </div>
					    
					    <%} %>
	
					</div>
					  
			</div>
			
			<div id="lasciaCommento">
				<textArea id="commentoUtente" cols="50" rows="4" maxlength="200"> </textArea>
				<button id="Commenta" class="prodottoButton">Commenta</button>
			</div>
			
			
			<button id="CommentiButton" class="prodottoButton">Visualizza Commenti</button>
			
			<div id="commentiProdotto">
			
				<% for(CommentoProdotto c : commenti){%>
				
					<div id="commento">
					
						<p><%= c.getCommento() %></p>
					
					</div>
				
				<% }%>
			
			</div>
			
		<div id="divAcquEffettuato" class="divCentro">
		<h2>Aggiunto al carrello!</h2>
		
		<button id="chiudiDiv" onclick="elimminaDiv()">Chiudi</button>
		</div>
		
		
		

		<footer>
			<%@include file="WebsiteFooter.jsp" %>
		</footer>

</body>
</html>