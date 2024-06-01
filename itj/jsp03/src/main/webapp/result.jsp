<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
        String id = (String) request.getAttribute("id");
        String pw = (String) request.getAttribute("pw");
        String name = (String) request.getAttribute("name");
        String hobby = (String) request.getAttribute("hobby");
        String gender = (String) request.getAttribute("gender");
        String religion = (String) request.getAttribute("religion");
        String introduction = (String) request.getAttribute("introduction");


        String imagePath = request.getContextPath() + "/resources/img/";
        String yesImagePath = imagePath + "ok.JPG";

    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>아이디 : <%= id %></h3>
	<h3>비번 : <%= pw %></h3>
	<h3>이름 : <%= name %></h3>
	<h3>취미 : <%= hobby %></h3>
	<h3>성별 : <%= gender %></h3>
	<h3>종교 : <%= religion %></h3>
	<h3>소개 : <%= introduction %></h3>

	<img src= <%=  yesImagePath%> >
</body>
</html>