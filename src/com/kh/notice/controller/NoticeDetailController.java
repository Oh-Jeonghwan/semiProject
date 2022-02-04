package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.no")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2) 값
		String noticeNo = request.getParameter("nno");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		//페이지 주소 내에서 뽑아 오는가?
		//3)vo가공 값이 하난데 굳이
		
		//4)service단으로
		Notice n = new NoticeService().noticeSelect(noticeNo);
		int increaseCount = new NoticeService().increaseCount(noticeNo);
		
		if(increaseCount>0) {
			//5) 화면 띄우기
			request.setAttribute("n", n);
			request.setAttribute("currentPage", currentPage);
			request.getRequestDispatcher("/views/notice/noticeDetail.jsp?currentPage="+currentPage).forward(request, response);
			//먼저 뽑아온 값들을 담고 화면을 띄워주는 순서를 잘 알아야 한다.
		}
		else {
			request.getSession().setAttribute("alertMsg","공지사항 상세조회 실패");
			response.sendRedirect("/views/notice/noticeList.jsp?currentPage="+currentPage);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}