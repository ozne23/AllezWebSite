<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
$(document).ready(function(){
	$('#cerca').click(function() {
	      window.location.href='./ShowOrderByClient.jsp?client='+$("#client").val();
	});
	});
	

</script>
	<table>
			
				<tr>
					<td> username: <input type ="text" id = "client"></td>
				</tr>
				
				<td> <button id = "cerca"> Cerca </button></td>   
				</tr>
				</table>
</body>
</html>