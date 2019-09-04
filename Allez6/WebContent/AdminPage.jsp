<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Beans.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/AdminPage.css" type="text/css" rel="stylesheet">
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">

</head>
<body>

	<header>
	<%@include file="WebsiteHeader.jsp" %>
</header>
<nav>
		<%@include file="NavigationBar.jsp" %>
	</nav>

			<%  
			 Utente u = (Utente)session.getAttribute("utente");
			if(u != null){
			if(u.getTipo() == 1){ %>
			<!--  <div class = "menu-admin-controls">
					<ul class = "controls">
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="RegFalesia"> Registrazione Falesia</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="RegVia"> Registrazione Via</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="RegProdotto"> Registrazione Prodotto</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="RegItem"> Registrazione Item</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="CancProdotto"> Cancella Prodotto </button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ModProdotto"> Modifica Prodotto </button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ModItem"> Modifica Item</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ShowAllOrder"> Visualizza Ordini</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ShowOrderBydate">  Ordini Per Data</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ShowOrderByClient">  Ordini Per Cliente</button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ShowAllProducts"> Visualizza Prodotti </button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="ShowAllClients"> Visualizza Clienti </button> </li>
					<li class = "admin-list"> <button  class = "admin-Button" type = "button" onclick="myFunction(this.id)" id ="AddNotizia"> Aggiungi Notizia </button> </li>
					
					</ul>
			</div> -->
			
			<div id="adminPanel">
				<h2>Registra:</h2>
				<select onchange="myFunction(this.value); blank(this.id,this.value)" id="selReg">
					<option value=""></option>
					<option value="RegFalesia">Registrazione Falesia</option>
					<option value="RegVia">Registrazione Via</option>
					<option value="RegProdotto">Registrazione Prodotto</option>
					<option value="RegItem">Registrazione Item</option>
					<option value="AddNotizia">Aggiungi Notizia</option>
				</select>
				<h2>Modifica:</h2>
				<select onchange="myFunction(this.value); blank(this.id,this.value)" id="selMod">
					<option value=""></option>
					<option value="ModProdotto">Modifica Prodotto</option>
					<option value="ModItem">Modifica Item</option>
					<option value="CancProdotto">Cancella Prodotto</option>
				
				</select>
				<h2>Visualizza:</h2>
				<select onchange="myFunction(this.value); blank(this.id,this.value)" id="selVis">
					<option value=""></option>
					<option value="ShowAllOrder">Visualizza Ordini</option>
					<option value="ShowOrderBydate">Ordini Per Data</option>
					<option value="ShowOrderByClient">Ordini Per Cliente</option>
					<option value="ShowAllProducts">Visualizza Prodotti</option>
					<option value="ShowAllClients">Visualizza Clienti</option>
				</select>
			</div>
			<br>
			
				 <iframe id = "display" src ="">
					 
					</iframe> 
			<%} } %>
			<script>
				function myFunction(id){
					if(id == "RegFalesia"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./registrazioneFalesia.jsp"
						
					}
					else if(id == "RegVia"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./RegistrazioneVia.jsp"
						
					}
					else if(id == "RegProdotto"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./RegistrazioneProdotto.jsp"
						
					}
					else if(id == "RegItem"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./RegistrazioneItem.jsp"
						
					}
					else if(id == "CancProdotto"){
						//$("#display").attr("src", "./CancellaProdotto.jsp");
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./CancellaProdotto.jsp";
						
					}
					else if(id == "ModProdotto"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./CercaProdotto.jsp"
						
					}
					else if(id == "ModItem"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./CercaItem.jsp"
						
					}
					else if(id == "ShowAllOrder"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./ShowAllOrder.jsp"
						
					}
					else if(id == "ShowOrderBydate"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./CercaOrderByDate.jsp"
						
					}
					else if(id == "ShowOrderByClient"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./CercaOrderByClient.jsp"
						
					}
					else if(id == "ShowAllProducts"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./ShowAllProducts.jsp"
						
					}
					else if(id == "ShowAllClients"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./ShowAllClients.jsp"
						
					}
					else if(id == "AddNotizia"){
						var x = document.getElementById("display");
						x.getAttributeNode("src").value = "./AddNotizia.jsp"
						
					}
				}
				
				function blank(id,val){
					if(id=="selReg" && val != ""){
						$('#selMod').val('0').change();
						$('#selVis').val('0').change();
					}else if(id=="selMod" && val != ""){
						$('#selReg').val('0').change();
						$('#selVis').val('0').change();
					}else if(id=="selVis" && val != ""){
						$('#selMod').val('0').change();
						$('#selReg').val('0').change();
					}
				}
			
			
			</script>
			
			<footer>
	<%@include file="WebsiteFooter.jsp" %>
</footer>
      
			
</body>
</html>