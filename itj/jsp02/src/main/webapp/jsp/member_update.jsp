<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="com.multi.jsp.member.MemberDTO"%>
<%@page import="com.multi.jsp.member.MemberDAO"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <%


            String id = request.getParameter("id");
            String tel = request.getParameter("tel");
            String pw = "";
            String name = "";


            MemberDAO dao = new MemberDAO();

            int result = dao.update(id, tel);

            String resultText = "업데이트 실패함";

            if(result==1){
                resultText = "업데이트 성공함";

            }


            dao = new MemberDAO();
            MemberDTO dto = dao.one(id);


            tel = dto.getTel();
            pw = dto.getPw();
            name = dto.getName();





        %>



    <%= resultText %>
    <%= result %>
    <h5>당신이 수정한 회원정보를 확인해주세요.</h5>
    <hr color="red">

    <%= dto %><br>
    가입한 아이디는 <%= id %> <br> <!-- id변수에 있는 것 보여줘(프린트) -->
    가입한 패스워드는 <%= pw %> <br>
    가입한 이름은 <%= name %> <br>
    가입한 전화번호는 <%= tel %> <br>



</body>
</html>