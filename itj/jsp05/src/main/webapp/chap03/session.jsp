<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%


session.setAttribute("tennis", "1000");
session.setAttribute("swim", "20000");



int session_val = Integer.parseInt((String)session.getAttribute("tennis")) + Integer.parseInt((String)session.getAttribute("swim")) ;


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
tennis와 swim을 둘 다 수강하는 경우 <%= session_val %> 이 수강료임 <br>

</body>
</html>