package com.kh.notice.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Properties;
import com.kh.common.JDBCTemplate.*;
import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.*;

public class NoticeDao {
	//프로퍼티 객체 생성
	private Properties prop = new Properties();
	
	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//dao 소스
	public int selectListCount(Connection conn) { //공지사항 게시글의 총 수를 알아오는
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {//detail 상세보기
		ArrayList<Notice> list= new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			//TOP-N 분석 활용: 인라인 뷰 활용
			// 1) order by 순서가 가장 마지막인데 맨 처음에 실행이 되어야 하므로
			//	  일단 정렬해주는 select 문을 만듦 => 서브쿼리
			// 2) 서브쿼리를 from 절에 넣음 (메인쿼리) + ROUNUM 붙이기
			// 3) 메인쿼리의 where 절에 어디서부터 어디까지만 조회할건지 잘라내기
			
			//구멍 메우기
			/*
			 * boardLimit가 10이라고 가정하에
			 * currentPage = 1 => 시작값 1, 끝값 10
			 * currentPage = 2 => 시작값 11, 끝값 20
			 * currentPage = 3 => 시작값 21, 끝값 30
			 * ...
			 * 
			 * => 시작값 = (currentPage - 1)*boardLimit + 1
			 * => 끝값 = ((currentPage - 1)*boardLimit + 1) + boardLimit - 1
			 */
			
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = startRow + pi.getBoardLimit() - 1;
					
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			
				list.add(
					new Notice(rset.getString("NOTICE_NUM")
							, rset.getString("NOTICE_TITLE")
							, rset.getDate("NOTICE_DATE")
							, rset.getString("MEM_ID")
							, rset.getString("NOTICE_CONTENT")
							, rset.getInt("NOTICE_VIEWER")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public int noticeEnroll(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeEnroll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public Notice noticeSelect(Connection conn, String noticeNo) {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeSelect");
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getString("NOTICE_NUM"),
							   rset.getString("NOTICE_TITLE"),
							   rset.getString("MEM_ID"),
							   rset.getDate("NOTICE_DATE"),
							   rset.getString("NOTICE_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	public int noticeUpdate(Connection conn, Notice n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeUpdate");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getNoticeNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int noticeDelete(Connection conn, String noticeNo) {
		int result=0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("noticeDelete");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int increaseCount(Connection conn, String noticeNo) {
		PreparedStatement pstmt = null;
		int increaseCount = 0;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, noticeNo);
			
			increaseCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return increaseCount;
	}


	public ArrayList<Notice> noticeSearch(Connection conn, String date1, Date date2, String keyword, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeSearch");
		
		//TOP-N 분석 활용: 인라인 뷰 활용
		// 1) order by 순서가 가장 마지막인데 맨 처음에 실행이 되어야 하므로
		//	  일단 정렬해주는 select 문을 만듦 => 서브쿼리
		// 2) 서브쿼리를 from 절에 넣음 (메인쿼리) + ROUNUM 붙이기
		// 3) 메인쿼리의 where 절에 어디서부터 어디까지만 조회할건지 잘라내기
		
		//구멍 메우기
		/*
		 * boardLimit가 10이라고 가정하에
		 * currentPage = 1 => 시작값 1, 끝값 10
		 * currentPage = 2 => 시작값 11, 끝값 20
		 * currentPage = 3 => 시작값 21, 끝값 30
		 * ...
		 * 
		 * => 시작값 = (currentPage - 1)*boardLimit + 1
		 * => 끝값 = ((currentPage - 1)*boardLimit + 1) + boardLimit - 1
		 */
		
		int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, date1);
			pstmt.setDate(2, date2);
			pstmt.setString(3, "%"+keyword+"%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
					
				Notice n = new Notice(rset.getString("NOTICE_NUM")
									, rset.getString("NOTICE_TITLE")
									, rset.getDate("NOTICE_DATE")
									, rset.getString("MEM_ID")
									, rset.getString("NOTICE_CONTENT")
									, rset.getInt("NOTICE_VIEWER")
						);
				list.add(n);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int NoticeSerachListCount(Connection conn, int currentPage, int pageLimit, int boardLimit, String date1, Date date2, String keyword) {
		int noticeSearchListCount=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("NoticeSearchListCount");
	
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, date1);
			pstmt.setDate(2, date2);
			pstmt.setString(3, "%"+keyword+"%");
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				noticeSearchListCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeSearchListCount;
	}

}