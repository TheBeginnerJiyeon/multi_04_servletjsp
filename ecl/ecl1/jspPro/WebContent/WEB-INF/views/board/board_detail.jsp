<%@page import="com.multi.shop.board.model.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
</style>

<% 
        // Setting session attribute within the condition
        
        BoardDTO b = (BoardDTO) request.getAttribute("b");
    	
		request.getSession().setAttribute("b", b);
    	%>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
		<div class="container my-4">
    	<table class="table table-striped table-bordered">
				<tbody>
                    <tr>
                        <th scope="row" width="100">글번호</th>
                        <td><strong>${ b.no }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">제목</th>
                        <td><strong>${ b.title }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">작성자</th>
                        <td><strong>${ b.writer }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">조회수</th>
                        <td><strong>${ b.count }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">작성일</th>
                        <td><strong>${ b.createDate }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">내용</th>
                        <td  class="scrollable-cell" height=300px><strong>${ b.content }</strong></td>
                    </tr>
                </tbody>
            </table>
        </div>

    <div class="text-center mt-4">
    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/board/list'">목록으로</button>
    
    
    <c:if test="${!empty sessionScope.loginMember && b.writer.equals(sessionScope.loginMember.id.toString())}">
    	
    	
    	
    	
	    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/board/update'">수정하기</button>
	    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/board/delete'">삭제하기</button>
    
    </c:if>
    
    
    
    
    </div>
  		
  	<br>
  	<br>
  	<br>
  	
  
</body>
</html>