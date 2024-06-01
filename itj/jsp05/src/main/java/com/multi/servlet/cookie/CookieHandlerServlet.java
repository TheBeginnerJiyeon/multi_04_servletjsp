package com.multi.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		
		/* 1. 쿠키를 생성한다.
		 * 2. 해당 쿠키의 만료 시간을 설정한다.
		 * 3. 응답 헤더에 쿠키를 담는다.
		 * 4. 응답한다.
		 *
		 * 하지만 쿠키는 일부 제약항목이 있다.
		 * 쿠키의 이름(키값)은 ascii 문자만을 사용해야 하며 한 번 설정한 쿠키의 이름은 변경할 수 없다.
		 * 또한 공백문자와 일부 특수문자([ ] ( ) = , " \ ? @ : ;)를 사용할 수 없다.
		 * */
		
		Cookie firstNameCookie = new Cookie("firstName", firstName);
		Cookie lastNameCookie = new Cookie("lastName", lastName);
		
		firstNameCookie.setMaxAge(60 * 60 * 24 ); //일, 초단위 설정
		lastNameCookie.setMaxAge(60 * 60 * 24); // 일, 초단위 설정
		
		response.addCookie(firstNameCookie);
		response.addCookie(lastNameCookie);
		
		response.sendRedirect("cookieredirect");
		
		
		
		
		
		
		
		
	}
}