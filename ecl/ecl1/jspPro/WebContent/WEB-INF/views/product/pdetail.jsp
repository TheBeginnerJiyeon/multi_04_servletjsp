<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="container my-4">
    <table class="table table-striped table-bordered">
    	<input type="hidden" id="productId" value="${requestScope.productlist[0].id}" />
	
        <tbody>
            <tr>
                <th width="150px">상품아이디</th>
                <td colspan="5">${requestScope.productlist[0].id}</td>
            </tr>
            <tr>
                <th>상품제목</th>
                <td>${requestScope.productlist[0].name}</td>
            </tr>
            <tr>
                <th>상품가격</th>
                <td>${requestScope.productlist[0].price}</td>

            </tr>
            <tr>
                <th>상세내용</th>
                <td  class="scrollable-cell">${requestScope.productlist[0].content}</td>
            </tr>
            <tr>
                <th>대표사진</th>
                <td class="text-center">
                    <img src="${pageContext.servletContext.contextPath}${requestScope.productlist[0].attachments[0].thumbnailPath}" class="img-fluid" alt="Product Image">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="d-flex justify-content-around">
                        <img src="${pageContext.servletContext.contextPath}${requestScope.productlist[0].attachments[1].thumbnailPath}" class="img-thumbnail" alt="Detail Image 1">
                        <img src="${pageContext.servletContext.contextPath}${requestScope.productlist[0].attachments[2].thumbnailPath}" class="img-thumbnail" alt="Detail Image 2">
                        <img src="${pageContext.servletContext.contextPath}${requestScope.productlist[0].attachments[3].thumbnailPath}" class="img-thumbnail" alt="Detail Image 3">
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="text-center">
        <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/list'">목록으로</button>
        <button class="btn btn-success" onclick="addToCart()">장바구니담기</button>
        <p>Product ID: <c:out value="${productId}" /></p>
        <c:if test="${!empty sessionScope.loginMember && sessionScope.loginMember.id.toString().equals('admin')}">
        	
        	 <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/update?productId=${requestScope.productlist[0].id}'">글 수정</button>
        	 <button class="btn btn-primary" onclick="location.href='${pageContext.servletContext.contextPath}/product/delete?productId=${requestScope.productlist[0].id}'">글 삭제</button>
        	
        	
        </c:if>
        
        
    </div>
</div>

			
	<script>
		function addToCart() {
		    var productId = document.getElementById('productId').value;
		    $.ajax({
		        type: "POST",
		        url: "${pageContext.servletContext.contextPath}/cart/add", 
		        data: {productId: productId},
		        success: function(response) {
		            alert(productId + "번 제품이 장바구니에 추가되었습니다.");
		            var choice = confirm('장바구니 페이지로 이동하시겠습니까?');
		            if (choice) {
		                window.location.href = '${pageContext.servletContext.contextPath}/product/basket';
		            }
		        },
		        error: function(xhr) {
		            alert('장바구니 추가에 실패했습니다.');
		        }
		    });
		}
		</script>

</body>
</html>