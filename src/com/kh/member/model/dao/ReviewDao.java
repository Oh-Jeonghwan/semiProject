package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.vo.Review;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {
		
		String fileName = ReviewDao.class.getResource("/sql/match/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public int deleteReview(Connection conn, String reviewNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 아직 구현하다 맘
	public int insertReview(Connection conn, Review r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReviewWriter());
			pstmt.setString(2, r.getBoardNum());
			pstmt.setString(3, r.getReviewContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}


	public Review selectReview(Connection conn, String loginUser, String matchNo) {
		
		Review r = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser);
			pstmt.setString(2, matchNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(rset.getString("REVIEW_NUM"),
						  	   rset.getString("REVIEW_WRITER"),
						  	   rset.getString("BOARDNUM"),
						  	   rset.getDate("REVIEW_DATE"),
						  	   rset.getString("REVIEW_CONTENT"),
						  	   rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}


	public Review selectReviewAdmin(Connection conn, String reviewwriter, String matchNo) {
		
		Review r = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewwriter);
			pstmt.setString(2, matchNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(rset.getString("REVIEW_NUM"),
						  	   rset.getString("REVIEW_WRITER"),
						  	   rset.getString("BOARDNUM"),
						  	   rset.getDate("REVIEW_DATE"),
						  	   rset.getString("REVIEW_CONTENT"),
						  	   rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}
	
	public ArrayList<Review> selectReviewList(Connection conn, String bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		ArrayList<Review> list = new ArrayList<Review>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rset = pstmt.executeQuery();
		

			while(rset.next()) {
				
			
			
				Review r = new Review( 	
									rset.getString("REVIEW_NUM")
									, rset.getString("REVIEW_WRITER")
									, rset.getString("BOARD_NUM")
									, rset.getDate("REVIEW_DATE")
									, rset.getString("REVIEW_CONTENT")
									, rset.getString("MEM_NAME")
									, rset.getString("STATUS")
								);
									
				
				list.add(r);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return list;
	}
}
