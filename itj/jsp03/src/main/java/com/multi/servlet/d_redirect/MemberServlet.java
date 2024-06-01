package com.multi.servlet.d_redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/insert2.do")
public class MemberServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        System.out.println("redirect 테스트 !!!");
        
       /* response.sendRedirect("redirect?id="+id);*/
        
        response.sendRedirect("result.jsp");
        
        
    }
}

/*********************
 *  RequestDispatcher : 현재 request에 담긴 정보를 저장하고 있다가 그 다음 페이지에서도 해당정보를 볼수 있게 저장하는 기능
 *  forward : 기존 파라미터정보를 유지하며 페이지를 전환 (url 변하지 않고  , 클라이언트 모르게 위임)
 *  포워딩 (그때 request와 response 담아서 보내줘야됨)
 *                  request 담는 이유 : 전달하고자 하는 값 담아놨기 때문에
 *                  response 담는 이유 : 응답페이지 만들때 사용하는 객체기 때문에 같이 보내야만 작업을 한다.
 *
 *            * A페이지 -> Servlet -> B페이지 일 때, A가 가지고 있는 파라미터 정보를 가지고 B로 넘겨줌
 *            * 이 때, RequestDispatcher 없이 forward만 하게 되면 A.jsp -> Servlet -> B.jsp까지는 정보가 전달 되지만
 *              그 다음 단계에서는 A파라미터를 별도로 저장하지 않는 이상 소실됨
 *              서블릿 컨테이너가 처리하기 때문에 request 영역에 존재(브라우저는 모르는 일)
 *            *
 *  sendRedirect : 모든 파라미터 정보를 제외하고 단순 페이지 호출만함.
 *            다른 웹 컨테이너에 있는 주소로 이동이 가능하며 새로운 페이지에서는 request와 response객체가 새롭게 생성됨
 */