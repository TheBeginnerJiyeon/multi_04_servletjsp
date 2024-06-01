<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dollar = request.getParameter("dollar");
	int money =  Integer.parseInt(dollar)*1000;
	
%><%= money %>