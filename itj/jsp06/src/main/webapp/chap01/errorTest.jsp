<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
    <%

        String param = request.getParameter("id");
        if(param.equals("test")){
           param = "에러 발생하지 않음";
        }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= param %>
</body>
</html>