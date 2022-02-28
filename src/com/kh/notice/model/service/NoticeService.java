package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;

import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.model.vo.NoticeSearch;

import static com.kh.common.JDBCTemplate.*;
public class NoticeService {

	public int selectListCount() { //공지사항 게시글의 총 개수
		Connection conn = getConnection();
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		return listCount;
	}
	
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {//detail 상세보기
		Connection conn = getConnection();
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int noticeEnroll(Notice n) {
		
		Connection conn = getConnection();
		int result = new NoticeDao().noticeEnroll(conn,n);
		if(result>0) {
			commit(conn);
		}
		else{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Notice noticeSelect(String noticeNo) {
		Connection conn = getConnection();
		Notice n = new NoticeDao().noticeSelect(conn, noticeNo);
		close(conn);
		return n;
	}

	public int noticeUpdate(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().noticeUpdate(conn,n);
		if(result>0) {
			commit(conn);
		}
		else{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int noticeDelete(String noticeNo) {

		Connection conn = getConnection();
		int result = new NoticeDao().noticeDelete(conn,noticeNo);
		if(result>0) {
			commit(conn);
		}
		else{
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int increaseCount(String noticeNo) {
		Connection conn = getConnection();
		int increaseCount = new NoticeDao().increaseCount(conn, noticeNo);
		if(increaseCount>0) {
			commit(conn);
		}
		else{
			rollback(conn);
		}
		close(conn);
		return increaseCount;
	}
   
	
	public ArrayList<Notice> noticeSearch(String date1, Date date2, String keyword, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().noticeSearch(conn, date1, date2, keyword, pi);
		close(conn);
		return list;
	}

	public int NoticeSerachListCount(int currentPage, int pageLimit, int boardLimit, String date1, Date date2, String keyword) {
		Connection conn =getConnection();
		
		int noticeSearchListCount = new NoticeDao().NoticeSerachListCount(conn, currentPage,pageLimit,boardLimit,date1,date2,keyword);
		return noticeSearchListCount;
	}

	
	
}