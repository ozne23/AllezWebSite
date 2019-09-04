<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "Model.ModelVia,java.util.*,Beans.Via,Model.ModelCommentoFalesia,Beans.CommentoFalesia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" href="./LogoImg/favicon.ico" />
<link href="./css/FalesiaCampania.css" type="text/css" rel="stylesheet">
<link href="./css/Navbar.css" type="text/css" rel="stylesheet">
<link href="./css/Searchbar.css" type="text/css" rel="stylesheet">
<link href="./css/Stickytopnav.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteFooter.css" type="text/css" rel="stylesheet">
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
<link href="./css/ProductsCard.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>

<%
	ModelVia model = new ModelVia();
	
	LinkedList<Via> vie = (LinkedList<Via>) model.doRetrieveAll("nome",request.getParameter("falesia"));
	
	ModelCommentoFalesia modelCommenti = new ModelCommentoFalesia();
	
	int idFalesia = Integer.parseInt(request.getParameter("falesia"));
	
	ArrayList<CommentoFalesia> commenti = modelCommenti.doRetrieveByFalesia(idFalesia);
%>    
<script>
$(document).ready(function(){
	$("#CommentiButton").click(function(){
		
		$("#commentiFalesia").toggle(1000);
		
	});
	
	
	$("#Commenta").click(function(){
				
				$.post("SalvaCommentoFalesia",{"falesia":<%= idFalesia%>,"commento":$("#commentoUtente").val()});
				
				$("#commentoUtente").val("");
				
				
				
			});
	
});

</script>

	<header>
		<%@include file="WebsiteHeader.jsp" %>
	</header>
	
		<nav>
			<%@include file="NavigationBar.jsp" %>
		</nav>
  
 			
			
			<div class="container-cards"><%
						for(Via v : vie){
						%>
							<div class="card">
							 <h1 ><%= v.getNome() %></h1>
							  <p ><%= v.getDescrizione() %></p>
								<p > Grado: <%= v.getGrado() %></p> 
								<p> Lunghezza: <%= v.getLunghezza() %></p>  
								<p> Settore: <%= v.getSettore() %></p>
							  
							</div>
						
						<% }%></div>
			
			
			<div id="lasciaCommento">
				<textArea id="commentoUtente" cols="50" rows="4" maxlength="200"> </textArea>
				<button id="Commenta" class="falesiaButton">Commenta</button>
			</div>
			
			
			<button id="CommentiButton" class="falesiaButton">Visualizza Commenti</button>
			
			<div id="commentiFalesia">
			
				<% for(CommentoFalesia c : commenti){%>
				
					<div id="commento">
					
						<p><%= c.getCommento() %></p>
					
					</div>
				
				<% }%>
			
			</div>
	
		<%@include file="WebsiteFooter.jsp" %>
</body>
</html>