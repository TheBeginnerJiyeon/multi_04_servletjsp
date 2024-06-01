<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.multi.jsp.member.BoardDTO"%>
<%@page import="com.multi.jsp.member.BoardDAO"%>

<!--
    1. 데이터를 받아서 저장해두자.
    HttpServletRequest request = new HttpServletRequest(); 내장객체
    2. dao를 이용해서 데이터를 주면서 db처리해달라고 요청
    3. 요청에 대한 결과를 html을 만든다.
a

-->


<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    body{
       background: lime;
    }
    *{
       font-size: 20px;
       text-align: center;
    }
    .left {
       /* 여러개를 선택해서 지정하고 싶을 때 클래스를 사용. 클래스 중 left에 해당하는 것만 스타일을 지정해라. */
       /* 클래스 선택은 .클래스명 */
       width: 100px;
       background: blue;
       color: white;
    }
    .data {
       width: 100px;
       background: white;
       color: blue;
    }
    #bottom {
       background: red;
       color: yellow;
    }
    input{
       background: greenyellow;
    }
</style>


</head>
<body bgcolor="skyblue">

<%

            BoardDAO dao = new BoardDAO();

            String no = request.getParameter("no");

            BoardDTO board = dao.one(no);

            String boardNo = "글 정보 없음";
            String boardCategoryCode= "존재하지 않음";
            String boardTitle= "존재하지 않음";
            String boardContent= "존재하지 않음";
            String boardWriter= "존재하지 않음";

            if(board!=null){
               boardNo = board.getNo();
               boardCategoryCode= board.getCategoryCode();
               boardTitle= board.getTitle();
               boardContent= board.getContent();
               boardWriter= board.getWriter();
            }

        %>

        <%= board%><br>
        이 글의 번호는 <%= boardNo %><br>
        이 글의 카테고리 코드는 <%= boardCategoryCode %><br>
        이 글의 제목은 <%= boardTitle %><br>
        이 글의 내용은 <%= boardContent %><br>
        이 글의 작가는 <%= boardWriter %><br>







</body>
</html>