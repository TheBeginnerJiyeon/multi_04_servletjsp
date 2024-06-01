<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%//세션은 오브젝트타입 으로 받아옴 
    int view = (int)session.getAttribute("view"); //int(작) <-- Object(큰) 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
저장된 세션값은 <%= view %> <br>
<a href="count.jsp">조회 수 증가</a>
</body>
</html>