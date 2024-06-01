package com.multi.servlet.a_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hi")
public class Hi extends HttpServlet {
	//HttpServlet에 있는 service()
	//모든 요청은 service()가 받아서
	//get/post인지 구분해서
	//get요청이 들어오면 doGet()
	//post요청이 들어오면 doPost()
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		
		System.out.println("get request!! 겟요청이 들어옴");
		
		String q = request.getParameter("q");
		System.out.println("q = " + q);
		
		PrintWriter out = response.getWriter();
		out.write("<h1> q = " + q + "</h1>");
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		System.out.println("post request!! 포스트 요청이 들어옴");
		
		System.out.println("default response type : " + response.getContentType());
		System.out.println("default response encoding : " + response.getCharacterEncoding());
		
		
		
		/* 파라미터값을 꺼내기 전에 디코딩할 인코딩 방식을 설정해주면 해당 방식으로 페이로드(본문)의 값을 해석한다.
		1. 전송값에 한글이 있을 경우 처리할 수 있도록 인코딩 처리를 함
  		반드시 값 꺼내오기 전에 해야 한다.
 		*/
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		
		
		String g11 = "한글";
		System.out.println("한글: " + g11);
		
		
		
		
		//2. setContentType 응답 객체의 문서타입과 ,한글로 응답 하고 싶은경우 한글처리 필요
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("<h1> id = " + id + "</h1>");
		out.write("<h1> pw = " + pw + "</h1>");
		out.print("<h1>your id : " + id + ", your pw : " + pw + "</h1>");
		
		out.print("한글 아이디" + id + pw);
		
		out.close();
	}
}

/******************************************************************************************************
 *  request.setCharacterEncoding("UTF-8");
 POST방식으로 넘겨받은 데이터가 영어나 숫자가 아닌 경우에 대비해 인코딩 처리를 해야함.
 request 내의 파라미터 값은 기본적으로 ISO-8859-1로 인코딩 되었다고 간주 되기 때문(default 설정)
 request에서 파라미터 값을 뽑기 전에 request에 담겨 있는 값들에 대해 인코딩 설정을 하자
 > get방식에서 인코딩 설정이 필요 없는 이유는 url에 값들이 포함되어서 전달 되고 GET 방식의 데이터는 HTML charset에 기술된 인코딩 방식으로 브라우저가 한글을 이해한 뒤 %문자로 URLEncoder를 이용하여 변환 후 url 요청으로 전송한다.
 *****************************************************************************************************/

/*********************************************************************************************
 * Get 방식으로 요청했으면 이 doGet 메소드가 호출 됨.
 * 첫번째 파라미터인 HttpServletRequest 에는 웹 브라우져에서 사용자가 요청한 내용을 받아주는 용도
 * 두번째 파라미터인 HttpServletResponse에는 요청 처리 후 나중에 사용자에게 응답을 해줄때 사용할 용도
 *
 * request  : 요청시 전달된 내용 (사용자가 입력한 값, 요청전송방식, 요청한 사용자의 ip 등등)이 담겨있음
 * response : 요청 처리 후 응답을 할 때 사용하는 객체  (즉, 응답페이지에 대한 작업 시 사용)
 *
 
 *
 * 우선 처리하기 위해 전달된 값들을 뽑아야 된다. (request에 담겨있음)
 * > request 안의 파라미터 영역 안에 데이터가 (키-밸류) 형태로 담겨있음 (name속성값-value값)
 *
 * 따라서 request로 부터 데이터 뽑는 메소드
 * > request.getParameter("name속성값") : 그에 해당하는 value값 리턴 (단, Strnig으로 무조건 리턴됨)
 * > request.getParameterValues("name속성값") : 그에 해당하는 value값들이 배열(String 배열)에 담겨 리턴
 * 다중 체크같은 경우 복수니 배열로 받는다.
 *
 **********************************************************************************************/