<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:if test="${not empty sessionScope.basket}">
    <c:set var="list" value="${sessionScope.basket}" scope="page" />
    장바구니 count: <c:out value="${fn:length(list)}"/>개
</c:if>



<%-- <%@page import="com.uni.shop.product.model.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<ProductDTO> list = null;
	if(session.getAttribute("basket") != null){
		list = (ArrayList<ProductDTO>) session.getAttribute("basket");
%>
	장바구니 count: <%=  list.size()%>개
<%		
	}
%>

 --%>