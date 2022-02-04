package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.service.ReviewService;
import com.kh.member.model.vo.Review;


@WebServlet("/list.re")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bno = request.getParameter("bno");
		
		ArrayList<Review> reviews = new ReviewService().selectReviewList(bno);
		response.setContentType("application/json; charset=UTF-8");
		
		Review empty =new Review();
		empty.setReviewDate(null);
		empty.setWriterName(null);
		empty.setReviewContent("리뷰가 아직 없습니다.");
		
		
		if(!reviews.isEmpty()) {
			new Gson().toJson(reviews, response.getWriter());
		}else {
			new Gson().toJson(empty, response.getWriter());
		
		}
		

		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
