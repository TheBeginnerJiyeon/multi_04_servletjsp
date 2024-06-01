<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="../common/menubar.jsp" />
	<div class="container mt-4">
	<table id="listArea" class="table table-hover table-striped table-bordered">
	        <tr>
				<th scope="col" style="text-align: center; width: 100px;">아이디</th>
				<th scope="col" style="text-align: center; width: 200px;">이름</th>
				<th scope="col" style="text-align: center; width: 150px;">내용</th>
				<th scope="col" style="text-align: center; width: 50px;">가격</th>
				<th scope="col" style="text-align: center; width: 100px;">회사 아이디</th>
				<th scope="col" style="text-align: center; width: 100px;">이미지</th>
				<th scope="col" style="text-align: center; width: 100px;">생성날짜</th>
				<th scope="col" style="text-align: center; width: 100px;">생성한 사람</th>
				<th scope="col" style="text-align: center; width: 100px;">변경 날짜</th>
				<th scope="col" style="text-align: center; width: 100px;">변경한 사람</th>
				<th scope="col" style="text-align: center; width: 100px;">상태</th>
	        </tr>
	    <tbody>
	        <c:if test="${empty list}">
	            <tr>
	                <td colspan="5" class="text-center">조회된 내용이 없습니다.</td>
	            </tr>
	        </c:if>
	
	        <c:forEach var="p" items="${list}">
	            <tr>
	                <td class="text-center tdc"><c:out value="${p.id}" /></td>
	                <td class="text-center tdc">
	                    <a href="${pageContext.servletContext.contextPath}/product/selectone?id=${p.id}" class="text-decoration-none">
	                        <c:out value="${p.name}" />
	                    </a>
	                </td>
	                <td class="text-center tdc"><c:out value="${p.content}" /></td>
	                <td class="text-center tdc"><c:out value="${p.price}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.companyId}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.img}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.createdDate}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.createdPerson}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.modifiedDate}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.modifiedPerson}" /></td>
	                <td class="text-center tdc"> <c:out value="${p.status}" /></td>
	            </tr>
	        </c:forEach>
	    </tbody>
	</table>
	</div>
	<c:if test="${ !empty sessionScope.loginMember }">
	 <div align="center">
        <button class="btns" id="writeProduct" onclick="location.href='${pageContext.servletContext.contextPath}/product/insert'">제품입력</button>        
        <button class="btns" id="writeProduct" onclick="location.href='${pageContext.servletContext.contextPath}/product/update2'">제품수정</button>        
        <button class="btns" id="writeProduct" onclick="location.href='${pageContext.servletContext.contextPath}/product/delete2'">제품삭제</button>        
    </div>
	</c:if>
	<script>
		
	if(document.getElementsByClassName("tdc")) {
	    const $tds = document.getElementsByClassName("tdc");
	    for(let i = 0; i < $tds.length; i++) {
	        $tds[i].onmouseenter = function() {
	            this.parentNode.style.backgroundColor = "skyblue";
	            this.parentNode.style.cursor = "pointer";
	        }
	        
	        $tds[i].onmouseout = function() {
	            this.parentNode.style.backgroundColor = "white";
	        }
	        $tds[i].onclick = function() {
	            var id = this.parentNode.children[0].innerText;

	            // '/selectone' 서블릿으로 리디렉션하면서 쿼리 스트링에 게시물 번호를 포함시킴
	            location.href = '${pageContext.servletContext.contextPath}/product/selectone?id=' + id;
	        }
	    }
	}
		
	</script>
</body>


</html>