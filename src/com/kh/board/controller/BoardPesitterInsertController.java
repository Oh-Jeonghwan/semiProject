package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.Attachment;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Petsitter;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class BoardPesitterInsertController
 */
@WebServlet("/insert.bo")
public class BoardPesitterInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPesitterInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024*1024*10;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board-upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			

			String memNum = multiRequest.getParameter("memNum");
			String psExp = multiRequest.getParameter("psExp");
			String psPet = multiRequest.getParameter("psPet");
			String psKid = multiRequest.getParameter("psKid");
			String psSmoke = multiRequest.getParameter("psSmoke");
			int petCap = Integer.parseInt(multiRequest.getParameter("petCap"));
			int price = Integer.parseInt(multiRequest.getParameter("price"));
			String psTitle = multiRequest.getParameter("psTitle");
			String psDesc = multiRequest.getParameter("psDesc");
			String condition = multiRequest.getParameter("condition");
			
			Petsitter pe = new MemberService().selectPetsitter(memNum);
	
			
	
				
				Board b = new Board(memNum, psExp,psPet, psKid, psSmoke, petCap,price, psTitle,psDesc, condition);

				b.setPsNum(pe.getPsNum());
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();

			
				for(int i =1; i<4; i++) {
					
					String key = "upfiles"+i;
					if(multiRequest.getOriginalFileName(key)!= null) {
						
						Attachment at = new Attachment();
						
						at.setOriginName(multiRequest.getOriginalFileName(key));
						at.setChangeName(multiRequest.getFilesystemName(key));
						at.setFilePath("/resources/board-upfiles/");
						
					
					
						
						
						if(i == 1) {
							at.setFile_level(1);
						}else {
							at.setFile_level(2);
						}
					  list.add(at);
					}
					
				}
				
				int result =  new BoardService().insertBoard(b, list);
				
				
				
				if(result > 0) {
					request.getSession().setAttribute("alertMsg", "축하합니다! 펫시터 게시판에 추가되었습니다!");
					response.sendRedirect("list.bo?currentPage=1");
				}else {
					
					request.setAttribute("errorMsg", "펫시터 신청하기에 실패하셨습니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
				}
			
				
			
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
