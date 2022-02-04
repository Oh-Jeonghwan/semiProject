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
 * Servlet implementation class NoticeEnrollController
 */
@WebServlet("/enroll.no")
public class NoticeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1)인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2)값 뽑기
		String memNum = request.getParameter("memNum");
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		//3)vo가공
		Notice n = new Notice();
		n.setNoticeWriter(memNum);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		//4)서비스단으로 토스
		int result = new NoticeService().noticeEnroll(n);
		//5)결과 받아 화면 띄우기
		//값 담은 것도 같이 보줘야 함
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "공지사항이 등록됐습니다.");
			response.sendRedirect(request.getContextPath()+"/list.no?currentPage=1");
		}
		else {
			request.getSession().setAttribute("alertMsg", "공지사항 등록에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/list.no");
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