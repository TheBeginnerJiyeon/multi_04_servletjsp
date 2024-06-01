<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%

    	session.setAttribute("view", 0);



    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

저장된 세션값은 <%= session.getAttribute("view") %> <br>

<a href="session_get.jsp">세션 설정 보기</a><!--없는데 보려고 하면 에러남 -->
</body>
</html>