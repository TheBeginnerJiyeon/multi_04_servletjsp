<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<%/* 현재 페이지가 JSP 오류 처리용 페이지인지를 정의한다.
값은 true 또는 false(default)이다.
true인 경우, exception 내장 객체를 사용할 수 있다.

http://localhost:8086/jsp06/chap01/errorTest.jsp?id=test

하면 오류 안남..

*/
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<img src="../img/error.png">
</center>

	<%
		String exceptionType = exception.getClass().getName();
		String exceptionMessage = exception.getMessage();
	%>
	
	<h1 align="center"><%= exceptionType %></h1>
	<h3 align="center"><%= exceptionMessage %></h3>
	<button onclick = "history.back()">이전페이지로</button>

	
</body>
</html>




