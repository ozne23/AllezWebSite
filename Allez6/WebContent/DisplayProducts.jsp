<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   import = "Model.ModelProdotto,java.util.*,Beans.Prodotto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/Displayproducts.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<%
	ModelProdotto model = new ModelProdotto();

	LinkedList<Prodotto> prodotti = (LinkedList<Prodotto>) model.doRetrieveAll("nome");
%>

<script>
	
	function myFunction(p)
	{
		$("#var1").val(p);
		$("form").submit();
		
	}
		
	
	
	
</script>


<form style="display: hidden" action="Prodotto.jsp" method="GET" id="form">
  <input type="hidden" id="var1" name="CodProdotto" value=""/>
</form>

	<section id = "display-box">
		<article id = "main-container">
			<div class="row">
				
				
				<%
					for(Prodotto p : prodotti){
						%>
						<div class="column">
						<table >
						  <tr>
						  
						  	<td>
								  		 <button onclick="myFunction(<%= p.getCodice() %>)"> 
								  		 
								  <div class="immagine" style="background-image: url(<%= p.getImmagine()%>)"> 
								  <!--   <img src="<%= p.getImmagine() %>"  alt="<%= p.getNome() %>" style="width:100%"> -->
								   </div>
								   </button> 
						  	</td>
						  
						  </tr>
						  
						   <tr>
						  
						  	<td>
						  				<button class="ButtonCarrello" value="aggiungi al carrello"> aggiungi al carrello </button> 
						  	</td>
						  
						  </tr>


						  
						   
						   
						   
						   </table>
						  </div><% } %>
		
		
		<!--   <div class="column">
		   <button onclick="window.location.href = 'https://w3docs.com';"> 
		   	<img src=""  alt="immagine non disponibile" style="width:100%">
		   </button> 
		  </div>
		  <div class="column">
		  	 <button onclick="window.location.href = 'https://w3docs.com';">
		    	<img src="./Icons/BlackDiamondLogo.png"  style="width:100%">
		  	 </button>
		  </div>
		  <div class="column">
		  	 <button onclick="window.location.href = 'https://w3docs.com';">
		    	<img src="./Icons/LaSportivaLogo.png"  style="width:100%">
		     </button>
		  </div>
		  <div class="column">
		   <button onclick="window.location.href = 'https://w3docs.com';">
		    	<img src="./Icons/PetzlLogo.png"  style="width:100%">
		    </button>
		  </div>-->
		  </div>
		</article>
	</section>
</body>
</html>