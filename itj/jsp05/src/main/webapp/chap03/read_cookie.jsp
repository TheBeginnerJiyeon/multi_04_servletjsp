<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Read Cookie</title>
</head>
<body>
<%
    // 클라이언트로부터 전송된 모든 쿠키를 가져오기
    Cookie[] cookies = request.getCookies();
    int apple = 0;
    int melon=0;
    int ice=0;

    /* if (cookies != null) {
        for (Cookie cookie : cookies) {
            // 쿠키 이름과 값을 출력
            // out.println("Name: " + cookie.getName() + ", Value: " + cookie.getValue() + "<br>");
        }
    } else {
        out.println("No cookies found.");
    } */

    for(int i=0; i<cookies.length;i++){
        if(cookies[i].getName().equals("apple")){
            apple = Integer.parseInt(cookies[i].getValue());
        }else if(cookies[i].getName().equals("melon")){
            melon = Integer.parseInt(cookies[i].getValue());
        }else if(cookies[i].getName().equals("ice")){
            ice = Integer.parseInt(cookies[i].getValue());
        }

    }

    int price = apple + ice;

    out.println("사과와 아이스크림의 가격은 " + price );


%>
</body>
</html>