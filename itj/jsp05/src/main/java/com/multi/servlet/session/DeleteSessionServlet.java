package com.multi.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/delete")
public class DeleteSessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		/* 세션의 데이터를 지우는 방법은 여러 가지가 있다.
		 * 1. 만료시간 설정 후 시간이 지나면 세션이 만료된다. (xml 설정도 가능)
		 * 2. removeAttribute()로 session의 Attribute를 지운다.
		 * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
		 * */
		
		/*session.removeAttribute("firstName");
		sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}*/
		
		session.invalidate();
		sessionNames = session.getAttributeNames();
		// java.lang.IllegalStateException: getAttributeNames: 세션이 이미 무효화되었습니다
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
	}
}