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


            String category = request.getParameter("category");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");

            BoardDAO dao = new BoardDAO();
            BoardDTO dto = new BoardDTO();

            dto.setCategoryCode(category);
            dto.setTitle(title);
            dto.setContent(content);
            dto.setWriter(writer);


            int result = dao.insert(dto);

            String resultText = "글쓰기 실패함";

            if(result==1){
                resultText = "글쓰기 성공함";
            }



        %>



    <%= resultText %>
    <h5>당신이 입력한 글 정보를 확인해주세요.</h5>
    <hr color="green">
    카테고리는 <%= category %> <br>
    제목은 <%= title %> <br>
    내용은 <%= content %> <br>
    글쓴이는 <%= writer %> <br>



</body>
</html>