<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>parameter 값 받아서 출력하기</h2>
		<p>
		해당 페이지 요청 시에 전달값은 내부적으로 param 영역에 저장되어 있음 <br>
		param : 해당 페이지 요청시 전달된 파라미터 값을 받아올 때 사용 <br>
		paramValues : 해당 페이지 요청시 전달된 파라미터 값들을 배열로 받아올 때 사용
	</p>
	
	<%
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	String[] no = request.getParameterValues("no");
	String option = request.getParameter("option");
	%>
	
	상품명 : <%= name %> <br>
	가격 : <%= price %> <br>
	제품번호 : <%= no[0] %> 와 <%= no[1] %> <br>
	옵션 : <%= option %>
	
	
	상품명 : ${ param.name } <br>
	가격 : ${ param.price } <br>
	제품번호 : ${ paramValues.no["0"] } 와 ${ paramValues.no[1] } <br><!-- 인덱스 넣어줄떄 문자열''싱글, 숫자모두 가능  -->
	옵션 : ${ (empty param.option)? "옵션없음" : param.option } <br><!-- param.option 이 비어있는지에 따라  -->
	
</body>
</html>