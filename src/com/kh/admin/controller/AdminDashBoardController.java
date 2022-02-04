package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Petsitter;

/**
 * Servlet implementation class AdminDashBoardController
 */
@WebServlet("/adminDashBoard.bo")
public class AdminDashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginUser")!= null && ((Member)request.getSession().getAttribute("loginUser")).getMemId().equals("admin")) {
			
			request.getRequestDispatcher("views/admin/adminMenu.jsp").forward(request, response);
			
		}else {
			request.getSession().setAttribute("alertMsg", "관리자가 아니면 사용하실 수 없습니다.");
			response.sendRedirect("/pet/");
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
