package com.multi.shop.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.board.model.dto.BoardDTO;
import com.multi.shop.board.service.BoardService;
import com.multi.shop.board.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/selectone")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 private BoardService boardService = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		
		int bno = Integer.parseInt(request.getParameter("no"));
		
		try {

				BoardDTO boardDTO = boardService.selectBoard(bno);
			
				
				
				request.setAttribute("b", boardDTO);		
				
				
				
				System.out.println(boardDTO);			
				path = "/WEB-INF/views/board/board_detail.jsp";
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시물 목록 조회 실패!");
		}
		request.getRequestDispatcher(path).forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
