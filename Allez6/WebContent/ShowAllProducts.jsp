 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="Model.ModelProdotto, java.util.*, Beans.Prodotto"%>
<!DOCTYPE html>
<html>
<head>
<link href="./css/ProductsCard.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<%	
	ModelProdotto modelProdotto= new ModelProdotto();
	Collection<Prodotto> prodotti = modelProdotto.doRetrieveAll();
%>
						<div class="container-cards">
						<%
						for(Prodotto p : prodotti){
						%>

							<div class="card">
							  <img src="<%= p.getImmagine()%>" alt="Img missing">
							  <h1><%= p.getNome() %></h1>
							  <p id="desc"> Codice: <%= p.getCodice() %></p>
						
						</div>
						<% }%></div> 

</body>
</html>