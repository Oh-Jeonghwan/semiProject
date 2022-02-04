package com.kh.member.controller;

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
import com.kh.member.model.vo.Review;

/**
 * Servlet implementation class MatchDetailController
 */
@WebServlet("/matchDetail.ma")
public class MatchDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB 로부터 조회
		
		// 2) 뽑기
		String matchNo = request.getParameter("mno");
		
		// 3) 가공 => 패싱
		
		MatchService amService = new MatchService();
		
		ReviewService reService = new ReviewService();
		
		MemberService meService = new MemberService();

		Match m = amService.selectMatch(matchNo);
		
		String petNum = m.getPetNum();
		
		Member joinMem = new Member();
		
		String loginUser = ((Member)request.getSession().getAttribute("loginUser")).getMemNum();
		
		String loginUserId = ((Member)request.getSession().getAttribute("loginUser")).getMemId();
		
		Review r = reService.selectReview(loginUser, matchNo);
			
		// attachment 조회(서비스단 amService에서 나중에 petService로 넘겨서 attchment해야 펫사진 가져옴)
		Mypet pet = meService.selectMyPetImg(petNum);
		
		if(loginUserId.equals(m.getPoNum())) {
			
			joinMem = meService.selectJoinMem(m.getPsNum());
		} else {
			
			joinMem = meService.selectJoinMem(m.getPoNum());
		}
		
		
		
		// 조회했던 b, at 넘기기
		request.setAttribute("m", m);
		request.setAttribute("r", r);
		request.setAttribute("mp", pet);
		request.setAttribute("joinMem", joinMem);
			
		// 화면 => 포워딩
		request.getRequestDispatcher("views/member/matchListDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
