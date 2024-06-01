<jsp:directive.page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.servletContext.contextPath }/resources/css/project.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

<script type="text/javascript">
	$(
			function() {

				$
						.ajax({
							url : "${pageContext.servletContext.contextPath}/product/companylist",

							success : function(data) {
								var companySelect = $('select[name="company"]');
								console.log(data)
								// 받아온 데이터로 <select> 내용채우기
								data
										.forEach(function(company) {

											if ((company.id) == "${productList[0].company.id}") {

												companySelect
														.append($(
																'<option selected></option>')
																.attr(
																		'value',
																		company.id)
																.text(
																		company.name));

											} else {

												companySelect.append($(
														'<option></option>')
														.attr('value',
																company.id)
														.text(company.name));
											}

										});
							},
							error : function() {
								alert('회사 목록을 불러오는 데 실패했습니다.');
							}
						})

			})
</script>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />

	<div class="outer outer-board-insert"
		style="display: flex; justify-content: center;">


		<form
			action="${ pageContext.servletContext.contextPath }/product/update"
			method="post" encType="multipart/form-data">
			<input type="hidden" name="productId" value=${productList[0].id}>

			<div class="thumbnail-insert-area">
				<table align="center">

					<tr>
						<td>대표 이미지</td>
						<td colspan="3">
							<div class="title-img-area" id="titleImgArea">
								<img id="titleImg"
									src="${pageContext.servletContext.contextPath}${productList[0].attachments[0].thumbnailPath}"
									class="img-thumbnail" alt="Detail Image 1" width="350"
									height="200"> <input type="file" id="thumbnailImg1"
									name="thumbnailImg1" onchange="loadImg(this,1)">
							</div>
						</td>
					</tr>
					<tr>
						<td>내용 사진</td>
						<td>
							<div class="content-img-area1" id="contentImgArea1">
								<img id="contentImg1"
									src="${pageContext.servletContext.contextPath}${productList[0].attachments[1].thumbnailPath}"
									class="img-thumbnail" alt="Detail Image 1" width="120"
									height="100"> <input type="file" id="thumbnailImg2"
									name="thumbnailImg2" onchange="loadImg(this,2)">
							</div>
						</td>
						<td>
							<div class="content-img-area2" id="contentImgArea2">
								<img id="contentImg2" width="120" height="100"
									src="${pageContext.servletContext.contextPath}${productList[0].attachments[2].thumbnailPath}"
									class="img-thumbnail" alt="Detail Image 2"> <input
									type="file" id="thumbnailImg3" name="thumbnailImg3"
									onchange="loadImg(this,3)">

							</div>
						</td>
						<td>
							<div class="content-img-area3" id="contentImgArea3">
								<img id="contentImg3" width="120" height="100"
									src="${pageContext.servletContext.contextPath}${productList[0].attachments[3].thumbnailPath}"
									class="img-thumbnail" alt="Detail Image 3"> <input
									type="file" id="thumbnailImg4" name="thumbnailImg4"
									onchange="loadImg(this,4)">

							</div>
						</td>

					</tr>

				</table>
			</div>

			<table border="1" class="table table-hover">

				<tr class="table-info">
					<td width="300px"><span class="alert alert-danger">상품제목:
							<input name="name" value="${productList[0].name}">
					</span></td>
				</tr>
				<tr class="table-info">

					<td><span class="alert alert-success">상품설명: <input
							name="content" style="width: 90%;"
							value="${productList[0].content}">
					</span></td>
				</tr>
				<tr class="table-info">
					<td><span class="alert alert-success">상품가격: <input
							type="number" name="price" value="${productList[0].price}">
					</span></td>

				</tr>
				<tr class="table-info">
					<td><span class="alert alert-success">상품회사: <select
							name="company">

						</select>
					</span></td>
				</tr>

			</table>

			<div align="center">
				<button class="btns" type="reset">취소하기</button>
				<button class="btns" type="submit">수정하기</button>
			</div>


		</form>

	</div>


	<script>
		const $titleImgArea = document.getElementById("titleImgArea");
		const $contentImgArea1 = document.getElementById("contentImgArea1");
		const $contentImgArea2 = document.getElementById("contentImgArea2");
		const $contentImgArea3 = document.getElementById("contentImgArea3");

		function loadImg(value, num) {
			if (value.files && value.files[0]) {
				const reader = new FileReader();
				reader.onload = function(e) {
					switch (num) {
					case 1:
						document.getElementById("titleImg").src = e.target.result;
						break;
					case 2:
						document.getElementById("contentImg1").src = e.target.result;
						break;
					case 3:
						document.getElementById("contentImg2").src = e.target.result;
						break;
					case 4:
						document.getElementById("contentImg3").src = e.target.result;
						break;
					}
				}
				reader.readAsDataURL(value.files[0]);
			}
		}
	</script>
</body>
</html>