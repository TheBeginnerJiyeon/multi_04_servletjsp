<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//쿠키생성
    	//브라우저에 저장할 정보 한개당 한쿠키
    	Cookie c1 = new Cookie("name", "hong"); //이름+값
    	Cookie c2 = new Cookie("age", "100"); //이름+값
    	//브라우저에 심자. response내장된 객체
    	//HttpServletResponse response = new HttpServletResponse();
    	//브라우저 <----- 서버 //쿠키를 서버에서 브라우저로 보낸다
    	//response.out.print("<html><head>~~~~</head></html>")
    	response.addCookie(c1);
    	response.addCookie(c2);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>브라우저에 쿠키심기 완료!</h3>
<a href="cookie_check.jsp">쿠키보기</a>
</body>
</html>