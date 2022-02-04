package com.kh.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

import com.kh.common.model.vo.Attachment;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.service.ReviewService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;
import com.kh.member.model.vo.Review;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String bno = request.getParameter("bno");
		ArrayList<Mypet> ownerPetList = null;
		
		if((Member)request.getSession().getAttribute("loginUser") != null) {
			String memNum = ((Member)request.getSession().getAttribute("loginUser")).getMemNum();
			PetOwner po = new MemberService().selectPetOwner(memNum);
		
			 
				if(po != null) {
					 
				 ownerPetList = new MemberService().selectMyPetMatchList(po.getPoNum());
				 
				}
		}

	
		Board b = new BoardService().selectBoard(bno);
		ArrayList<Mypet> petList = new MemberService().selectPetsitterPetList(b.getPsNum());
		
		
	
		ArrayList<Attachment> list = new BoardService().selectAttachmentList(bno); 
		
		
		Date today = new Date();
	
	 	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	 	String ftToday = format.format(today);
	 	request.setAttribute("ftToday", ftToday);
	 	request.setAttribute("list", list);
	 	request.setAttribute("petList", petList);
	 	request.setAttribute("ownerPetList", ownerPetList);
		request.setAttribute("b", b);
	
		
		
	
		
		request.getRequestDispatcher("/views/board/petsitterBoardDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
