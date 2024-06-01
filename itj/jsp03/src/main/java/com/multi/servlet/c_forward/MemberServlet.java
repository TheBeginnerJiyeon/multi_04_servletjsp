package com.multi.servlet.c_forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




@WebServlet("/insert.do")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Do GET request handling here
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        System.out.println("forward 테스트 !!!");
        
        request.setAttribute("id", id);
        request.setAttribute("pw", pw);
        
        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
        rd.forward(request, response); // 깊은 복사 : 원본과 다르게 완전히 다른 복사
        
        /*request.getRequestDispatcher("result.jsp").forward(request, response);*/
        
        
    }
}