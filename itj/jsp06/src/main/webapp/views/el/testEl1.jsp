<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		int age = (Integer)request.getAttribute("age");
		String phone = (String)request.getAttribute("phone");
	
	%>
	
	
	name : <%= name %> <br>
	age : <%= age %> <br>
	phone : <%= phone %> <br> 
	
	
	<h3> EL을 이용해서 보다 쉽게 request, session 객체에 저장된 값들 출력하기</h3>
	<p>
		EL은 get을 통해 값을 빼올 필요 없이 키값만 제시해서 바로 접근 가능   <br>
		내부적으로 해당 객체의 getXXX을 자동적으로 활용하여 해당 키에 저장된 밸류값을 읽음 <br><br>
		EL은 request, session 등 JSP 내장 객체를 구분하지 않아도 <br>
		자동으로 입력된 속성명(키값)을 검색하여 존재하는 경우 값을 가져옴
	</p>
	
	
	name : ${ requestScope.name } <br>
	age : ${ requestScope.age } <br>
	phone : ${ requestScope.phone } <br> 
	
	<!-- 내장객체 이름requestScope은 생략이가능하다 -->
	<!-- 스코프 범위 생략 가능함(알아서 찾음) -->
	name : ${ name } <br>
	age : ${ age } <br>
	phone : ${ phone } <br>
	
	
	<br>
	
	<h2>items 이름으로 저장된 리스트 정보 출력하기</h2>
	
	<% ArrayList items = (ArrayList)request.getAttribute("items"); %>
	
	<% for(int i = 0; i < items.size(); i++){ %>
		<%= i %> : <%= items.get(i) %> <br>
	<% } %> 
	
	
	0 : ${ requestScope.items[0] } <br>
	1 : ${ requestScope.items[1] } <br>
	2 : ${ requestScope.items[2] } <br>
	
	<br>
	0 : ${ items[0] } <br>
	1 : ${ items[1] } <br>
	2 : ${ items[2] } <br>
	
</body>
</html>