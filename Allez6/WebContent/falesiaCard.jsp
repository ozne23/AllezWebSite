<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "Model.ModelFalesia,java.util.*,Beans.Falesia"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/FalesiaCampania.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script>

$(document).ready(function(){
	$('.rowCard').click(function() {
	      window.location.href='./viaCard.jsp?falesia=' + $(this).attr('id');
	});
	});

</script>
<%
	ModelFalesia model = new ModelFalesia();

	LinkedList<Falesia> falesie = (LinkedList<Falesia>) model.doRetrieveAll("nome",request.getParameter("falesia"));
%>    
  
 			
					<%
					for(Falesia f : falesie){
						%>
							<div class="rowCard" id = "<%=f.getIndice()%>">
							<div class="card-image">
	         							 <img src="<%= f.getImmagine() %>">
	         					</div>
							
							  	
	         					<div class="post-content">   
	         					  <h1><%= f.getNome() %></h1>	
							 	 <p ><%= f.getDescrizione() %></p>
								<a id="vaiMappa" href=<%= f.getPosizione() %> > Via alla mappa </a>      	  
								</div>
			</div>
						
						<% } %>
			

</body>
</html>