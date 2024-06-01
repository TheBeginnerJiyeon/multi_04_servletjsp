package com.multi.shop.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.member.model.dto.MemberDTO;
import com.multi.shop.member.service.MemberService;
import com.multi.shop.member.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
/* @WebServlet("/member/login") */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	MemberService memberService = new MemberServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String id = request.getParameter("userId");
		String pw = request.getParameter("userPwd");
		String path = "";
		
		try {
			MemberDTO memberDTO = memberService.selectMember(id);
			
			
			if (memberDTO != null) {
				
				if (memberDTO.getPw().equals(pw)) {
					request.getSession().setAttribute("loginMember", memberDTO);
                    path = "/WEB-INF/views/main/main.jsp";
                    request.getSession().setAttribute("loginMsg", "로그인 성공!");
                    
				}else{
					
			
					path = "/WEB-INF/views/common/errorPage.jsp";
					request.setAttribute("msg", "게시물 목록 조회 실패!");
				}
				
				
			}else if(memberDTO == null) {
				
				request.setAttribute("loginMsg", "아이디가 없습니다");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "멤버 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
		
		
	}

}
