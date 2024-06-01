package com.multi.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class SessionHandlerServlet
 */
@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		
		HttpSession session = request.getSession();
		
		System.out.println("session default 유지 시간 : " + session.getMaxInactiveInterval());	
		
		session.setMaxInactiveInterval(60 * 10);
		
		System.out.println("변경 후 session 유지 시간 : " + session.getMaxInactiveInterval());
		
		
		System.out.println("session id : " + session.getId());
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		
		response.sendRedirect("redirect");
	}

}
