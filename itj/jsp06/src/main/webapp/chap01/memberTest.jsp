<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="com.multi.dto.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="member"/>
<!-- 자료형 일치하지 않으면 에러 발생함 -->
<jsp:setProperty property="id" name="member" value="apple"/>
<jsp:setProperty property="pw" name="member" value="1234"/><!--  int 상관없이 스트링 타입  -->
<jsp:setProperty property="name" name="member" value="apple"/>
<jsp:setProperty property="tel" name="member" value="011"/>

<jsp:getProperty property="id" name="member"/><!--  출력됨 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
출력 :
<%= member.getName() %>
</body>
</html>