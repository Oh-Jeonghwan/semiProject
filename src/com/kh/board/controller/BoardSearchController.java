package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String location = request.getParameter("location");
		String price = request.getParameter("price");
		int startPrice = 0;
		int endPrice = 0;
		
		if(price.equals("7000~15000")) {
			startPrice = 7000;
			endPrice = 15000;
		}else if(price.equals("15000~20000")) {
			startPrice = 15000;
			endPrice = 20000+1;
		}else if(price.equals("20000~25000")) {
			startPrice = 20000;
			endPrice = 25000+1;
		}else if(price.equals("25000~30000")) {
			startPrice = 25000;
			endPrice = 30000+1;
		}
		
	


		
		
		
		ArrayList<Board> list = new BoardService().selectSearchedList(location,  startPrice, endPrice);
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		
		gson.toJson(list, response.getWriter());
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
