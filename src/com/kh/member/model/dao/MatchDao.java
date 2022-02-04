package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Match;

public class MatchDao {
	
	private Properties prop = new Properties();
	
	public MatchDao() {
		
		String fileName = MatchDao.class.getResource("/sql/match/match-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMatchListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<Match> selectList(Connection conn, PageInfo pi, String loginUser) {
		
		ArrayList<Match> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMatchList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1, loginUser);
			pstmt.setString(2, loginUser);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Match(rset.getString("MAT_NO"),
									  rset.getString("BNUM"),
									  rset.getString("OID"),
									  rset.getString("PID"),
									  rset.getString("LOC"),
									  rset.getString("ADDR"),
									  rset.getDate("REQ_DATE"),
									  rset.getDate("CARE_SDATE"),
									  rset.getDate("CARE_EDATE"),
									  rset.getString("PET"),
									  rset.getString("TYPE"),
								      rset.getString("IS_END"),
								      rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public Match selectMatch(Connection conn, String matchNo) {


		Match m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMatch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, matchNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Match(rset.getString("MAT_NO"),
						  rset.getString("BNUM"),
						  rset.getString("OID"),
						  rset.getString("PID"),
						  rset.getString("LOC"),
						  rset.getString("ADDR"),
						  rset.getDate("REQ_DATE"),
						  rset.getDate("CARE_SDATE"),
						  rset.getDate("CARE_EDATE"),
						  rset.getString("PET"),
						  rset.getString("TYPE"),
					      rset.getString("IS_END"),
					      rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public int deleteMatch(Connection conn, String matchNo) {
		
		// UPDATE 문 => 처리된 행의 수
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMatch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, matchNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;		
	}

	public Match selectMatchAdmin(Connection conn, String matchNo) {


		Match m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMatchAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, matchNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Match(rset.getString("MAT_NO"),
						  rset.getString("BNUM"),
						  rset.getString("OID"),
						  rset.getString("PID"),
						  rset.getString("LOC"),
						  rset.getString("ADDR"),
						  rset.getDate("REQ_DATE"),
						  rset.getDate("CARE_SDATE"),
						  rset.getDate("CARE_EDATE"),
						  rset.getString("PET"),
						  rset.getString("TYPE"),
					      rset.getString("IS_END"),
					      rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}


	public ArrayList<Match> selectListAdmin(Connection conn, PageInfo pi) {
		
		ArrayList<Match> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMatchListAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Match(rset.getString("MAT_NO"),
						  rset.getString("BNUM"),
						  rset.getString("OID"),
						  rset.getString("PID"),
						  rset.getString("LOC"),
						  rset.getString("ADDR"),
						  rset.getDate("REQ_DATE"),
						  rset.getDate("CARE_SDATE"),
						  rset.getDate("CARE_EDATE"),
						  rset.getString("PET"),
						  rset.getString("TYPE"),
					      rset.getString("IS_END"),
					      rset.getString("STATUS")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

//-----------------------------------------------------------------------------------------------------------------------------------
	
	
	public ArrayList<Match> matchSearchList(Connection conn ,PageInfo pi, String id, String location, String maStartDate,
			Date maEndDate, String loginUser) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Match> list = new ArrayList<>();
		String sql = prop.getProperty("matchSearchList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser);
			pstmt.setString(2, loginUser);
			pstmt.setString(3, location);
			pstmt.setString(4, maStartDate);
			pstmt.setDate(5, maEndDate);
			pstmt.setString(6, id);
			pstmt.setString(7, id);
			pstmt.setInt(8, startRow);
			pstmt.setInt(9, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Match m = new Match(rset.getString("MAT_NO"),
						  rset.getString("BNUM"),
						  rset.getString("OID"),
						  rset.getString("PID"),
						  rset.getString("LOC"),
						  rset.getString("ADDR"),
						  rset.getDate("REQ_DATE"),
						  rset.getDate("CARE_SDATE"),
						  rset.getDate("CARE_EDATE"),
						  rset.getString("PET"),
						  rset.getString("TYPE"),
					      rset.getString("IS_END"),
					      rset.getString("STATUS"));
					list.add(m);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return list;
	}
	public int matchSearchListCount(Connection conn, String id, String location, String maStartDate, Date maEndDate, String loginUser) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		int result = 0;
		String sql = prop.getProperty("matchSearchLsitCount");
		
	
		
	    try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginUser);
			pstmt.setString(2, loginUser);
			pstmt.setString(3, location);
			pstmt.setString(4, maStartDate);
			pstmt.setDate(5, maEndDate);
			pstmt.setString(6, id);
			pstmt.setString(7, id);
			
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
	public int matchAdminSearchListCount(Connection conn, String location, String maStartDate, Date maEndDate,
			String id) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		int result = 0;
		String sql = prop.getProperty("matchAdminSearchLsitCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, location);
			pstmt.setString(2, maStartDate);
			pstmt.setDate(3, maEndDate);
			pstmt.setString(4, id);
			pstmt.setString(5, id);
			
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
	public ArrayList<Match> matchAdminSearchList(Connection conn, PageInfo pi, String id, String location,
			String maStartDate, Date maEndDate) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Match> list = new ArrayList<>();
		String sql = prop.getProperty("matchAdminSearchList");
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, location);
			pstmt.setString(2, maStartDate);
			pstmt.setDate(3, maEndDate);
			pstmt.setString(4, id);
			pstmt.setString(5, id);
			pstmt.setInt(6, startRow);
			pstmt.setInt(7, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Match m = new Match(rset.getString("MAT_NO"),
						  rset.getString("BNUM"),
						  rset.getString("OID"),
						  rset.getString("PID"),
						  rset.getString("LOC"),
						  rset.getString("ADDR"),
						  rset.getDate("REQ_DATE"),
						  rset.getDate("CARE_SDATE"),
						  rset.getDate("CARE_EDATE"),
						  rset.getString("PET"),
						  rset.getString("TYPE"),
					      rset.getString("IS_END"),
					      rset.getString("STATUS"));
					list.add(m);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		
		return list;
	}

	

	



	public int updateIsEnd(Connection conn, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateIsEnd");
		
		String admin = "admin";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			pstmt.setString(4, admin);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;	
	}


}
