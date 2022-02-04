package com.kh.admin.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.admin.model.service.AdminService;
/**
 * Servlet implementation class AdminRestoreUserController
 */
@WebServlet("/adminRestore.ad")
public class AdminRestoreUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRestoreUserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String memNum = request.getParameter("mnum");
        
        int result = new AdminService().adminRestoreUser(memNum);
        
        if(result > 0) {
            request.getSession().setAttribute("alertMsg", "성공적으로 회원복구");
            response.sendRedirect(request.getContextPath() + "/userAdmin.ad?currentPage=1");
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
