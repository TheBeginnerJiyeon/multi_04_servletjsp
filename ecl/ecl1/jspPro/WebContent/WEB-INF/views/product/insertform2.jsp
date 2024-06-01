<jsp:directive.page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th {width: 200px;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer outer-product-insert " style="display: flex; justify-content: center;">
	
			<form action="${ pageContext.servletContext.contextPath }/product/insert" method="post">
			
			<br>
				<table id="listArea" class="table table-hover table-striped table-bordered">
				
			    
	  			  <tbody>
					<tr>
						<th>제품 이름</th>
						<td colspan="3"><input type="text" name="name" style="width:500px;"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea name="content" cols="60" rows="15" style="resize:none;width:500px;"></textarea>
						</td>
					</tr>
					
					<tr>
						<th>가격</th>
						<td colspan="3"><input type="text" name="price" style="width:500px;"></td>
					</tr>
					
					
					<tr>
						<th>회사 아이디</th>

						<td style="text-align: left;">
						    <select name="companyId">
						        <option value="c100">GOOD</option>
						        <option value="c200">JOA</option>
						        <option value="c300">MARIA</option>
						        <option value="c400">MY</option>
						    </select>
						</td>
						
					</tr>
					
					
					<tr>
						<th>이미지</th>
						<td colspan="3"><input type="text" name="img" style="width:500px;"></td>
					</tr>
					
					
		
					
				</table>
				<br>
				
				
				<div align="center">
					<button class = "btns" type="reset">취소하기</button>
					<button class = "btns" type="submit">등록하기</button>
				</div>
				
			</form>
			<br><br>
	</div>
</body>
</html>