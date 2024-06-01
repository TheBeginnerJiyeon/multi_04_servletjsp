<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() { // 시작하자마자 통신 , jsp class java 생성된거 확인 
		$.ajax({
			url: "ok.jsp",
			success: function(result) {
				$('#d1').html(result)
			}
		})//ajax
		$.ajax({
			url: "weather.jsp",
			success: function(result) {
				$('#d2').html(result)
			}
		})//ajax
		$.ajax({
			url: "tour.jsp",
			success: function(result) {
				$('#d3').html(result)
			}
		})//ajax
		//id=d2에는 날씨정보 받아와서 넣어보세요.
		//id=d3에는 맛집정보 받아와서 넣어보세요.
	})//$
</script>
</head>
<body>
<div id="d1" style="background:yellow">결과들어가는 곳1</div>
<div id="d2" style="background:pink">결과들어가는 곳2</div>
<div id="d3" style="background:lime">결과들어가는 곳3</div>
<a href="ok.jsp">오케이정보</a>
</body>
</html>