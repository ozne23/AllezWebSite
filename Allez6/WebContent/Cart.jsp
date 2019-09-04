<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="Beans.Cart,Beans.Item,java.util.*,Beans.Prodotto,Model.ModelProdotto,Beans.Acquisto,Beans.Utente,com.google.gson.Gson"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/Cart.css" type="text/css" rel="stylesheet">
<meta http-equiv="cache-control" content="no-cache">

<meta http-equiv="expires" content="0">

<meta http-equiv="pragma" content="no-cache">
</head>
<body>

<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>




<%

	

	Utente utente = (Utente) request.getSession().getAttribute("utente");

	Cart cart = (Cart) request.getSession().getAttribute("cart");

	if(cart != null && cart.getItems().size() > 0)
	{
		
	

			ArrayList<Item> items = cart.getItems();
			
			ArrayList<Acquisto> acquisti = new ArrayList<Acquisto>();
			
			boolean flag = false;
			
			for(Item i : items){
				for(Acquisto a : acquisti){
					if(a.getItem().equalsItem(i)){ a.incrementa(); flag=true;}
				}
				
				if(!flag)
				{
					acquisti.add(new Acquisto(i,1));
				}
				
				flag = false;
			
			}
			
			
			request.getSession().setAttribute("acquisti", acquisti);
			
			ModelProdotto model = new ModelProdotto();
		
			
			double totale = 0;
			double temp = 0;
			
		%>	
		

			<div id="carrello">
				<table id="prodotti">
					<tr>
					<th></th>
					<th>Prodotto</th>
				    <th>Prezzo</th>
				    <th>Colore</th> 
				    <th>Taglia</th>
				    <th>Qtà</th>
				    <th>Sconto</th>
				  </tr>
				  <%
					int i=0;
					for(Acquisto a : acquisti){
		
						if(a.getItem().getSconto() <= 0)
						{
							totale += (a.getItem().getPrezzo() * a.getQuantità());
						}else {
							temp = (a.getItem().getPrezzo() * a.getQuantità());
							
							totale += temp - (temp*a.getItem().getSconto())/100;
						}
					
					
						
					%>
				  
				  <tr>
				    <td><img src="<%= model.doRetrieveByKey(a.getItem().getProdotto()).getImmagine()%>"/></td>
				    <td data-title="Prodotto"><%= model.doRetrieveByKey(a.getItem().getProdotto()).getNome()%></td>
				    <td data-title="Prezzo"><%= a.getItem().getPrezzo()%>€</td> 
				    <td data-title="Colore"><%= a.getItem().getColore()%></td>
				    <td data-title="Taglia"><%= a.getItem().getTaglia()%></td>
				    
				   <!--  <td data-title="Qtà"><input type="number" onchange="cambiaTotaleFin()" value=""></td>--> 
				   
				   <td id=<%= i%> data-title="Qtà" class="quantita"><%= a.getQuantità()%></td>
				   <td data-title="Sconto"><%= a.getItem().getSconto() %>%</td>
				    <td><button  class="QtaButton" onclick="cambiaTotale('<%= a.getItem().getDisponibilità()%>','<%= i%>','<%= a.getItem().getColore()%>','<%= a.getItem().getTaglia()%>','<%= a.getItem().getProdotto()%>')">+</button>
				   <button class="QtaButton" onclick="cambiaTotaleMeno('<%= i%>','<%= a.getItem().getColore()%>','<%= a.getItem().getTaglia()%>','<%= a.getItem().getProdotto()%>')">-</button>
				   <button  class="QtaButton removeButton" onclick="remove('<%= a.getItem().getColore()%>','<%= a.getItem().getTaglia()%>','<%= a.getItem().getProdotto()%>')"><i class="fas fa-trash"></i></button>
				   </td>
				  </tr>
				  
				  	 
				  
				  <% i++;  } %>
				</table>
			</div>
			
			<script>
			
					function remove(colore, taglia, prodotto){
						
						
						
						$.get('RemoveCartServlet', {"prodotto": prodotto, "colore": colore, "taglia": taglia,"all":"true"},
								function(resp){
									
									
							window.location.replace("CartView.jsp");
							
								});
						
					}
				
					function cambiaTotale(Disponibilita,id,colore, taglia, prodotto){
						
					
						console.log($("#"+id).text());
						
						var qt = parseInt($("#"+id).text(), 10);
						
						if(qt < Disponibilita){
					
						
						$.post('CambiaQuantita', {"prodotto": prodotto, "colore": colore, "taglia": taglia},
								function(resp){
							
							console.log(resp.length);
							
							var tot = 0;
							
							for(i=0; i<resp.length;i++){
								var temp = 0;
								var obj = JSON.parse(resp[i]);
								console.log(obj.quantità);
								document.getElementsByClassName("quantita")[i].innerHTML = obj.quantità;
								temp = (obj.item.prezzo * obj.quantità);
								//alert(obj.item.sconto +"" + temp);
								if(obj.item.sconto > 0)
								{
									tot += temp - (temp*obj.item.sconto)/100;
									
								}else 
								{
									tot += temp;
								}
								document.getElementById("tot").innerHTML = "Totale: "+ tot+"€";
								
								
							}
							
						});
						
						$.get('CartServlet', {"prodotto": prodotto, "colore": colore, "taglia": taglia},
								function(resp){
							
						});
						
						}
						
					}
					
					function cambiaTotaleMeno(id,colore, taglia, prodotto){
						
						var qt = parseInt($("#"+id).text(), 10);
						

						console.log($("#"+id).text());
						
						if(qt > 1){
					
						
						$.post('CambiaQuantitaMeno', {"prodotto": prodotto, "colore": colore, "taglia": taglia},
								function(resp){
							
							console.log(resp.length);
							
							var tot = 0;
							var temp = 0;
							
							for(i=0; i<resp.length;i++){
								var obj = JSON.parse(resp[i]);
								console.log(obj.quantità);
								document.getElementsByClassName("quantita")[i].innerHTML = obj.quantità;
								temp = (obj.item.prezzo * obj.quantità);
								//alert(obj.item.sconto +"" + temp);
								if(obj.item.sconto > 0)
								{
									tot += temp - (temp*obj.item.sconto)/100;
									
								}else 
								{
									tot += temp;
								}
								document.getElementById("tot").innerHTML = "Totale: "+ tot+"€";
						
								
							}
							
						});
						
						$.get('RemoveCartServlet', {"prodotto": prodotto, "colore": colore, "taglia": taglia,"all":"false"},
								function(resp){
							
						});
					
						}
					}
				
					
					
					function acquistaFin(){
						
						
						
						$.post("AcquistaServlet",function(resp){
							
								$("#prodotti").hide(1000);
								$("#acquistaButton").hide(1000);
								$("#carrello").hide(1000);
								$("#divAcquEffettuato").show();
								document.getElementById("tot").innerHTML = "Il carrello è vuoto";
							
						});
						
						
					}
					
					function login(){
						
						
						$("#noLogin").show();
						
						
					}
					
					function elimminaDiv(){
						$("#divAcquEffettuato").hide();
						$("#noLogin").hide();
					}
					
					</script>
					
					
			<h2 style="text-align: center" id="tot">Totale: <%= totale %>€</h2>
			
			<% if(utente == null){%>
				<button id="acquistaButton" onclick="login()" >Acquista</button>
			
			<%}else{ %>
				<button id="acquistaButton" onclick="acquistaFin()" >Acquista</button>
			<%} %>
	
	<%}else{%>
				
			<div style="text-align:center">
				<h1>Il carrello è vuoto</h1>
			</div>
	<%} %>
	

	<% if(utente != null) {%>

	<div id="divAcquEffettuato" class="divCentro">
		<h2>Grazie <%= utente.getNome() %>!</h2>
		<p>il tuo ordine verrà spedito presso: <br>
			<%= utente.getProvincia() %>, <%= utente.getCittà() %>, <%= utente.getCap() %>, <%= utente.getVia() %>
		</p>
		
		<div id="t" style="position:absolute; top:60px"><img src ="./images/small_truck.png" width = "26" height ="26"></img> </div>
		
		<button id="chiudiDiv" class="divButton" onclick="elimminaDiv()">Chiudi</button>
	</div>
	
	<%}else{ %>
	
	
		<div id="noLogin" class="divCentro">
		<h2>Devi effettuare il login</h2>
		
		<button class="divButton"><a href="Loginjsp.jsp" style="    text-decoration: none;color: white;">Vai al Login</a></button>
		<button id="chiudiDiv" class="divButton" onclick="elimminaDiv()">Chiudi</button>
		</div>
	<%} %>
	
<script>

	
	
			var t = function($t,speed){
			var truckWidth = $t.width();
			
			$t.animate({ //truck verso sx
			    "left": "92%"
			}, speed, function(){ //torna dietro
			    $t.animate({
			        "left": "1%" 
			    }, speed, function(){
			        t($t, speed) //vai di nuovo
			    });
			});
			};
			
			$(function(){ //document ready
			    t($("#t"), 5000); //calls the function
			});
</script>

</body>
</html>