<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.multi.jsp.member.BoardDTO"%>
<%@page import="com.multi.jsp.member.BoardDAO"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%


            String no = request.getParameter("no");
            String title = request.getParameter("title");
            String content= request.getParameter("content");
            String categoryCode = "";
            String writer = "";

            BoardDAO dao = new BoardDAO();

            int result = dao.update(title, content, no);

            String resultText = "업데이트 실패함";

            if(result==1){
                resultText = "업데이트 성공함";

            }


            dao = new BoardDAO();
            BoardDTO dto = dao.one(no);


            no = dto.getNo();
            title = dto.getTitle();
            content= dto.getContent();
            categoryCode = dto.getCategoryCode();
            writer = dto.getWriter();




        %>



    <%= resultText %>
    <%= result %>
    <h5>당신이 수정한 글 정보를 확인해주세요.</h5>
    <hr color="red">

    <%= dto %><br>
    글 번호는 <%= no %> <br> <!-- no변수에 있는 것 보여줘(프린트) -->
    글 카테고리 코드는 <%= categoryCode %> <br>
    글 제목은 <%= title %> <br>
    글 내용은 <%= content %> <br>
    글 작가는 <%= writer %>




</body>
</html>