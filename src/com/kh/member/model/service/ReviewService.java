package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.dao.ReviewDao;
import com.kh.member.model.vo.Review;

public class ReviewService {


	public int deleteReview(String reviewNum) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().deleteReview(conn, reviewNum);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertReview(Review r) {
		
		
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Review selectReview(String loginUser, String matchNo) {
		
		Connection conn = getConnection();
		
		Review r = new ReviewDao().selectReview(conn, loginUser, matchNo);
		
		close(conn);
		
		return r;
	}

	public Review selectReviewAdmin(String reviewwriter, String matchNo) {
		
		Connection conn = getConnection();
		
		Review r = new ReviewDao().selectReviewAdmin(conn, reviewwriter, matchNo);
		
		close(conn);
		
		return r;
	}
	
	public ArrayList<Review> selectReviewList(String bno) {
		Connection conn = getConnection();
		ArrayList<Review> list =	new ReviewDao().selectReviewList(conn, bno);
		close(conn);
		return list;
	}

}
