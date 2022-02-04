package com.kh.member.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.member.model.service.MemberService;
/**
 * Servlet implementation class MemberIdCheckController
 */
@WebServlet("/idCheck.me")
public class MemberIdCheckController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        // GET 
        
                // 2) request 로부터 값 뽑기
                String checkId = request.getParameter("checkId");
            
                // 3) VO가공 => 패싱 
                
                // 4) Service 단으로 토스(MemberService)
            int count = new MemberService().idCheck(checkId); // 중복확인은 SELECT 문
            //중복확인은 SELECT문이지만 굳이 정보를 다담아서 넘길필요가 없기 떄문에 숫자로받겟따.
            
            
            // 5) 결과에따른 응답뷰 지정=> 화면이깜빡
            
                // 형식과 인코딩 먼저 지정
                response.setContentType("text/html; charset=UTF-8"); 
            
            
                
            
             
            
                if(count>0) { //존재하는 아이디가 이미 있을 경우"NNNNN" 중복값이 있을 뗴
                    response.getWriter().print("NNNNN");
                } else { //없을경우 "NNNNY" 중복값이 없을 떄
                    response.getWriter().print("NNNNY");
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
