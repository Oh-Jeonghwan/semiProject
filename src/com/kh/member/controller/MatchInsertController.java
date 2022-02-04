package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.DateParse;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;


/**
 * Servlet implementation class MatchInsertController
 */
@WebServlet("/insert.ma")
public class MatchInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MatchInsertController() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		
		String bno = request.getParameter("bno");
	
		Board b = new BoardService().selectBoard(bno);

		String psNum = b.getPsNum();
		String memNum = request.getParameter("memNum");
	
		
		PetOwner p = new MemberService().selectPetOwner(memNum);
		ArrayList<Mypet> pet = new MemberService().selectMyPetMatchList(p.getPoNum());
	
		String petNum = pet.get(0).getPetNum();
		
		
		String poNum = p.getPoNum();
		String location = b.getWriterLocation();
		String address = b.getWriterAddress();
		
		// date conversion
		String careSdateString = request.getParameter("bookStart");
		String careDdateString = request.getParameter("bookEnd");
		
		Date careSdate=	new DateParse().maEndDate(careSdateString);
		Date careDdate=	new DateParse().maEndDate(careDdateString);
		
		
		
	
		Match ma = new Match(bno, poNum, psNum, location, address, careSdate, careDdate ,  petNum);
		
		int result = new MemberService().insertMatching(ma);
		
	
		
		if(result > 0) {
			
			request.getRequestDispatcher("views/board/petsitterBoardMatchSuccess.jsp").forward(request, response);
			
		}else {
				
			request.setAttribute("errorMsg", "메치에 실패하였습니다.");
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
