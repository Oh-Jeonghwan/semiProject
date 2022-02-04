package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.dao.MatchDao;
import com.kh.member.model.vo.Match;
public class MatchService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new MatchDao().selectListCount(conn);
		// SELECT 문의 결과는 ResultSet 이 맞긴한데
		// 상식적으로 생각해보면 게시글의 총 갯수는 정수형
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Match> selectList(PageInfo pi, String loginUser) {
		
		Connection conn = getConnection();
		
		ArrayList<Match> list = new MatchDao().selectList(conn, pi, loginUser);
		
		close(conn);
		
		return list;
	}
	
	public Match selectMatch(String matchNo) {
		
		Connection conn = getConnection();
		
		Match m = new MatchDao().selectMatch(conn, matchNo);
		
		close(conn);
		
		return m;
	}

	

	public int deleteMatch(String matchNo) {
		
		Connection conn = getConnection();
		
		int result = new MatchDao().deleteMatch(conn, matchNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Match> selectListAdmin(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Match> list = new MatchDao().selectListAdmin(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public Match selectMatchAdmin(String matchNo) {
		
		Connection conn = getConnection();
		
		Match m = new MatchDao().selectMatchAdmin(conn, matchNo);
		
		close(conn);
		
		return m;
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	
	public int MatchSearchListCount(String location, String maStartDate,Date maEndDate,String id, String loginUser ) {
		
		Connection conn = getConnection();
		int result = new MatchDao().matchSearchListCount(conn, id, location, maStartDate, maEndDate,loginUser);
		
		close(conn);
		return result;
	}
	
	public ArrayList<Match> matchSearchList(PageInfo pi, String id, String location, String maStartDate, Date maEndDate,String loginUser) {
		
		Connection conn = getConnection();
		
		ArrayList<Match> list = new MatchDao().matchSearchList(conn,pi,id,location,maStartDate, maEndDate,loginUser);
		
		close(conn);
		
		return list;
	}

	public int matchAdminSearchListCount(String location, String maStartDate, Date maEndDate, String id) {
		Connection conn = getConnection();
		
		int result = new MatchDao(). matchAdminSearchListCount(conn, location, maStartDate, maEndDate, id);
		
		close(conn);
		return result;
	}

	public ArrayList<Match> matchAdminSearchList(PageInfo pi, String id, String location, String maStartDate,
			Date maEndDate) {
			Connection conn = getConnection();
			ArrayList<Match> list = new MatchDao().matchAdminSearchList(conn, pi, id, location, maStartDate, maEndDate); 
			
			close(conn);
		return list;
	}

	public int updateIsEnd(String userId) {
		
		Connection conn = getConnection();
		
		int result = new MatchDao().updateIsEnd(conn, userId);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	
	

}

