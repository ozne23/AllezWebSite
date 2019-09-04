<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/HomePresentation.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
</head>
<body>

<script>



$(document).ready(function(){
	$('.rowCard').click(function() {
	      window.location.href='./NegozioAbbigliamento.jsp?categoria=' + $(this).attr('id');
	});
	});

</script>

	<div class="rowCard" id="abbigliamento">
	        <div class="card-image">
	          <img src="./images/abbigliamentoPre.jpg">
	          
	        </div>
	        
	        <div class="post-content">
	        	<h1>Abbigliamento</h1>
	        	 <p>In questa sezione troverete scarpe da arrampicata e abbigliamento funzionale adatto a tutte le esigenze. Allez Arrampicata fornisce l’equipaggiamento perfetto per esprimervi 
	        	 al meglio in qualsiasi contesto, sia su pareti outdoor 
	        	 che nelle palestre d'arrampicata indoor, ma anche in situazioni
	        	  di vita quotidiana. Calzature ed abbigliamento adatti a tutti i contesti: dal boulder, alle vie lunghe, dalle placche agli strapiombi. Per chi ricerca le massime prestazioni, sensibilità, comfort e durabilità e per chi vuole esprimere la propria appartenenza alla climbing community. </p>
	        	  <br>
	        	  <br>
	        	  
	        	  <h2>Vai al negozio</h2>
	        </div>
	</div>
	
	<div class="rowCard" id="attrezzatura">
	<div class="post-content">
	<h1>Attrezzatura</h1>
	        	 <p>In questa sezione troverete imbrachi da arrampicata e corde adatte a tutte le esigenze. Allez Arrampicata fornisce l’equipaggiamento perfetto per esprimervi 
	        	 al meglio in qualsiasi contesto, sia su pareti outdoor 
	        	 che nelle palestre d'arrampicata indoor, ma anche in situazioni
	        	  di vita quotidiana. Calzature ed abbigliamento adatti a tutti i contesti: dal boulder, alle vie lunghe, dalle placche agli strapiombi. Per chi ricerca le massime prestazioni, sensibilità, comfort e durabilità e per chi vuole esprimere la propria appartenenza alla climbing community.  </p>
	        	   
	        	   <br>
	        	  <br>
	        	  
	        	  <h2>Vai al negozio</h2>
	        </div>
	        
	        <div class="card-image">
	          <img src="./images/attrezzaturaPre.jpg">
	        </div>
	        
	</div>
	
	
	<div class="rowCard" id="sicurezza">
	        <div class="card-image">
	          <img src="./images/sicurezzaPre.jpg">
	        </div>
	        
	        <div class="post-content">
	        	<h1>Sicurezza</h1>
	        	 <p>In questa sezione troverete caschi da arrampicata e fettuccie funzionali adatte a tutte le esigenze. Allez Arrampicata fornisce l’equipaggiamento perfetto per esprimervi 
	        	 al meglio in qualsiasi contesto, sia su pareti outdoor 
	        	 che nelle palestre d'arrampicata indoor, ma anche in situazioni
	        	  di vita quotidiana. Calzature ed abbigliamento adatti a tutti i contesti: dal boulder, alle vie lunghe, dalle placche agli strapiombi. Per chi ricerca le massime prestazioni, sensibilità, comfort e durabilità e per chi vuole esprimere la propria appartenenza alla climbing community. </p>
	        	   
	        	   <br>
	        	  <br>
	        	  
	        	  <h2>Vai al negozio</h2>
	        </div>
	</div>

</body>
</html>