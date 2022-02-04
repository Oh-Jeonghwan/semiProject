package com.kh.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MatchService;

/**
 * Servlet implementation class AdminMatchDeleteController
 */
@WebServlet("/matchdelete.ma")
public class AdminMatchDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMatchDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String MatchNo = request.getParameter("matNo");
	
		
		int result = new MatchService().deleteMatch(MatchNo);
		
		if(result > 0) { // 성공 => /jsp/list.bo url 재요청 => 리스트페이지가 보여지도록
			
			request.getSession().setAttribute("alertMsg", "매칭내역 삭제 성공.");
			response.sendRedirect(request.getContextPath() + "/adminMatch.ad?currentPage=1");
		}
		else { // 실패 => 에러페이지가 보여지도록 에러문구
			request.setAttribute("errorMsg", "매칭내역 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
