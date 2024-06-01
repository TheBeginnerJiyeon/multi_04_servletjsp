package com.multi.servlet.e_practice;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
		urlPatterns = {"/bye2"},
		initParams = {
				@WebInitParam(name = "name", value = "hong"),
				@WebInitParam(name = "message", value = "goodbye")
		})
public class Hello extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		System.out.println("안녕히가세요!!!");
		
		ServletConfig config = getServletConfig();
		
		String name = config.getInitParameter("name");
		String message = config.getInitParameter("message");
		
		System.out.println("이름은 " + name + " , MESSAGE는 " + message);
	}
	

}