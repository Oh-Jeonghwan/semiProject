package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;

/**
 * Servlet implementation class MypetDeleteController
 */
@WebServlet("/myPetDelete.me")
public class MypetDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypetDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다.");
			
			// 괘씸하니깐 메인페이지로 소환 => /jsp => sendRedirect 형식
			response.sendRedirect(request.getContextPath());
			
		}
		else { // 로그인 후
			
			Member loginUser = (Member)session.getAttribute("loginUser");
			
			String memNum = loginUser.getMemNum();
					
			String petNum = request.getParameter("petNum");
			
			int result = new MemberService().deleteMypet(petNum);
			
			
			
			ArrayList<Mypet> list = new MemberService().selectMypetList(memNum);
			
			// request 에 담기
			request.setAttribute("list", list);
			
			if(result > 0) { // 성공 => /jsp/list.bo url 재요청 => 리스트페이지가 보여지도록
				
				request.getSession().setAttribute("alertMsg", "삭제가 완료 되었습니다.");
				request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
			}
			else { // 실패 => 에러페이지가 보여지도록 에러문구
				request.setAttribute("errorMsg", " 삭제 실패");
				request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
			}
			
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
