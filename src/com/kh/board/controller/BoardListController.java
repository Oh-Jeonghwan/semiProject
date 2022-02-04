package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BoardListController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 //ArrayList<Board> list = new BoardService().selectBoardList();
	 
	 
	 //-------------paging 처리 -------------
	 
		int listCount; //헌재 일반게시판 게시글 총 갯수. => Board로 부터 count(*) but, status = 'Y'
		int currentPage; //현재 페이지 => request.getParameter("currentPage");
		int pageLimit;  //페이지 하단에 보여질 페이지 바에 페이지 최대갯수
		int boardLimit; // 한페이지에 보여질 게시물리스트
	
		int maxPage; //가장 마지막 페이지가 몇번 페이지인지 (= 총 페이지 갯수)
		int startPage; //페이지 하단에 보여질 페이징 바에 시작 수 
		int endPage; //페이지 하단에 보여질 페이징 바에 끝수
		listCount = new BoardService().selectListCount();
		
		// * currrentPage : 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	
		// * pageLimit : 페이징바의 페이지 갯수
		pageLimit = 10;
		
		// * boardLimit : 한페이지에 보여질 개시글
		boardLimit = 10;
		maxPage = (int)(Math.ceil((double)listCount / boardLimit));
		startPage = ((currentPage -1 ) / pageLimit )* pageLimit + 1;
		endPage = startPage + pageLimit -1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> pageList = new BoardService().selectList(pi);
	
		request.setAttribute("pi", pi); // 페이징바를 만들때 필요한 변수
		request.setAttribute("list", pageList);

		request.getRequestDispatcher("views/board/petsitterBoardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
