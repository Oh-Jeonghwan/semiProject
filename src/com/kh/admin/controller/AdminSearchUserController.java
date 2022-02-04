package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminSearchUserController
 */
@WebServlet("/adminSearch.ad")
public class AdminSearchUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String keyword = request.getParameter("keyword");
		ArrayList<Member> searchList=  new AdminService().adminSearch(keyword);
		ArrayList<Member> blist = new AdminService().adminBlackListUserSelect();
		
		
		if(request.getSession().getAttribute("loginUser")!= null && ((Member)request.getSession().getAttribute("loginUser")).getMemId().equals("admin")) {
			
			if(searchList.isEmpty()) {
				request.getSession().setAttribute("alertMsg","조회하신 정보가 없습니다.");
				response.sendRedirect(request.getContextPath()+"/userAdmin.ad?currentPage=1");
			}
			else {
				request.setAttribute("list",searchList);
				request.setAttribute("blist",blist);
				request.getSession().setAttribute("keyword",keyword);
				request.getRequestDispatcher("/views/admin/user/searchUser.jsp").forward(request, response);
			}
			
		}else {
			request.getSession().setAttribute("alertMsg", "관리자가 아니면 사용하실 수 없습니다.");
			response.sendRedirect("/pet/");
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
