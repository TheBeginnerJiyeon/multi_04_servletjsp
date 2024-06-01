<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//쿠키생성
    	//브라우저에 저장할 정보 한개당 한쿠키
    	Cookie c1 = new Cookie("apple", "1000"); //이름+값
    	Cookie c2 = new Cookie("melon", "2000"); //이름+값
    	Cookie c3 = new Cookie("ice", "3000"); //이름+값


    	//브라우저에 심자. response내장된 객체
    	//HttpServletResponse response = new HttpServletResponse();
    	//브라우저 <----- 서버 //쿠키를 서버에서 브라우저로 보낸다
    	//response.out.print("<html><head>~~~~</head></html>")

    	// 쿠키 유효 기간 설정 (선택 사항, 1일 동안 유효)
            c1.setMaxAge(60*60*24);
            c2.setMaxAge(60*60*24);
            c3.setMaxAge(60*60*24);


    	response.addCookie(c1);
    	response.addCookie(c2);
    	response.addCookie(c3);


    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>브라우저에 쿠키심기 완료!</h3>
<a href="read_cookie.jsp">쿠키보기</a>
</body>
</html>