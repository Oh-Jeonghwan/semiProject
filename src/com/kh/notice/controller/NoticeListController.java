package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.no")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-----------페이징 처리--------------
		//필요한 변수들
		int listCount;//현재 일반게시판의 게시글 총 개수=>BOARD 로부터 조회 COUNT(*) 활용 (status='Y')
		int currentPage;//현재 페이지(즉, 사용자가 요쳥한 페이지)=>request.getParameter("currentPage")
		int pageLimit;//페이지 하단에 보여질 페이징바의 페이지 최대 개수=>
		int boardLimit;//한 페이지에 보여질 게시글 개수
		
		int maxPage;//가장 마지막 페이지가 몇 번 페이지인지(==총페이지개수)
		int startPage;//페이지 하단에 보여질 시작수
		int endPage; //페이지 하다넹 보여질 페이징바의 끝수
		
		//* listCount: 총 개시글 개수-먼저 보내서 총 개수를 파악해온다.
		listCount = new NoticeService().selectListCount();
		
		
		//*currentPage: 현재페이지(==사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//*pageLimit: 페이징바의 페이지 최대 개수
		pageLimit = 10;
		
		//*boardLimit: 한 페이지에 보여질 게시글의 최대 개수
		boardLimit = 10;
		
		
		
		//*maxPage: 가장 마지막 페이지가 몇 번 페이지인지 (총 페이지 개수)
		/*
		 * listcount, boardLimit 에 영향을 받음
		 * 
		 * -공식 구하기
		 * 단, boardLimit 이 10이라는 가정 하에 규칙을 구해보자
		 * 
		 * 총개수(listCount)		boardLimit(10개)     max (마지막 페이지)
		 * 100개					10개					10페이지
		 * 101개 					10개					11페이지
		 * 105개					10개					11페이지
		 * 109개					10개					11페이지
		 * 110개					10개					11페이지
		 * 111개					10개					12페이지
		 * => 나눗셈 결과(listCount/boardLimit)를 올림처리 할 경우 maxPage 가 된다.
		 * 
		 * 스텝
		 * 1) listCount 를 double로 형변환
		 * 2) listCount / boardLimit
		 * 3) 결과에 올림처리=> Math.ceil()
		 * 4) 결과값을 int로 형변환
		 */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		
		//*startPage: 페이지 하단에 보여질 페이징 바 시작수
		/*
		 * pageLimit,currentPage 에 영향을 받음
		 * 
		 * -공식 구하기
		 * 단, pageLimit가 10이라는 가정하에 규칙을 구해보자
		 * 
		 * startPage : 1,11,21,31,41,...=>n * 10 + 1(n은 0부터)=>10의 배수+1
		 * 만약에 pageLimit 가 5였다면?
		 * 1,6,11,16,21,26...=>5의 배수 +1
		 * 
		 * 즉,startPage =  n * pageLimit + 1
		 * 
		 * currentPage 			startPage
		 * 1					1
		 * 5					1
		 * 10					1				
		 * 11					11
		 * 15					11
		 * 20					11
		 * 
		 * => 1 ~ 10 : n * 10 + 1 == 1  => n = 0
		 * => 11 ~ 20: n * 10 + 1 == 11 => n = 1 
		 * => 21 ~ 30: n * 10 + 1 == 21 => n = 2
		 * ...
		 * 
		 * => n 을 구하는 공식을 도출해보면
		 * 	  n = (currentPage - 1) / pageLimit
		 * 			0 ~ 9 / 10 = 0
		 * 			10 ~ 19 / 10 = 1
		 * 			20 ~ 29 / 10 = 2
		 * 			...
		 * 
		 * n을 대입시키면
		 * startPage =  (currentPage - 1) / pageLimit * pageLimit + 1
		 */
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		//endPage
		/*
		 * startPage, pageLimit 에 영향을 받음(단, maxPage 도 마지막 페이장 바에 대해선 영향을 준다.)
		 * 
		 * -공식 구하기
		 * 	단, pageLimit 가 10이라는 가정 하에 규칙을 구해보자
		 * 	startPage : 1  => endPage : 10
		 * 	startPage : 11 => endPage : 20
		 *  startPage : 21 => endPage : 30
		 *  ...
		 *  => endPage = startPage + pageLimit -1
		 *  
		 *  + 선택적으로 (if 문) 마지막 페이징 바에 대해서는 maxpage 까지만 보이게끔 하자.
		 *  
		 */
		endPage = startPage + pageLimit -1;
		//startPage가 11이어서 endpage 가 20이 되어야 하는데 
		//maxPage가 마침 13까지밖에 없다면?
		// => endPage 를 maxPage 로 변경
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 여기까지 총 7개의 변수를 만들었음
		// 7개의 변수를 가지고 해당되는 범위에 따른 게시글 10개씩만 SElect
		// service 단으로 토스 => 7개의 변수들 => vo 클래스에 만들어서 가공해 넘길 것
		// com.kh.common.model.vo.PageInfo
		
		//3) vo로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
									maxPage, startPage, endPage);
		
		//4) service로 토스
		//10개씩 board를 가져올 것 => ArrayList
		ArrayList<Notice> list = new NoticeService().selectNoticeList(pi);
		
		//System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		//5)화면 띄우기
		request.getRequestDispatcher("views/notice/noticeList.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}