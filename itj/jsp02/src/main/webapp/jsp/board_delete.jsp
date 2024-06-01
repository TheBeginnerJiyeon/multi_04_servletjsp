<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.multi.jsp.member.BoardDTO"%>
<%@page import="com.multi.jsp.member.BoardDAO"%>



    <!--
    jsp에서 해야하는 작업 3가지
    1) form안에 입력한 데이터 받아서 저장해두자. ==> java
    2) 받은 데이터를 DAO에게 주자.  ==> java
    3) 결과를 html로 만들자. ==> html
             -->





<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



    <%


            String no = request.getParameter("no");

            BoardDAO dao = new BoardDAO();


            int result = dao.delete(no);

            String resultText = "글 삭제 실패함";

            if(result==1){
                resultText = "글 삭제 성공함";
            }



        %>



    <%= resultText %>

    삭제를 원하는 글 숫자는 <%= no %> <br> <!-- no변수에 있는 것 보여줘(프린트) -->



</body>
</html>