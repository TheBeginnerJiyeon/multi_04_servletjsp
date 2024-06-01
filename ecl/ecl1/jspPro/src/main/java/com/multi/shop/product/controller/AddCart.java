package com.multi.shop.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multi.shop.product.model.dto.ProductDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/cart/add")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService productService = new ProductServiceImpl();
	
	
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(true);
		 
		   ArrayList<ProductDTO> basket = (ArrayList<ProductDTO>) session.getAttribute("basket");
		    if (basket == null) {
		        basket = new ArrayList<>();
		        session.setAttribute("basket", basket);
		    }
		 
		    int productId = Integer.parseInt(request.getParameter("productId"));
		    
		    ProductDTO product;
		    
		    try {
				product = (productService.selectProduct2(productId));// 하나만저장하면됨
			
				  basket.add(product);
				    response.setContentType("text/plain; charset=UTF-8");
				    response.getWriter().write(String.valueOf(basket.size())); // 현재 장바구니 크기를 문자열로 반환
		    // 이 부분에서는 페이지를 리다이렉트하지 않고 요청 종료
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 상품 조회 메소드 가정
		    
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
