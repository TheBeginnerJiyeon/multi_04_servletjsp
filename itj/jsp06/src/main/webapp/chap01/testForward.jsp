<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1><%= request.getAttribute("name") %>님 환영합니다.</h1>
    <h3 align="right"><%= request.getParameter("name") %>님 환영합니다.</h3>
    <h3 align="right">${param.name}님 환영합니다.</h3>
</body>
</html>