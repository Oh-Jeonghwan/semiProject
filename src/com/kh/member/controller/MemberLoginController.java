package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MatchService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		
		Member m = new MemberService().loginMember(userId, userPwd);
		int updateisend = new MatchService().updateIsEnd(userId);
		
		if(m != null) {
			
			request.getSession().setAttribute("loginUser", m);
			request.getSession().setAttribute("alertMsg", m.getMemName() + "님 환영합니다!");
		
			response.sendRedirect("/pet/");
		}else {
			request.getSession().setAttribute("alertMsg", "로그인에 실패하셨습니다.");
			request.getRequestDispatcher("views/member/loginPage.jsp").forward(request, response);
			
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
