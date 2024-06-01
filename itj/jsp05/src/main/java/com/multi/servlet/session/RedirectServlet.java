package com.multi.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		
		HttpSession session = request.getSession();
		System.out.println("redirect 페이지 session id : " + session.getId());
		
		
		Enumeration<String> sessionNames = session.getAttributeNames();
		while(sessionNames.hasMoreElements()) {
			System.out.println(sessionNames.nextElement());
		}
		
		
		firstName = (String) session.getAttribute("firstName");
		lastName = (String) session.getAttribute("lastName");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Your first name is ");
		out.println(firstName);
		out.println(" and last name is ");
		out.println(lastName);
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
		
	}

}
