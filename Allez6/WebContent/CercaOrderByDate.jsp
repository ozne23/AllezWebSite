<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/WebsiteBody.css" type="text/css" rel="stylesheet">

</head>
<body>
<script type="text/javascript" src="JS/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#cerca').click(function() {
	      window.location.href='./ShowOrderByDate.jsp?datainizio='+$("#start-date").val()+"&datafine="+$("#end-date").val();
	});
	});
	

</script>
	<table>
			
				<tr>
					<td> Dal : <input type ="text" id = "start-date"></td>
				</tr>
				<tr>
					<td> al : <input type ="text" id = "end-date"></td>
				</tr>
				
				<td> <button id = "cerca"> Cerca </button></td>   
				</tr>
				</table>
</body>
</body>
</html>