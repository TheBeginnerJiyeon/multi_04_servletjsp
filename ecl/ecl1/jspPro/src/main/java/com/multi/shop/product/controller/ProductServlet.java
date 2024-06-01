package com.multi.shop.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;


@WebServlet("/product/selectone")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 private ProductService productService = new ProductServiceImpl();
       

    public ProductServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		
		
		int id = Integer.parseInt(request.getParameter("no"));
		
		try {

				ArrayList<ProductDTO> productList = productService.selectProduct(id);
			
				
				request.setAttribute("productlist", productList);
				
				
				System.out.println("productList : " + "\n" + productList);			
				path = "/WEB-INF/views/product/pdetail.jsp";
			
			
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
