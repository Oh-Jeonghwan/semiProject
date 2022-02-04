package com.kh.admin.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MatchService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.service.ReviewService;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;
import com.kh.member.model.vo.Review;

/**
 * Servlet implementation class AdminMatchDetailController
 */
@WebServlet("/adminMatchDetail.ad")
public class AdminMatchDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMatchDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matchNo = request.getParameter("mno");
		
		MatchService amService = new MatchService();
		
		ReviewService reService = new ReviewService();
		
		MemberService meService = new MemberService();

		Match m = amService.selectMatch(matchNo);
		
		String petNum = m.getPetNum();
		
		Member PetOwnerMem = meService.changeMemIdMemNum(m.getPoNum());
		
		String reviewWriter = PetOwnerMem.getMemNum();
		
		PetOwner poNum = meService.changeMemNumPoNum(reviewWriter);
		
		Review r = reService.selectReviewAdmin(poNum.getPoNum(), matchNo);
	
			
		Mypet pet = meService.selectMyPetImg(petNum);
			
		
		// 조회했던 b, at 넘기기
		request.setAttribute("m", m);
		request.setAttribute("r", r);
		request.setAttribute("mp", pet);
		
		if(request.getSession().getAttribute("loginUser")!= null && ((Member)request.getSession().getAttribute("loginUser")).getMemId().equals("admin")) {
			
			request.getRequestDispatcher("views/admin/match/matchManagementDetail.jsp").forward(request, response);
			
		}else {
			request.getSession().setAttribute("alertMsg", "관리자가 아니면 사용하실 수 없습니다.");
			response.sendRedirect("/pet/");
		}
			
		// 화면 => 포워딩
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
