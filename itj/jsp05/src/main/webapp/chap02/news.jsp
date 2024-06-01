<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("id") == null){
       //id라는 이름으로 저장된 세션이 없다.
       out.print("로그인되지 않았습니다. 먼저 로그인을 해주세요.<br>");
       //out.print("로그인 아이디: <input name=id>");
    }else{
       //id라는 이름으로 저장된 세션이 있다.
       out.print(session.getAttribute("id") +"님이 로그인되었습니다.");
    }


%>
<!-- 세션은 특정한 브라우저와 서버와의 연결을 의미!! -->
    <!-- news.jsp를 클릭했을 때, 1)로그인이 안되었으면, 로그인페이지로 자동으로 넘어가게 하고 -->
    <!--                      2)로그인이 되었으면, 로그인한 사람 누구인지 프린트!   -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뉴스페이지 - 로그인 되었을 때 댓글을 작성할 수 있습니다.
<br>
<% if(session.getAttribute("id") != null){%>
<a href="logout.jsp">로그아웃</a>
<%} %>
</body>
</html>