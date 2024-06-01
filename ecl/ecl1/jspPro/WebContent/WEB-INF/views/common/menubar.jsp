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
<%-- <script type="text/javascript">
        window.onload = function() {
            // Check if the loginDenied attribute is set
            var loginMsg = '<%= request.getAttribute("loginMsg") %>';
            
            alert(loginMsg);
            
        };
</script> --%>
</head>
<body>
	<h1 align="center">Welcome to JSP World!!</h1>
	<br>
	
	<div class="login-area">
		<c:if test="${ empty sessionScope.loginMember }">
		
			<form action="${ pageContext.servletContext.contextPath}/member/login" method="post">
				<table align="center">
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="userId"></td>
						<td rowspan="2"><button  class = "btns" type="submit" id="login-btn">로그인</button></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td><input type="password" name="userPwd"></td>
					</tr>
					<tr>
						<td colspan="3" align="center">
						<!-- https://join.shopping.naver.com/intro/effect.nhn 이렇게 확장자 쓰기도함. 하단 네이버 비지니스 -->
							<!-- <a href="WEB-INF/views/member/memberEnrollForm.jsp">회원가입</a> 이제부터는 바로 페이지 요청 불가.. -->
							<a href="${ pageContext.servletContext.contextPath}/member/insert"  >회원가입 </a> 
							<a href="" > 아이디/비번 찾기 </a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		
		<c:if test="${ !empty sessionScope.loginMember }">
			<table align="center">
				<tr>
					<td colspan="2">
						<h3>${ sessionScope.loginMember.name }님 환영합니다.</h3>
					
						<input type="button" class="btns" value="마이페이지" id="mypage">
						
						<button class="btns" onclick="location.href='${ pageContext.servletContext.contextPath}/member/logout';">로그아웃</button>
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