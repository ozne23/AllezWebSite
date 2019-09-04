<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "Model.* ,Control.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">
</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script>

/*function addFalesia(){
	$.get('RegFalesiaServlet', {"indice": $("#indice").val(), "nome": $("#nome").val(),
		"regione": $("#regione").val(), "immagine": $("#immagine").val(),
		"descrizione": $("#descrizione").val(),
		"posizione": $("#posizione").val(),
		},
			function(resp){
	});
}*/
</script>
<h1>Registrazione falesia</h1>

	<form method="POST" action="RegFalesiaServlet" enctype="multipart/form-data">
	<table>
	
		<tr>
			<td>Indice:</td>
			<td><input type ="number" name = "indice" required/></td>
		</tr>
		
		<tr>
			<td>Nome:</td>
			<td><input type ="text" name = "nome" required/></td>
		</tr>
		
		<tr>
			<td>Provincia:</td>
			<td><select name ="regione">
				    <option> value="Agrigento">Agrigento</option>
					<option value="Alessandria">Alessandria</option>
					<option value="Ancona">Ancona</option>
					<option value="Aosta">Aosta</option>
					<option value="Arezzo">Arezzo</option>
					<option value="Ascoli Piceno">Ascoli Piceno</option>
					<option value="Asti">Asti</option>
					<option value="Avellino">Avellino</option>
					<option value="Bari">Bari</option>
					<option value="Barletta-Andria-Trani">Barletta-Andria-Trani</option>
					<option value="Belluno">Belluno</option>
					<option value="Benevento">Benevento</option>
					<option value="Bergamo">Bergamo</option>
					<option value="Biella">Biella</option>
					<option value="Bologna">Bologna</option>
					<option value="Bolzano">Bolzano</option>
					<option value="Brescia">Brescia</option>
					<option value="Brindisi">Brindisi</option>
					<option value="Cagliari">Cagliari</option>
					<option value="Caltanissetta">Caltanissetta</option>
					<option value="Campobasso">Campobasso</option>
					<option value="Carbonia-iglesias">Carbonia-iglesias</option>
					<option value="Caserta">Caserta</option>
					<option value="Catania">Catania</option>
					<option value="Catanzaro">Catanzaro</option>
					<option value="Chieti">Chieti</option>
					<option value="Como">Como</option>
					<option value="Cosenza">Cosenza</option>
					<option value="Cremona">Cremona</option>
					<option value="Crotone">Crotone</option>
					<option value="Cuneo">Cuneo</option>
					<option value="Enna">Enna</option>
					<option value="Fermo">Fermo</option>
					<option value="Ferrara">Ferrara</option>
					<option value="Firenza">Firenze</option>
					<option value="Foggia">Foggia</option>
					<option value="Forlì">Forl&igrave;-Cesena</option>
					<option value="Frosinone">Frosinone</option>
					<option value="Genova">Genova</option>
					<option value="Gorizia">Gorizia</option>
					<option value="Grosseto">Grosseto</option>
					<option value="Imperia">Imperia</option>
					<option value="Isernia">Isernia</option>
					<option value="La spezia">La spezia</option>
					<option value="L'Aquila">L'aquila</option>
					<option value="Latina">Latina</option>
					<option value="Lecce">Lecce</option>
					<option value="Lecco">Lecco</option>
					<option value="Livorno">Livorno</option>
					<option value="Lodi">Lodi</option>
					<option value="Lucca">Lucca</option>
					<option value="Macerata">Macerata</option>
					<option value="Mantova">Mantova</option>
					<option value="Massa-Carrara">Massa-Carrara</option>
					<option value="Matera">Matera</option>
					<option value="Medio Campidano">Medio Campidano</option>
					<option value="Messina">Messina</option>
					<option value="Milano">Milano</option>
					<option value="Modena">Modena</option>
					<option value="Monza e della Brianza">Monza e della Brianza</option>
					<option value="Napoli">Napoli</option>
					<option value="Novara">Novara</option>
					<option value="Nuoro">Nuoro</option>
					<option value="Ogliastra">Ogliastra</option>
					<option value="Olbia-Tempio">Olbia-Tempio</option>
					<option value="Oristano">Oristano</option>
					<option value="Padova">Padova</option>
					<option value="Palermo">Palermo</option>
					<option value="Parma">Parma</option>
					<option value="Pavia">Pavia</option>
					<option value="Perugia">Perugia</option>
					<option value="Pesaro e Urbino">Pesaro e Urbino</option>
					<option value="Pescara">Pescara</option>
					<option value="Piacenza">Piacenza</option>
					<option value="Pisa">Pisa</option>
					<option value="Pistoia">Pistoia</option>
					<option value="Pordenone">Pordenone</option>
					<option value="Potenza">Potenza</option>
					<option value="Prato">Prato</option>
					<option value="Ragusa">Ragusa</option>
					<option value="Ravenna">Ravenna</option>
					<option value="Reggio di Calabria">Reggio di Calabria</option>
					<option value="Reggio nell'Emilia">Reggio nell'Emilia</option>
					<option value="Rieti">Rieti</option>
					<option value="Rimini">Rimini</option>
					<option value="Roma">Roma</option>
					<option value="Rovigo">Rovigo</option>
					<option value="Salerno">Salerno</option>
					<option value="Sassari">Sassari</option>
					<option value="Savona">Savona</option>
					<option value="Siena">Siena</option>
					<option value="Siracusa">Siracusa</option>
					<option value="Sondrio">Sondrio</option>
					<option value="Taranto">Taranto</option>
					<option value="Teramo">Teramo</option>
					<option value="Terni">Terni</option>
					<option value="Torino">Torino</option>
					<option value="Trapani">Trapani</option>
					<option value="Trento">Trento</option>
					<option value="Treviso">Treviso</option>
					<option value="Trieste">Trieste</option>
					<option value="Udine">Udine</option>
					<option value="Varese">Varese</option>
					<option value="Venezia">Venezia</option>
					<option value="Verbano-Cusio-Ossola">Verbano-Cusio-Ossola</option>
					<option value="Vercelli">Vercelli</option>
					<option value="Verona">Verona</option>
					<option value="Vibo valentia">Vibo valentia</option>
					<option value="Vicenza">Vicenza</option>
					<option value="Viterbo">Viterbo</option>
			
			</select></td>
		</tr>
	
		
		<tr>
			<td>Immagine:</td>
			<td><input type = "file" name = "file" size = "50" required></td>
		</tr>
		
		<tr>
			<td>Posizione:</td>
			<td><input type ="text" name = "posizione" required/></td>
		</tr>
		 
		 <tr>
		 
		 	<td>Descrizione:</td>
			<td><textarea name = "descrizione"></textarea></td>
		</tr>
		 
		 <tr>
			 <td></td>
			 <td> <input type = "submit" value = "Submit" /> </td>
		 </tr>
	</table>
	</form>


</body>
</html>