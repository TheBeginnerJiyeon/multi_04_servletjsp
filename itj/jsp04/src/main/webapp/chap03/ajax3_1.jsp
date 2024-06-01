<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			alert("내가 호출되었어.!")

			$.ajax({
				url : "insert", // DataUploadServlet URL : memberinsertservlet 주소
				success : function(response) {
					if (response > 0) {
						// 서버로부터 응답 받음 (예: { "count": 1000 })
						$('#d1').html("입력된 데이터 수는 : " + response + " 개 입니다."); // d1 요소에 메시지 표시
						console.log("db성공!");
					}
				},
				error : function() {
					console.log("에러발생!");
				}
			});
		
	}) //b1
	
	
	$('#b2').click(function() {
		alert("내가 호출되었어.!")

		$.ajax({
			url : "selectList", // DataUploadServlet URL : memberlistservlet 주소
			success : function(list) {
				console.log(list)
				var result = ""
					//$.each(배열명,function(index){});
 					//배열명[index]  ->  각 요소에 접근 
			    /*   구현   */

			    $.each(list, function(i){
                    result += list[i].id + " / "
                            + list[i].name + " / "
                            + list[i].email + " / "
                            + list[i].address + " <br> "
                })

				$("#d2").html(result);
			},
			error : function(e) {
				$("#d2").val("ajax통신실패");
			}
		});
	}) //b2
	
}) //$
</script>
<style>
input {
	background: yellow;
	color: red;
}
</style>
</head>
<body>
	<button id="b1" class="mt-2 p-2 bg-primary text-white rounded">json db 저장</button>
	<hr>
	<div id="d1" style="width: 800px; height: 100px; background: lime;">
	</div>
	
	<button id="b2" class="mt-2 p-2 bg-primary text-white rounded">json db 조회</button>
	<hr>
	<div id="d2" style="width: 800px; background: skyblue;">
	</div>
</body>
</html>





