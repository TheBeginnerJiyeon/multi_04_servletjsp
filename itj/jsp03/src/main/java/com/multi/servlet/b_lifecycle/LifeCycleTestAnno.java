package com.multi.servlet.b_lifecycle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/annolifecycle")
public class LifeCycleTestAnno extends HttpServlet {
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	/* 기본 생성자 */
	public LifeCycleTestAnno() {
		System.out.println("anno LifeCycleTestServlet 인스턴스생성");
	}
	
	
	/* 서블릿의 요청이 최초인 경우 한 번 동작하는 메소드 */
	@Override
	public void init() throws ServletException {
		System.out.println("anno 매핑 init() 메소드 호출 : " + initCount++);
	}
	
	
	/* 컨테이너가 종료될 때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다. servers 에있는 톰캣을 정지하면된다 */
	@Override
	public void destroy() {
		System.out.println("anno 매핑 destroy() 메소드 호출 : " + destroyCount++);
	}
	
	
	/* 서블릿 컨테이너에 의해 호출되며 최초 요청시에는 init() 이후에 동작하고,
	 * 두 번째 요청부터는 바로 service()를 호출하게 된다.
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("anno 매핑 service() 메소드 호출 : " + serviceCount++);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do GET request handling here
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Do POST request handling here
		
		
		
	}
}