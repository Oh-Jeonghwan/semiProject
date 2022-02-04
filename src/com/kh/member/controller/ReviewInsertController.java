package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.service.ReviewService;
import com.kh.member.model.vo.PetOwner;
import com.kh.member.model.vo.Review;


/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insertreview.re")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String reviewWriter = request.getParameter("reviewWriter");
		String boardNum = request.getParameter("boardNum");
		String reviewContent = request.getParameter("reviewContent");
		
		// 회원 아이디로 된 reivewWriter를 견주 번호로 바꿔야한다.
		PetOwner changenum = new MemberService().changeMemNumPoNum(reviewWriter);
		
		reviewWriter = changenum.getPoNum();
		
		Review r = new Review();
		r.setReviewWriter(reviewWriter);
		r.setBoardNum(boardNum);
		r.setReviewContent(reviewContent);
		
		int result = new ReviewService().insertReview(r);
		
		if(result > 0) { 
			
			request.getSession().setAttribute("alertMsg", "리뷰 등록 성공");
			response.sendRedirect(request.getContextPath() + "/matchList.ma?currentPage=1");
		}
		else { // 실패 => 에러페이지가 보여지도록 에러문구
			request.setAttribute("errorMsg", "리뷰 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
