package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class PetsitterRegisterController
 */
@WebServlet("/register.pe")
public class PetsitterRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetsitterRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memNum = ((Member)request.getSession().getAttribute("loginUser")).getMemNum();
		
		int result = new MemberService().insertPetsitter(memNum);
		
		if(result> 0) {
			
			request.getSession().setAttribute("alertMsg", "축하합니다! 펫시터 등록이 완료되었습니다!");
			response.sendRedirect(request.getContextPath()+"/registerForm.bo");
			
		}else {
			request.setAttribute("errorMsg", "펫시터 등록에 실패하셨습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
