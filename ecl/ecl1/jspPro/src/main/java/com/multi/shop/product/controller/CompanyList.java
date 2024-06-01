package com.multi.shop.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.multi.shop.product.model.dto.CompanyDTO;
import com.multi.shop.product.service.ProductService;
import com.multi.shop.product.service.ProductServiceImpl;



/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product/companylist")
public class CompanyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService = new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("application/json"); // MIME 타입 설정
		    response.setCharacterEncoding("UTF-8"); // 문자 인코딩 설정
		  //  gson-2.8.5.jar
		    try {
		        ArrayList<CompanyDTO> list = productService.selectCompanyList();
		        System.out.println("CompanyDTO  :" + list);
		        Gson gson = new Gson();
		        String json = gson.toJson(list); // 리스트를 JSON 문자열로 직렬화
		        response.getWriter().write(json); // JSON 데이터 응답으로 출력
		    } catch (Exception e) {
		        e.printStackTrace();
		        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 에러 설정
		        response.getWriter().write("{\"message\": \"제품 목록 조회 실패!\"}");
		    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
