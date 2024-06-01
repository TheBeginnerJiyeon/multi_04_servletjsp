package com.multi.shop.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.shop.member.model.dto.MemberDTO;
import com.multi.shop.member.service.MemberService;
import com.multi.shop.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService memberService = new MemberServiceImpl(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String page="";
		
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId(userId);
		memberDTO.setPw(userPwd);
		
	
		try {
			MemberDTO loginMemberDTO = memberService.loginCheck(memberDTO);
			
			if (loginMemberDTO !=null) {
				
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", loginMemberDTO);
				response.sendRedirect(request.getContextPath());
				System.out.println("로그인 성공~~!");
				
			}else {
				
				page = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("msg", "로그인 실패! 실패 페이지...");
				System.out.println("로그인 실패.. 실패 페이지로 가야함");
				request.getRequestDispatcher(page).forward(request, response);
			}
			
			// 여기 고치기
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			page = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "로그인 실패! 에러 발생...");
			System.out.println("로그인 실패.. 에러발생 페이지로 가야 함");
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		
		
		
		
		
	}

}
