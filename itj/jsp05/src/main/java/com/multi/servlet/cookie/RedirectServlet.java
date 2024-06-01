package com.multi.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/cookieredirect")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName  cookieredirect : " + firstName);
		System.out.println("lastName cookieredirect : " + lastName);
		// firstName  cookieredirect : null
		//lastName cookieredirect : null
		
		Cookie[] cookies = request.getCookies();
		/*for(Cookie cookie : cookies) {
			System.out.println("cookie name : " + cookie.getName());
			System.out.println("cookie value : " + cookie.getValue());
		}*/
		
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("firstName")) {
				firstName = cookies[i].getValue();
			} else if(cookies[i].getName().equals("lastName")) {
				lastName = cookies[i].getValue();
			}
		}
		
		
		System.out.println("firstName  cookieredirect : " + firstName);
		System.out.println("lastName cookieredirect : " + lastName);
		
		StringBuilder responseText = new StringBuilder();
		responseText.append("<!doctype html>\n")
				.append("<html>\n")
				.append("<head>\n")
				.append("</head>\n")
				.append("<body>\n")
				.append("<h3>your first name is ")
				.append(firstName)
				.append(" and last name is ")
				.append(lastName)
				.append("</h3>")
				.append("</body>\n")
				.append("</html>\n");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(responseText.toString());
		
		out.flush();
		out.close();
		
		
		/*
		 * 쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다. 따라서 개인적으로만 사용하는 경우는 크게 상관 없지만 다른 사용자와 함께 사용되는
		 * 컴퓨터인 경우에는 쿠키에 민감한 개인정보를 담기에는 보안에 취약하게 된다. 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는
		 * 세션이라는 것을 이용하게 된다. 세션은 쿠키와 유사한 형태로 key=value 쌍으로 저장되지만 서버(톰캣)에서 관리되기 때문에 보안에 더
		 * 우수하다는 장점을 가지게 된다.
		 */
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		
		
		
		
	}
}