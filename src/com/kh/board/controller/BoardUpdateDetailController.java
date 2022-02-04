package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
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
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateDetailController
 */
@WebServlet("/update.bo")
public class BoardUpdateDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateDetailController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
	 	 if(ServletFileUpload.isMultipartContent(request)) {
	 		
	 		 int maxSize = 1024*1024*10;
	 		 String savePath = request.getSession().getServletContext().getRealPath("/resources/board-upfiles/");
	 		 
	 		 MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
	 		
	 		 String bno = multiRequest.getParameter("bno");
	 		
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
	 		 
			
			Board b = new Board(memNum, psExp,psPet, psKid, psSmoke, petCap,price, psTitle,psDesc, condition);
			b.setBoardNum(bno);
			ArrayList<Attachment> list = new ArrayList<Attachment>();
			
			for(int i =1; i<4; i++) {
				
				String key = "reUpfiles"+i;
				String originalKey = "originalFileName" + i;
				String originalNo = "originalFileNo" + i;
			
			
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
					
					
					if(multiRequest.getParameter(originalNo)!= null) {
						
						at.setFileNo( multiRequest.getParameter(originalNo));
						new File(savePath +  multiRequest.getParameter(originalKey)).delete();
					
					}else {
						at.setRefBno(bno);
						
					}
					
				list.add(at);
			
				}

			} // for loop end
			
			 int result =	new BoardService().updateBoard(b, list);
		

				if(result > 0) {
					
					request.getSession().setAttribute("alertMsg", "업데이트에 성공하였습니다.");
					response.sendRedirect(request.getContextPath()+"/detail.bo?bno="+bno);
				}else {
					request.setAttribute("errorMsg", "업데이트 실패하였습니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp");
				}
				
		
	 		 
	 	 } //if(ServletFileUpload.isMultipartContent(request))
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
