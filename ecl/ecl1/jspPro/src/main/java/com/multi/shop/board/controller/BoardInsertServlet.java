package com.multi.shop.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.board.service.BoardService;
import com.multi.shop.board.service.BoardServiceImpl;
import com.multi.shop.member.model.dto.MemberDTO;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	String path = "";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		request.getRequestDispatcher("/WEB-INF/views/board/insertform.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int categoryCode = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		MemberDTO loginMemberDTO = (MemberDTO) request.getSession().getAttribute("loginMember");
		String writer = loginMemberDTO.getId();
		
		
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setCategoryCode(categoryCode);
		boardDTO.setTitle(title);
		boardDTO.setContent(content);
		boardDTO.setWriter(writer);
		
		try {
			// result 따라 더 나누기. 성공하면 success로 가도롥..
			// path = "/WEB-INF/views/common/success.jsp"
			// request.setAttribute("successCode", "insertBoard");
			
			int result= boardService.insertBoard(boardDTO);
			
			path = "/board/list";
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시물 작성 실패!");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
