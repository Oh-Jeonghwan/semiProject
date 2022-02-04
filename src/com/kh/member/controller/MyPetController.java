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
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;

/**
 * Servlet implementation class MyPetController
 */
@WebServlet("/myPet.me")
public class MyPetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다.");
			
			// 괘씸하니깐 메인페이지로 소환 => /jsp => sendRedirect 형식
			response.sendRedirect(request.getContextPath());
			
		}
		else { // 로그인 후
			
			String memNum = request.getParameter("memNum");
			// 화면 띄우기 전 => 테이블로부터 조회해야함
			// 조회결과 여러개 => ArrayList
			ArrayList<Mypet> list = new MemberService().selectMypetList(memNum);
			
			// request 에 담기
			request.setAttribute("list", list);
			
			// 응답뷰 지정
			// views/board/thumbnailListView.jsp 파일 요청
			// => 포워딩
			request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
			
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
