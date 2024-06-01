<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%


            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            String result1 = "아이디는 " + id;
            String result2 = "비밀번호 " + pw;
            String result3 = "이름 " + name;
            String result4 = "전화번호 " + tel;


        %>

        당신의 회원가입 정보입니다.<br>
        <hr>
        <%= result1  %><br>
        <%= result2  %><br>
        <%= result3  %><br>
        <%= result4 %><br>



</body>
</html>