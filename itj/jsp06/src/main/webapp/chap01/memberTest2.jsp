<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--
    include 지시자 태그를 이용하여 file 속성에 jsp 경로를 지정해주면 해당 jsp에 작성한 내용을 그대로 포함시켜 현재 jsp 파일을 동작시킨다.
    동일한 변수 이름을 include 이후에 또 사용하게 되면 한 페이지 내에 동일한 변수가 생성되는 것이므로 컴파일 에러가 발생하게 된다.

    header, footer , menubar include활용
-->
<div align="right"><%@ include file="today.jsp" %></div>
<%
    /* 삽입한 파일에 있는 동일한 변수 이름을 사용했기 때문에 런타임 에러가 발생한다. */
    //String output = "";
%>


    <!--  지시자 include -jsp 파일을 class(java) 파일로 변환할떄 처리
               - 현재 파일에 삽입
               - 페이지내의 변수를 선언한후 변수에 값저장 하여 전달
               - 다수 jsp 페이지에서 공통으로 사용되는 코드 처리

            엑션태그 include - 요청한 시간에 처리(런타임)
              - 별도의 파일 요청 처리
              - request 기본 객체나 jsp:param 을 이용한 파라미터 전달
              - 화면의 레이아웃 일부분을 모듈화

    -->
    <jsp:include page="common.jsp"/>

    <jsp:forward page="testForward.jsp">
        <jsp:param name="name" value="Jin"/>
    </jsp:forward>

</body>
</html>