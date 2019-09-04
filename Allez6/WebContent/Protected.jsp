<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	Boolean access = (Boolean) session.getAttribute("access");
	if(access==null || access==false)
	{
		response.sendRedirect(request.getContextPath() + "/Loginjsp.jsp");
	}
%>

</head>
<body>
<h1>Sei entrato come utente</h1>
<p><a href="Logout">Logout</a></p>
</body>
</html>