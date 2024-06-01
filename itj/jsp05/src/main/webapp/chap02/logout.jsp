<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%
     //세션을 끊는다.
    // 속성하나만 삭제 session.removeAttribute("id");
     session.invalidate();
     //브라우저가 클라이언트에게 login.jsp를 호출하도록 명령
     response.sendRedirect("login.jsp");//URL이 이동할 페이지로 바뀌어 이동한다. 데이터가 유지되지 않아 공유할 수 없다. 뒤로가기가 가능하다.
     /* 세션의 데이터를 지우는 방법은 여러 가지가 있다.
     * 1. 만료시간 설정 후 시간이 지나면 세션이 만료된다. (xml 설정도 가능)
     * 2. removeAttribute()로 session의 Attribute를 지운다.
     * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
     * */

     %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>






</body>
</html>