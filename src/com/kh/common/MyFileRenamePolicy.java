package com.kh.common;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;



public class MyFileRenamePolicy implements FileRenamePolicy {
	

	@Override
	public File rename(File originalFile) {
		// 원본파일명 뽑기 => 매개변수 전달받은 원본 파일로부터 (File 객체의 getName());
		String originalName = originalFile.getName();
		
		// 수정파일명 만들기(규칙)
		// 파일이 업로드 된 시간(년월시분초) + 5자리 랜덤값(10000~99999)
		// 확장자	: 원본파일 확장자 그대로 (원본파일명에서 뽑아낼것)
		
			/*
			 * ex) aaa.jpg => 20211126164850xxxxx.jpg
			 */
		
		//1) 파일이 업로드된 시간 추출 => String currentTime;
		// api시간에 배웠던 SimpleDataFormat 활용
		
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 2. 5자리 랜덤 => int ranNum;
		// (0 ~ 0.999) * 90000
		// (0 ~ 899999.99) + 10000
		// 1 ~ 90000
		int ranNum = (int)(Math.random() * 90000) + 10000;
		
		// 3. 확장자 뽑기
		// String의 lastIndexOf(찾고자하는 문자열) 메소드
		// . 부분으로 인덱스 알아내야함.
		 int index =  originalName.lastIndexOf(".");
		String ext = originalName.substring(index); // .jpb로 뽑아냄 (. 포함!!!!)
		
		// 4. 합쳐서 바뀐이름 생성
		
		String changedName = currentTime + ranNum + ext;
		
		// 5. 파일객체로 파일만들기
		

		return  new File(originalFile.getParent(), changedName);
	}
	

}
