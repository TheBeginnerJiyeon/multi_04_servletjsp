<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>* JSTL 선언 방법</h3>
	<p>
		JSTL을 사용 하고자 하는 JSP 페이지의 상단 <br>
		page 지시자 아래에 taglib 지시자를 사용하여 선언해야됨 <br><br>
		
		&lt;%@ taglib prefix="사용하고자 하는 접두사" uri="tld 파일상의 uri" %&gt;
		
		<br>
		prefix : 접두사. 다른 태그와 구별할 수 있는 name space를 제공함. <br>
		uri : 실제 웹 상의 주소가 아닌, 태그 라이브러리를 나타내는 식별자. <br>
			  tld파일 상에 uri 값을 가리키며, <br>
			    이 지시자를 통해 작성한 태그 이름과 매칭되는 자바코드를 찾음 <br>
		
		* tld (Tag Library Descriptor) 파일 : 커스텀 태그 정보를 갖고 있는 라이브러리 파일
		* uri (Uniform Resource Identifier) : 자원을 나타내는 유일한 주소
		
	</p>
	<h1 align="center">JSTL Core Library Tag Test</h1>
	
	<h2>c:set 태그 : 변수선언</h2>
	<h3>1. 변수</h3>
	<pre>
	* 변수 선언 (c:set)
	- 변수를 선언하고 초기값을 대입하는 기능을 가진 태그
	- 변수 선언 시 scope를 지정할 수 있음. 기본 scope는 pageScope
	- 사용 방법
	  1) 변수 타입은 별도로 선언하지 않는다.
	  2) 초기값은 반드시 지정해야된다.
	  3) c:set 태그로 선언한 변수는 EL안에서 사용 가능
	         하지만 스크립틀릿 요소에서는 사용할 수 없음.
	</pre>
	<!-- scope 생략시 기본 pageScope이다. -->
	<h2>c:set 태그 : 변수 선언</h2>
	<c:set var="num1" value="100" scope="session" />
	<c:set var="num2" value="200" scope="session" />
	
	<!-- c:set으로 사용한 변수는 스크립팅 요소에서 쓰는 것이 불가능하다. -->
	<%-- <% int sum = num1 + num2; %> --%>
	<!-- el로 접근해야 함 -->
	<c:set var="sum" value="${ num1 + num2 }"/>
	num1 + num2 = ${ sum } <br>
	
	<!-- 스크립팅 요소에서 선언된 변수는 el이나 스크립팅 요소로 사용 가능하다 -->
	<% int num3 = 10, num4 = 20; %>
	<!-- 에러는 나지 않지만 값은 못가져온다 -->
	num3 + num4 = ${ num3 + num4 } <br>
	<!-- 따라서 el을 활용하기 위해서는 스크립팅 요소를 value속성으로 지정한 c:set 태그가 필요하다 -->
	<c:set var="sum2" value="<%= num3 + num4 %>"/>
	num3 + num4 = ${ sum2 } <br>
	
	<hr>
	
	<h2>c:set 태그 : 배열 또는 컬렉션으로 사용할 문자열 선언</h2>
	<c:set var="colors">
		red, yellow, green, orange, blue, magenta
	</c:set>
	colors 배열 값 확인 : ${ colors } <br>
	
	<!-- 자바스크립트에서도 el태그를 사용할 수 있다. -->
	<script>
		window.onload = function(){
			var colors = '${ colors }'.split(', ');
			console.log(colors);
		}
	</script>
	<hr/>
	
	
	<h2>c:remove 태그 : 변수 삭제</h2>
	<pre>
	* 변수 삭제 (c:remove)
	지정한 변수를 모든 scope에서 검색해 삭제함.
	또는 지정한 scope만 삭제도 가능
	</pre>
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	
	<!-- 삭제시 scope를 지정하지 않으면 모든 scope의 동일 이름의 변수를 제거한다 -->
	<c:remove var="num1" scope="session" /><!-- 특정 scope에서 삭제 -->
	<c:remove var="num2"/><!--  모든 scope에서 삭제 -->
	num1 변수 값 : ${ num1 } <br>
	num2 변수 값 : ${ num2 } <br>
	<hr/>
	
	
	<h2>이스케이프시퀀스 : <, >, & 등의 특수문자를 &lt;과 &gt; 과 &amp;로 바꿔서 인식한다. </h2>
	<h2>c:out 태그 : 값 출력용</h2>
	<c:out value="core 라이브러리의 <out> 태그는 값을 화면에 출력하는 태그이다." /><br>
	<!-- escapeXml을 false로 지정하면 <, > 등을 태그로 인식하고, true로 지정하면 문자로 인식한다 -->
	<c:out value="<h2>데이터출력</h2>" escapeXml="false" /> <br>
	<c:out value="<h2>데이터출력</h2>" escapeXml="true" /> <br>
	<!-- 기본값은 true이다 -->
	<c:out value="<h2>데이터출력</h2>" /> <br>
	
	<h2>c:out 태그의 default 속성</h2>
	<!-- el로 가져오는 값이 없는 경우 대체할 값에 대해 default값으로 설정 가능 -->
	<c:out value="${ param.name }" default="유재석"/>
	<hr/>
	
	
	
	<h2>c:if 태그 : 조건문</h2>
	<pre>
	- JAVA의 if문과 비슷한 역할을 하는 태그
	- 위의 태그 사용시 조건식은 test라는 속성의 값으로 지정해야됨
	  이때 조건식은 반드시 EL형식으로 기술해야됨
	</pre>
	<c:set var="value1" value="9" scope="page" />
	<c:set var="value2" value="30" scope="page" />
	value1의 값은 <c:out value="${ value1 }"/>이고, value2의 값은 <c:out value="${ value2 }"/>입니다.
	
	<!-- test속성에 조건식을 기술하며, 조건식은 반드시 el 형식으로 기술해야 한다. -->
	<c:if test="${ value1 + 0 >= value2 + 0 }">
		<h3>value1 이 큽니다. : ${ value1 }</h3>
	</c:if>
	<c:if test="${ value1  + 0 < value2  + 0}">
		<h3>value2 가 큽니다 : ${ value2 }</h3>
	</c:if>
	
	
	
	<hr>
	
	
	
	
	<h2>c:choose : switch 문, c:when : case 문, c:otherwise : default 문</h2>
	<pre>
	- Java의 if-else if문 또는 switch문과 비슷한 역할을 하는 태그<br>
	- 각 조건들은 c:choose문의 하위요소로 c:when 를 통해서 작성 (default 값으로는  c:otherwise)
	</pre>
	<c:set var="no" value="${ param.no }" /><%-- ?no=1 파라미터 넣어서 확인--%>
	
	param.no의 값은 <c:out value="${ param.no }"/> 입니다.
	<c:choose>
		<c:when test="${ no == 1 }"><h3>안녕하세요.</h3></c:when>
		<c:when test="${ no eq 2 }"><h3>반갑습니다.</h3></c:when>
		<c:otherwise><h3>환영합니다.</h3></c:otherwise>
	</c:choose>
	
	
	<hr>
	
	
	<h2>c:forEach 태그 : for 문</h2>
	<h3>4. 반복문 - forEach (c:forEach var="" begin="" end="" step="" items="" varStatus="") </h3>
	<pre>
	&lt;c:forEach&gt; 반복시 실행할 내용 &lt;/c:forEach&gt;
	- Java의 for문에 해당하는 기능을 제공.
	- forEach문은 여러가지 속성이 사용됨.
	
	var : 현재 반복 횟수에 해당하는 변수의 이름
	begin : 반복이 시작할 요소 번호(0 ... n)
	end : 반복이 끝나는 요소 번호
	step : 반복 시 증가할 수
	items : 반복할 객체 명(Collection 객체)
	varStatus : 현재 반복에 해당하는 객체의 요소 정보
	</pre>
	<c:forEach begin="1" end="10">
		반복실행<br>
	</c:forEach>
	<br>
	
	<c:forEach var="size" begin="1" end="7" step="1">
		<font size="${ size }">글자크기 ${ size }</font> <br>
	</c:forEach>
	
	<br>
	
	<!-- varStatus를 통해 상태를 관리할 수 있다.(인덱스 등) -->
	<!-- current : 현재 반복 횟수, index : 제로기반 인덱스, count : 1 기반 인덱스 -->
	<!-- first : 현재 라운드가 반복을 통한 첫 번째, last : 현재 라운드가 반복을 통한 마지막 번 째 -->
	<h2>c:forEach 태그 : 배열 또는 컬렉션 연속처리에 for~each 문처럼 사용함</h2>
	<c:forEach var="color" items="${ colors }" varStatus="st">
		<font color="${ color }">
		<%-- ${st.index} : --%>
		${ st.count } :  글자색 ${ color }</font> 
		<br>
	</c:forEach>
	<br>
	
	<hr/>
	

	<h2>c:forTokens 태그 : 문자열을 토큰으로 분리 처리할 때 사용</h2>
	<pre>
	- 문자열에 포함된 구분자를 통해 토큰을 분리해서 반복 처리
	- Java의 Stinrg.split() 또는 StringTokenizer와 비슷한 기능
	- items 속성에는 토큰을 포함하는 문자열을 지정하고,
	  delims 속성에는 토큰을 분리하는데 사용할 구획 문자를 기술. 
	</pre>
	<ul>
	<c:forTokens var="color" items="yellow blue pink red green" delims=" " >
		<li>${color}</li>
	</c:forTokens>
	</ul>
	<br>
	
	
	
	<h3>여러 개의 토큰 문자를 가지고 분리 처리할 수도 있음</h3>
	<!-- delims 안에 지정된 토큰문자는 순서 상관 없음 -->
	<c:forTokens var="color" items="yellow-blue*pink/red green" delims="/*- " >
		${color} <br/>
	</c:forTokens>
	<br>
	<hr/>
	
	
	<h2>c:url 태그 : 링크 설정 정보 별도 지정시 사용하는 태그</h2>
	<c:url var="fmtlink" value="testJstlCoreResult.jsp">
		<c:param name="num" value="77" />
	</c:url>
	<a href="${ fmtlink }">결과 화면 연결</a> <br>
	
</body>
</html>