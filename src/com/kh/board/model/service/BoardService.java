package com.kh.board.model.service;

import java.sql.Connection;

import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;


import static com.kh.common.JDBCTemplate.*;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;



public class BoardService {
	
	


	public int insertBoard(Board b, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
	
		int result2 = 0;
		int result3 =1;
	
			
			result2 = new BoardDao().insertBoard(conn, b);
		

		
		if(!list.isEmpty()) {
			result3 = new BoardDao().insertAttachmnet(conn, list);
		}
		
		if(result2  * result3 >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
	
		close(conn);
		
		return result2  * result3;
	}

	public ArrayList<Board> selectBoardList() {
		
		Connection conn = getConnection();
		ArrayList<Board> list =	new BoardDao().selectBoardList(conn);
		close(conn);
		return list;
	}



	public Board selectBoard(String bno) {
		
		Connection conn = getConnection();
		
		Board b = new BoardDao().selectBoard(conn, bno);
		
		close(conn);
		
		return b;
	}



	public ArrayList<Attachment> selectAttachmentList(String bno) {
		Connection conn = getConnection();
		ArrayList<Attachment> list =new BoardDao().selectAttachmentList(conn, bno);
		close(conn);
		return list;
	}


	public int updateBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		//1,2,3케이스에 대해 공통적으로 일어나는 BOARD UPDATE먼저 하고 조건 지정.
	 int result1 =	new BoardDao().updateBoard(conn, b);
	 int result2 = 1;
	 
	 // 새롭게 첨부된 파일이 있을 경우

	 if(!list.isEmpty()) {
		 
		 
		 for(Attachment at : list) {
			 
			 if(at.getFileNo() != null) {
		 			result2 = new BoardDao().updateAttachment(conn, at);
		 			
		 		}else {
		 			result2 = new BoardDao().insertNewAttachment(at, conn);
		 			
		 		}
			 
		 }
		 
		 		
	 	}
	 
		return (result1 * result2);
	}



	public int deleteBoard(String bno, String psNum) {
		
		Connection conn = getConnection();
		
		int result = new BoardDao().deleteBoard(conn, bno);
	

		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
	
	
		close(conn);
		
		return result ;
	}




	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDao().selectListCount(conn);
		// SELECT문의 결과는 ResultSet이 맞긴한데,
		// 상식적으로 생각해보면 게시글의 총 개수는 정수형.
		
		close(conn);
		
		
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
	Connection conn = getConnection();
		
		ArrayList<Board> bList = new BoardDao().selectList(pi, conn);
		
		
		close(conn);
		return bList;
	}

	public ArrayList<Board> selectSearchedList(String location,   int startPrice, int endPrice) {
		
		Connection conn = getConnection();
		ArrayList<Board> list =new BoardDao().selectSearchedList(conn, location,   startPrice, endPrice);
		close(conn);
		return list;
	}







}
