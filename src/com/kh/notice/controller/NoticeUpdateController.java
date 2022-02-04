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
 * Servlet implementation class NoticeUpdateConroller
 */
@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2) 값 뽑기
		
		String noticeNum = request.getParameter("nno");
		String noticeTitle = request.getParameter("title");
		String noticeContent= request.getParameter("content");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//3)vo객체
		Notice n = new Notice();
		n.setNoticeNum(noticeNum);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		//4)서비스단을 토스
		int result = new NoticeService().noticeUpdate(n);
		
		//5) 화면 띄우기
		if(result>0) {
			request.setAttribute("n", n);
			request.getSession().setAttribute("alertMsg", "공지사항이 수정되었습니다.");
			// 수정된 결과를 다시 조회해서 넘기기
			response.sendRedirect(request.getContextPath()+"/detail.no?nno="+noticeNum+"&currentPage="+currentPage);
		}
		else {
			request.getSession().setAttribute("alertMsg", "공지사항 수정이 실패했습니다.");
			request.setAttribute("currentPage", currentPage);
			response.sendRedirect(request.getContextPath() + "/detail.no?nno="+noticeNum+"&currentPage="+currentPage);
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