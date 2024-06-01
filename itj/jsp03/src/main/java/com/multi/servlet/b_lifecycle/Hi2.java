package com.multi.servlet.b_lifecycle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*@WebServlet(
		urlPatterns = {"/hi2anno"},
		initParams = {
				@WebInitParam(name = "tel", value = "111"),
				@WebInitParam(name = "email", value = "admin@example.com")
		})*/
@WebServlet(value ="/hi2anno" , loadOnStartup = 10 )
public class Hi2 extends HttpServlet {
	
	@Override
	public void destroy() {
		System.out.println("서블릿 생명을 다함.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿이 탄생함.");
		String tel = config.getInitParameter("tel");
		String email = config.getInitParameter("email");
		//관리한테 문자를 보내줘 처리
		System.out.println("관리자 전화번호인 " + tel  + "로 문자보냄.");
		System.out.println("관리자 이메일인 " + email  + "로 메일보냄.");
	}
	
/*	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() 메소드 호출  ");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		System.out.println("doGet()메서드가 자동호출됨");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		System.out.println("doPost()메서드가 자동호출됨");
	}
}