package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.ReviewService;
import com.kh.member.model.vo.Review;

/**
 * Servlet implementation class ReviewDeleteController
 */
@WebServlet("/reviewdelete.re")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String reviewwriter = request.getParameter("reviewWriter");
		String matchNo = request.getParameter("matNo");
		
		// 매칭번호로 후기번호 찾기
		ReviewService reService = new ReviewService();
		
		Review r = reService.selectReviewAdmin(reviewwriter, matchNo);
		
		
		
		String reviewNum = r.getReviewNum();
		
		int result = new ReviewService().deleteReview(reviewNum);
		
		if(result > 0) { 
			
			request.getSession().setAttribute("alertMsg", "리뷰 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/adminMatch.ad?currentPage=1");
		}
		else { // 실패 => 에러페이지가 보여지도록 에러문구
			request.setAttribute("errorMsg", "리뷰 삭제 실패");
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
