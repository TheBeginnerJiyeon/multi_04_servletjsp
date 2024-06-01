<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.multi.jsp.member.MemberDTO"%>
<%@page import="com.multi.jsp.member.MemberDAO"%>

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

            MemberDAO dao = new MemberDAO();

            String id = request.getParameter("id");

            MemberDTO member = dao.one(id);

            String memberString = "회원 정보 없음";
            String memId= "존재하지 않음";
            String memPw= "존재하지 않음";
            String memName= "존재하지 않음";
            String memTel= "존재하지 않음";

            if(member!=null){
                memberString = member.toString();
                memId= id;
                memPw= member.getPw();
                memName= member.getName();
                memTel= member.getTel();
            }

        %>

        <%= member%><br>
        이 멤버의 아이디는 <%= memId %><br>
        이 멤버의 비밀번호는 <%= memPw %><br>
        이 멤버의 이름은 <%= memName %><br>
        이 멤버의 <%= memTel %><br>







</body>
</html>