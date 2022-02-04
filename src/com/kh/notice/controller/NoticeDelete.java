package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDelete
 */
@WebServlet("/delete.no")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 인코딩
				//2) 값뽑기
				String noticeNo = request.getParameter("nno");
				
				//3) vo
				
				//4) 서비스단으로 토스
				int delete = new NoticeService().noticeDelete(noticeNo);
				
				if(delete>0) {
					request.getSession().setAttribute("alertMsg", "공지사항이 삭제되었습니다.");
					response.sendRedirect(request.getContextPath()+"/list.no?currentPage=1");
				}
				else {
					request.setAttribute("alertMsg", "공지사항이 삭제되지 않았습니다.");
					response.sendRedirect(request.getContextPath()+"/detail.no?nno="+noticeNo);
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
