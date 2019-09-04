<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "Model.ModelProdotto,java.util.*,Beans.Prodotto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/ProductsCard.css" type="text/css" rel="stylesheet">
<link href="./css/Sidebar.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<%
	ModelProdotto model = new ModelProdotto();

	Boolean ric = (Boolean) session.getAttribute("ricerca");
	
	ArrayList<Prodotto> prodotti = null;
	
	String cat = "";
	
	if(ric==null)
	{
		 prodotti = (ArrayList<Prodotto>) model.doRetrieveAll("nome",request.getParameter("categoria"));
		 cat = request.getParameter("categoria");
	}else if(!ric){
		 prodotti = (ArrayList<Prodotto>) model.doRetrieveAll("nome",request.getParameter("categoria"));
		 cat = request.getParameter("categoria");
	}
	else{
		
		 prodotti = (ArrayList<Prodotto>) model.doRetrieveByName(request.getParameter("testo"));
		
		 prodotti.addAll((ArrayList<Prodotto>) model.doRetrieveByMarca(request.getParameter("testo")));
		session.removeAttribute("ricerca");
	}
		
%>





<script>
	
	function myFunction(p)
	{
		$("#var1").val(p);
		$("form").submit();
		
	}
</script>

<script>
	$(document).ready(function(){
	  $("#buttonFilter").click(function(){
	    $("#FilterBar").slideToggle("slow");
	  });
	  
	  $("#Ordinamento").change(function(){
		  
		  $.ajax({
			  type: "POST",
			  url: "OrdinamentoServlet",
			  data: "ord=" + $("#Ordinamento").val() + "&cat=" + "<%= cat%>",
			}).done(function(resp) {
				console.log(resp);
				for(i=0; i<resp.length;i++){
					var obj = JSON.parse(resp[i]);
					console.log(obj);
					document.getElementsByClassName("imgProd")[i].src = obj.immagine
					document.getElementsByClassName("nome")[i].innerHTML = obj.nome;
					document.getElementsByClassName("descrizione")[i].innerHTML = obj.descrizione;
				}
				
			});
		  
	  });
	  
	});

</script>

<div id = "sidebar">
	
		<button id="buttonFilter">Filtri    <i class="fas fa-filter"></i></button>
</div>

<div id = "FilterBar">
	
	<p>Ordinamento:</p>
	<select id="Ordinamento">
		<option value="nome ASC">Nome A-Z</option>
  		<option value="nome DESC">Nome Z-A</option>
  		<option value="codice ">Aggiunta crescente</option>
  		<option value="codice DESC">Aggiunta decrescente</option>
	</select>
	
</div>


<form style="display: hidden" action="Prodotto.jsp" method="GET" id="form">
  <input type="hidden" id="var1" name="CodProdotto" value=""/>
</form>

		

 			
					<% if(prodotti.size()<=0){%>
						<h1 style="text-align: center">Nessun prodotto trovato</h1>
					<%}else{%>
						<div class="container-cards"><%
						for(Prodotto p : prodotti){
							if(p.isCancellato() == 0){
						%>
							<div class="card">
							  <img class="imgProd" src="<%= p.getImmagine()%>" alt="Denim Jeans">
							  <h1 class="nome"><%= p.getNome() %></h1>
							  <p id="desc" class="descrizione"><%= p.getDescrizione() %></p>
				     		  <p><button onclick ="myFunction(<%= p.getCodice() %>)">Visualizza</button></p>
							  
							</div>
						
						<%}}%></div> <% }%>
						






</body>
</html>