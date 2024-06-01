<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.multi.dto.BbsDTO"%>
    <%
    //가방을 만들어서
    BbsDTO bbs = new BbsDTO();
    
    //데이터를 넣고,
    bbs.setId("1");
    bbs.setTitle("hi");
    bbs.setContent("happy");
    bbs.setWriter("park");
    
    //데이터를 꺼낸다.
    out.print(bbs.getId() + " ");
    out.print(bbs.getTitle() + " ");
    out.print(bbs.getContent() + " ");
    out.print(bbs.getWriter() + " ");
    
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