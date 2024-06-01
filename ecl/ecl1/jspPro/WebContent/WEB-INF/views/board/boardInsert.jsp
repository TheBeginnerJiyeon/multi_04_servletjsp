<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CSS 추가 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/project.css">
<style>
	.login-area{height:100px;}
	.nav-area{background:black;height:50px;color:white;}
	.menu{
		display:table-cell;
		width:250px;
		height:50px;
		text-align:center;
		vertical-align:middle;
		font-size:20px;
		font-weight:bold;
	}
	.menu:hover{cursor:pointer;background:darkgray;}
	.login-area a{text-decoration:none; color:black; font-size:0.8em;}
	
</style>
</head>
<body>
	<h1 align="center">글 쓰기!!</h1>
	<br>
	
	<div class="Write-area">
		<c:if test="${ !empty sessionScope.loginMember }">
		
			<form action="${ pageContext.servletContext.contextPath}/board/insert" method="post">
				<table align="center">
					<tr>
						<td>카테고리 코드 : </td>
						<td><input type="text" name="categoryCode"></td>
						
					</tr>
					<tr>
						<td>제목 : </td>
						<td><input type="text" name="title"></td>
					</tr>
					
					<tr>
						<td>내용 : </td>
						<td><input type="text" name="content"></td>
					</tr>
					
					<tr>
						<td>writer : </td>
						<td><input type="text" name="writer"></td>
					</tr>
					
					
					<tr>
						<td colspan="2"><button  class = "btns" type="submit" id="Write-btn">글 작성</button></td>
					</tr>
					
					
				</table>
			</form>
		</c:if>
		
		<c:if test="${ empty sessionScope.loginMember }">
			<table align="center">
				<tr>
					<td colspan="2">
						<h3>글 작성을 위해서는 로그인이 필요합니다.</h3>
						
						<button class="btns" onclick="location.href='${ pageContext.servletContext.contextPath}/main.jsp';">로그인 페이지로 이동</button>
					</td>
				</tr>
			</table>
		</c:if>
	</div>
	<!-- ------------------------- 2. 게시물 관련 서비스 ---------------------- -->
	<div class="nav-area" align="center">
		<div class="menu" onclick="location.href='${pageContext.servletContext.contextPath }';">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='${pageContext.servletContext.contextPath }/board/list';">게시판</div>
		<div class="menu" onclick="location.href='${pageContext.servletContext.contextPath }/product/list';">제품</div>
		<div class="menu" onclick="location.href='${pageContext.servletContext.contextPath }/product/basket';">장바구니</div>
	</div>
</body>
</html>