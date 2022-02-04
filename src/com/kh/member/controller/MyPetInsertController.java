package com.kh.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.member.model.service.MemberService;
import com.kh.common.model.vo.Attachment;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MyPetInsertController
 */
@WebServlet("/myPetInsert.me")
public class MyPetInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPetInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST => 인코딩
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");

		// 먼저 견주테이블에 대한 INSERT
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String memNum = loginUser.getMemNum();
		
		PetOwner po = new MemberService().selectPetOwner(memNum);
		
		int result0 = 0;
		
		if(po == null) {
			
			result0 = new MemberService().insertPetOwner(memNum); // 주인임을 추가
		} else {
			result0 = 1;
		}
		
		
		/*
		if(result0 > 0) { // 성공했다면 강아지도 추가
			
			// 2) 단계 전에 "첨부파일" => multipart/form-data => 조건 먼저 제시
			if(ServletFileUpload.isMultipartContent(request)) {
				
				// MultipartRequest 객체 생성 => 곧바로 서버로 파일이 올라옴
				// 객체 생성 전
				// 1_1. 전송 용량 제한 (10MByte)
				int maxSize = 1024 * 1024 * 10;
				
				// 1_2. 저장할 서버의 물리적 경로 제시
				String savePath = request.getServletContext().getRealPath("/resources/mypet_upfiles/");
				
				// 2. MultipartRequet 객체 생성 (***파일명 수정해서 올리기)
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				
				// 2) multiRequest 으로 부터 값 뽑기 => getParameter 메소드 이용
				String petName = multiRequest.getParameter("petName");
				String petGender = multiRequest.getParameter("petGender");
				String petType = multiRequest.getParameter("petType");
				String petBirth = multiRequest.getParameter("petBirth");
				String petWeight = multiRequest.getParameter("petWeight");
				String petDec = multiRequest.getParameter("petDec");
				
				
				// 3) VO 가공
				// Mypet
				Mypet mp = new Mypet();
				mp.setPetName(petName);
				mp.setPetGender(petGender);
				mp.setPetType(petType);
				mp.setPetBirth(petBirth);
				mp.setPetWeight(petWeight);
				mp.setPetDec(petDec);
				// mp.setPet
				
				// Attachment => 사진게시판에 메인이미지에 required 
				// => 적어도 게시글 한개당 최소 한개의 첨부파일은 존재한다.
				// 여러개의 VO 객체를 묶어서 다룰 경우 ArrayList
				ArrayList<Attachment> list = new ArrayList<>();
				
				// 키값 : file1 ~ 4 
				for(int i = 1; i <= 1; i++) {
					
					// 키값만 미리 변수로 셋팅
					String key = "file" + i;
					
					// 원본파일명이 존재하는지 메소드를 이용해서 파악 => 조건
					if(multiRequest.getOriginalFileName(key) != null) { // 원본 파일이 존재할경우
						
						// 첨부파일이 존재할 경우 Attachment 객체 생성
						// 필드 : 원본명, 수정명, 폴더경로, 파일레벨** (1:대표, 2:상세)
						Attachment at = new Attachment();
						at.setOriginName(multiRequest.getOriginalFileName(key)); // 원본명
						at.setChangeName(multiRequest.getFilesystemName(key)); // 수정명
						at.setFilePath("resources/mypet_upfiles/"); // 경로명
						
						// 파일레벨
						if(i == 1) {
							// 대표이미지
							at.setFile_level(1);
						}
						else {
							// 상세이미지
							at.setFile_level(2);
						}
						
						list.add(at);
					}
					
				}
				
				// 4) Service 단으로 토스
				int result = new MemberService().insertMypetBoard(mp, list); // 강아지추가
				
				
				// 5) 결과에 따른 응답뷰 지정
				if(result > 0) { // 성공 => Mypet.me 로 요청 (sendRedirect)
					
					request.getSession().setAttribute("alertMsg", "성공적으로 업로드 되었습니다.");
					response.sendRedirect(request.getContextPath() + "/myPet.me");
				}
				else { // 실패 => 에러페이지
					
					request.getSession().setAttribute("alertMsg", "업로드 실패하셨습니다.");
					request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
				}
			}
		}
		else { // 실패 => 에러페이지
			
			request.getSession().setAttribute("alertMsg", "펫 추가에 실패했습니다.");
			request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
		}
		*/
		
		// 5) 결과에 따른 응답뷰 지정
		if(result0 > 0) { // 성공 => Mypet.me 로 요청 (sendRedirect)
			
			// request.getSession().setAttribute("alertMsg", "성공적으로 업로드 되었습니다.");
			// response.sendRedirect(request.getContextPath() + "/myPet.me");
			request.getRequestDispatcher("views/mypet/myPetEnroll.jsp").forward(request, response);  //*
		}
		
		else { // 실패 => 에러페이지
			
			request.getSession().setAttribute("alertMsg", "업로드 실패하셨습니다.");
			request.getRequestDispatcher("views/mypet/myPet.jsp").forward(request, response);
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
