package com.multi.servlet.e_practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/check.do")
public class Check extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String ch1 = request.getParameter("today");
		
		if (ch1.equals("맑음")) {
			
			out.write("나가자");
		} else if (ch1.equals("흐림")) {
			out.println("코딩");
			
		} else if (ch1.equals("비옴")) {
			out.println("쇼핑");
			
		} else {
			out.println("나가자");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		
		request.setCharacterEncoding("utf-8");
		
		String pass = request.getParameter("pass");
		
		String imagePath = request.getContextPath() + "/resources/img/";
		String noImagePath = imagePath + "no.JPG";
		String yesImagePath = imagePath + "ok.JPG";
		String result = "들어올 수 없습니다.<img src= '" + noImagePath + "'>";
		if (pass.equals("나는왕이다.")) {
			result = "들어오세요.<img src='" + yesImagePath + "'>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>" + request.getContextPath() + "</h2>");
		out.println("<h3>" + imagePath + "</h3>");
		out.print(result);
		out.close();
		
		
	}
}