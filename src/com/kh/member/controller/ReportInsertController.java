package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Report;

/**
 * Servlet implementation class ReportInsertController
 */
@WebServlet("/insertreport.re")
public class ReportInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String repWriter = request.getParameter("reportWriter"); // 유저 멤버넘버
		String repMem = request.getParameter("reportMem"); // 유저아이디
		String repContent = request.getParameter("reportContent");
		
		Member repMember = new MemberService().selectMember(repMem);
		repMem = repMember.getMemNum();
		
		Report rep = new Report();
		rep.setRepWriter(repWriter); // 신고한
		rep.setRepMem(repMem); // 신고당한
		rep.setRepContent(repContent);
		
		int result = new MemberService().insertReport(rep);
		int resultupdate = 0;
		
		if(result > 0) { 
			
			resultupdate = new MemberService().updateReportCnt(repMem);
		}
		else { // 실패 => 에러페이지가 보여지도록 에러문구
			request.setAttribute("errorMsg", "회원 신고를 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		if(result * resultupdate > 0) {
			
			request.getSession().setAttribute("alertMsg", "회원을 신고하였습니다.");
			response.sendRedirect(request.getContextPath() + "/matchList.ma?currentPage=1");
		}
		
		else {
			
			request.setAttribute("errorMsg", "회원 신고를 실패했습니다.");
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
