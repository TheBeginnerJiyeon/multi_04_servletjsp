<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>requestScope와 sessionScope 테스트</h2>
	<h3>requestScope 값 출력하기</h3>
	이름 : ${ requestScope.member.name } <br>
	나이 : ${ requestScope.member.age } <br>
	전화번호 : ${ requestScope.member.phone } <br>
	이메일 : ${ requestScope.member.email } <br>
	
	<h3>sessionScope 값 출력하기</h3>
	이름 : ${ sessionScope.member.name } <br>
	나이 : ${ sessionScope.member.age } <br>
	전화번호 : ${ sessionScope.member.phone } <br>
	이메일 : ${ sessionScope.member.email } <br>
	
	<!-- 우선순위 테스트 하면 좁은 범위부터 값을 탐색한다.  -->
	<!-- sessionScope보다 requestScope가 범위가 좁기 때문에 requestScope를 우선한다 -->
	<h3>우선순위 테스트</h3>
	이름 : ${ member.name } <br>
	나이 : ${ member.age } <br>
	전화번호 : ${ member.phone } <br>
	이메일 : ${ member.email } <br>
	
	
	
</body>
</html>