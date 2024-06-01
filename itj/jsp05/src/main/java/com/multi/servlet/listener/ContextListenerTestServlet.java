package com.multi.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		System.out.println("context listener test servlet");
		
		ServletContext context = request.getServletContext(); // 서블릿 컨테이너를 조작할 수 있는 객체
		
		context.setAttribute("test","value");
		/* context에 attr을 추가하면 attributeAdded() 메소드가 동작한다. */
		
		context.setAttribute("test","value2");
		/* 동일한 key로 context에 attr을 추가하면(수정하면) attributeReplaced() 메소드가 동작한다. */
		
		context.removeAttribute("test");
		/* context에서 attr을 제거하면 attributeRemoved() 메소드가 동작한다. */
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
	}
}