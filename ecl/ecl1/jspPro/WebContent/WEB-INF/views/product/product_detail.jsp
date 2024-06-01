<%@page import="com.multi.shop.product.model.dto.ProductDTO"%>
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
        // Setting attribute within the condition
        
        ProductDTO p = (ProductDTO) request.getAttribute("p");
    	
		request.setAttribute("p", p);
    	%>

</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
		<div class="container my-4">
    	<table class="table table-striped table-bordered">
				<tbody>
                    <tr>
                        <th scope="row" width="100">제품 아이디</th>
                        <td><strong>${ p.id }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">이름</th>
                        <td><strong>${ p.name }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">내용</th>
                        <td  class="scrollable-cell" height=300px><strong>${ p.content }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">가격</th>
                        <td><strong>${ p.price }</strong></td>
                    </tr>
                    <tr>
                        <th scope="row">회사 아이디</th>
                        <td><strong>${ p.companyId }</strong></td>
                    </tr>
                    
                    <tr>
                        <th scope="row">이미지</th>
                        <td><strong>${ p.img }</strong></td>
                    </tr>
                    
                    
                    <tr>
                        <th scope="row">생성날짜</th>
                        <td><strong>${ p.createdDate }</strong></td>
                    </tr>
                    
                    
                    <tr>
                        <th scope="row">생성한 사람</th>
                        <td><strong>${ p.createdPerson }</strong></td>
                    </tr>
                    
                    
                    <tr>
                        <th scope="row">수정 날짜</th>
                        <td><strong>${ p.modifiedDate }</strong></td>
                    </tr>
                    
                    
                    <tr>
                        <th scope="row">수정한 사람</th>
                        <td><strong>${ p.modifiedPerson }</strong></td>
                    </tr>
                    
                    
                    <tr>
                        <th scope="row">상태</th>
                        <td><strong>${ p.status }</strong></td>
                    </tr>
                    
                </tbody>
            </table>
        </div>

    <div class="text-center mt-4">
    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/list'">목록으로</button>
    
    
    <c:if test="${!empty sessionScope.loginMember && b.writer.equals(sessionScope.loginMember.id.toString())}">
    	
    	
    	
    	
	    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/update'">수정하기</button>
	    <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/delete?productId=${p.id}'">삭제하기</button>
    
    </c:if>
    
    
    
    
    </div>
  		
  	<br>
  	<br>
  	<br>
  	
  
</body>
</html>