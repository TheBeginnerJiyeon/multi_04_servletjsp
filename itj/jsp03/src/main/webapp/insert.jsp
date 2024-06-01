<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
        String id = (String) request.getParameter("id");
        String pwd = (String) request.getParameter("pwd");
        String name = (String) request.getParameter("name");

        String[] hobby = request.getParameterValues("hobby");

        String gender = (String) request.getParameter("gender");

        String religion = (String) request.getParameter("religion");


        String introduction = (String) request.getParameter("introduction");


        String result = "";
        for(String s : hobby){
            result = result + s + "";
        }




    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>        <!-- out.print("id") -->
서버에서 받은 hobby >> <%= result %> <br>
서버에서 받은 id >> <%= id %> <br>
서버에서 받은 pwd >> <%= pwd %> <br>
서버에서 받은 name >> <%= name %> <br>
서버에서 받은 gender >> <%= gender %> <br>
서버에서 받은 religion >> <%= religion %> <br>
서버에서 받은 introduction >> <%= introduction %> <br>
</body>
</html>