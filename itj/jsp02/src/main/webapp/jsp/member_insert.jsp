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
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");

            MemberDAO dao = new MemberDAO();
            MemberDTO dto = new MemberDTO();

            dto.setId(id);
            dto.setPw(pw);
            dto.setName(name);
            dto.setTel(tel);

            int result = dao.insert(dto);

            String resultText = "회원가입 실패함";

            if(result==1){
                resultText = "회원가입 성공함";
            }



        %>



    <%= resultText %>
    <h5>당신이 입력한 회원정보를 확인해주세요.</h5>
    <hr color="green">
    가입한 아이디는 <%= id %> <br> <!-- id변수에 있는 것 보여줘(프린트) -->
    가입한 패스워드는 <%= pw %> <br>
    가입한 이름은 <%= name %> <br>
    가입한 전화번호는 <%= tel %> <br>



</body>
</html>