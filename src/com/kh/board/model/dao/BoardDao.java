package com.kh.board.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		
	
		
		try {
			String fileName = BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	



	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");


		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getPsNum());
			pstmt.setString(2, b.getPsExp());
			pstmt.setString(3, b.getPsPet());
			pstmt.setString(4, b.getPsKid());
			pstmt.setString(5, b.getPsSmoke());
			pstmt.setInt(6, b.getPetCap());
			pstmt.setInt(7, b.getPrice());
			pstmt.setString(8, b.getPsTitle());
			pstmt.setString(9, b.getPsDesc());
			pstmt.setString(10, b.getCondition());
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int insertAttachmnet(Connection conn, ArrayList<Attachment> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachmnet");
		
		
		try {
			
			for(Attachment at: list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFile_level());

				result = pstmt.executeUpdate();
				
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}


	public ArrayList<Board> selectBoardList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardList");
	
	
		ArrayList<Board> list = new ArrayList<Board>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
		

			while(rset.next()) {
			
			
				Board b = new Board( rset.getString("BOARD_NUM")
									, rset.getString("PS_NUM")
									, rset.getString("PS_EXP")
									, rset.getString("PS_PET")
									, rset.getString("PS_KID")
									, rset.getString("PS_SMOKE")
									, rset.getInt("PET_CAP")
									, rset.getInt("PRICE")
									, rset.getString("PS_TITLE")
									, rset.getString("PS_DES")
									, rset.getString("CONDITION")
									, rset.getString("STATUS")
									, rset.getString("MEM_NAME")
									, rset.getString("LOCATION")
									, rset.getString("ADDRESS")
									, rset.getString("MAINIMG")
								);
									
				
				list.add(b);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return list;
	}




	public Board selectBoard(Connection conn, String bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoard");
		Board b = null;
		

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rset = pstmt.executeQuery();
		

			if(rset.next()) {
			
				 b = new Board( 
						  rset.getString("BOARD_NUM")
						, rset.getString("PS_NUM")
						, rset.getString("PS_EXP")
						, rset.getString("PS_PET")
						, rset.getString("PS_KID")
						, rset.getString("PS_SMOKE")
						, rset.getInt("PET_CAP")
						, rset.getInt("PRICE")
						, rset.getString("PS_TITLE")
						, rset.getString("PS_DES")
						, rset.getString("CONDITION")
						, rset.getString("STATUS")
						, rset.getString("MEM_NAME")
						, rset.getString("LOCATION")
						, rset.getString("ADDRESS")
					
					);

			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return b;
	}


	public ArrayList<Attachment> selectAttachmentList(Connection conn, String bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachmentList");
		ArrayList<Attachment> list = new ArrayList<Attachment>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rset = pstmt.executeQuery();
		

			while(rset.next()) {
			
				Attachment at = new Attachment( 	
									rset.getString("FILE_NO")
									, rset.getString("REF_BNO")
									, rset.getString("ORIGIN_NAME")
									, rset.getString("CHANGE_NAME")
									, rset.getString("FILE_PATH")
									, rset.getDate("UPLOAD_DATE")
									, rset.getInt("FILE_LEVEL")
									, rset.getString("STATUS")
								);
									
				
				list.add(at);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return list;
	}



	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateBoard");
		
	
		try {
			pstmt = conn.prepareStatement(sql);
			
		/*
		 * new Board(memNum, psExp,psPet, psKid, psSmoke, petCap,price, psTitle,psDesc, condition);
		 */
			pstmt.setString(1, b.getPsExp());
			pstmt.setString(2, b.getPsPet());
			pstmt.setString(3, b.getPsKid());
			pstmt.setString(4, b.getPsSmoke());
			pstmt.setInt(5, b.getPetCap());
			pstmt.setInt(6, b.getPrice());
			pstmt.setString(7, b.getPsTitle());
			pstmt.setString(8, b.getPsDesc());
			pstmt.setString(9, b.getCondition());
			pstmt.setString(10, b.getBoardNum());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int updateAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateAttachment");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setString(4, at.getFileNo());
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int insertNewAttachment(Attachment at, Connection conn) {
		PreparedStatement pstmt = null;
		
		
		int result = 0;
		String sql = prop.getProperty("insertNewAttachment");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getRefBno());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
	
	
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public int deleteBoard(Connection conn, String bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
	
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,bno);
				result = pstmt.executeUpdate();
				
			

		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}





	public int selectListCount(Connection conn) {
		PreparedStatement pstmt = null;
	
		int listCount = 0;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


	public ArrayList<Board> selectList(PageInfo pi, Connection conn) {
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		ArrayList<Board> bList = new ArrayList<Board>();
		
		String sql = prop.getProperty("selectList");
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
		
			rset = pstmt.executeQuery();
		
			
			
			while(rset.next()) {
				
				Board b = new Board( rset.getString("BOARD_NUM")
						, rset.getString("PS_NUM")
						, rset.getString("PS_EXP")
						, rset.getString("PS_PET")
						, rset.getString("PS_KID")
						, rset.getString("PS_SMOKE")
						, rset.getInt("PET_CAP")
						, rset.getInt("PRICE")
						, rset.getString("PS_TITLE")
						, rset.getString("PS_DES")
						, rset.getString("CONDITION")
						, rset.getString("STATUS")
						, rset.getString("MEM_NAME")
						, rset.getString("LOCATION")
						, rset.getString("ADDRESS")
						, rset.getString("MAINIMG")
					);

				bList.add(b);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return bList;
	}


	public ArrayList<Board> selectSearchedList(Connection conn, String location,  int startPrice, int endPrice) {
		
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSearchedList");
		ArrayList<Board> list = new ArrayList<Board>();

		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, location);
			pstmt.setInt(2, startPrice);
			pstmt.setInt(3, endPrice);
		
		
			rset = pstmt.executeQuery();

			while(rset.next()) {

				Board bo = new Board( 
						 rset.getString("BOARD_NUM")
						, rset.getString("PS_NUM")
						, rset.getString("PS_EXP")
						, rset.getString("PS_PET")
						, rset.getString("PS_KID")
						, rset.getString("PS_SMOKE")
						, rset.getInt("PET_CAP")
						, rset.getInt("PRICE")
						, rset.getString("PS_TITLE")
						, rset.getString("PS_DES")
						, rset.getString("CONDITION")
						, rset.getString("STATUS")
						, rset.getString("MEM_NAME")
						, rset.getString("LOCATION")
						, rset.getString("ADDRESS")
						, rset.getString("MAINIMG")
					);
						
									
				
				list.add(bo);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		

		return list;
	}


	



}
