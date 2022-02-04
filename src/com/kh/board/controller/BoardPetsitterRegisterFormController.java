package com.kh.board.controller;

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
 * Servlet implementation class PetsitterRegisterFormController
 */
@WebServlet("/registerForm.bo")
public class BoardPetsitterRegisterFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPetsitterRegisterFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("loginUser")!= null ) {
			
			String memNum= ((Member)request.getSession().getAttribute("loginUser")).getMemNum();
			
			Petsitter pe = new MemberService().selectPetsitter(memNum);
			
			if(pe != null) {
				
				request.getRequestDispatcher("views/board/petsitterBoardRegister.jsp").forward(request, response);
			}else {
			
			request.getRequestDispatcher("views/member/petsitterEnroll.jsp").forward(request, response);
			}
			
			
		}else {
			request.getSession().setAttribute("alertMsg", "로그인 하셔야 이용 가능한 서비스 입니다.");
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
