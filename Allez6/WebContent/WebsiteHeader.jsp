<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
</head>
<!--<h1>
    	<img src="./LogoImg/logo_final_gecko.png" alt="Logolx" width="140" height="100"   class = logosx>
    	<img src="./LogoImg/TemaGecko.png" alt="Logodx" width="100" height="100" class = "logodx">
		<input class="searchbar" type = "text" placeholder = "cerca..." />
		<i class="fab fa-searchengin"></i>
	</h1> -->

<form action="SearchServlet">

	<table id="Tablesearch">
		<tr>
			<td><a href=./Home.jsp><img src="./LogoImg/logo_final_gecko.png" alt="Logolx" 
				width="140" height="100" class=logosx></a></td>
			<td id="TDsearch"><input id="searchBar" class="searchbar" name="testo" 
				type="text" placeholder="cerca..." onfocus="this.placeholder=''" onblur="this.placeholder='cerca...'"/></td>

			<td><button type="submit" id="searchButton"><i class="fas fa-search"></i></button></td>
		</tr>

	</table>

</form>

</html>