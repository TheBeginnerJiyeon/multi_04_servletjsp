<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String won = request.getParameter("won");
	int money =  Integer.parseInt(won)/1000;

%><%= money %>