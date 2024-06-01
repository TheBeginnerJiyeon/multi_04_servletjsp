<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String tel = request.getParameter("tel");
String result = "";
String pre = tel.substring(0, 3);//011
int post = 0;
switch (pre) {
	case "010":
		result = "111";
		break;
	case "011":
		result = "222";
		break;
	default:
		result = "333";
	}
Random r = new Random();
post = r.nextInt(900) + 100;
		//0-899 ==> 100 ~ 999
result = result + post;
%><%= result %>