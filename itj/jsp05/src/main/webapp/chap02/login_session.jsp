<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//로그인 성공한 경우 id를 세션으로 설정해주세요.!
//id가 세션으로 설정이 되어있다면 로그인 성공이라고 판단하자.!
String id = request.getParameter("id");
String pw = request.getParameter("pw");
//db에 저장된 id와 pw를 임의로 설정 
String id2 = "apple";
String pw2 = "1234";
String sessionId = null;
//id와 id2가 동일하고 pw와 pw2가 동일한지 비교해서 ==>String비교 
//모두 동일(&&)하면 id만 세션으로 잡아주세요.
//둘 중 하나라도 틀리면 다시 로그인하도록 링크를 넣어주세요.
//<a href=네이버로그인>로그인하는 페이지로 이동</a>
	if(session.getAttribute("id") == null && id.equals(id2) && pw.equals(pw2)) { //로그인 성공!
		session.setAttribute("id", "apple");
		//String id = "apple";
		out.print("<h3>로그인 성공</h3>");
		out.print("<script>alert('로그인성공')</script>");
		sessionId = (String)session.getAttribute("id"); 

	}else{
		sessionId = (String)session.getAttribute("id"); 

		out.print("<a href=login.jsp>로그인하는 페이지로 이동</a><br>");
		//response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id 에 저장된 세션값은 <%= sessionId %> <br>
// id 에 저장된 세션값은 apple <br>
<a href="news.jsp">뉴스로 링크</a><br>
<a href="mail.jsp">메일로 링크</a><br>
<a href="shopping.jsp">쇼핑으로 링크</a><br>
</body>
</html>