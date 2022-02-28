package com.kh.notice.model.vo;

import java.sql.Date;

public class NoticeSearch extends Notice {
	
	private String noStartDate;//	String noStartDate = (String)request.getAttribute("noStartDate");
	private String noEndDate;//	String noEndDate = (String)request.getAttribute("noEndDate");
	private String keyword;//	String keyword = (String)request.getAttribute("keyword");
	
	public NoticeSearch() {
		super();
	}

	public NoticeSearch(String noticeNum, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
			int noticeViewer, String status, String noStartDate, String noEndDate, String keyword) {
		super(noticeNum, noticeTitle, noticeDate, noticeWriter, noticeContent, noticeViewer, status);
		this.noStartDate = noStartDate;
		this.noEndDate = noEndDate;
		this.keyword = keyword;
	}
	
	

	public NoticeSearch(String noticeNum, String noticeTitle, Date noticeDate, String noticeWriter,
			String noticeContent, int noticeViewer) {
		super(noticeNum, noticeTitle, noticeDate, noticeWriter, noticeContent, noticeViewer);
	}

	public String getNoStartDate() {
		return noStartDate;
	}

	public void setNoStartDate(String noStartDate) {
		this.noStartDate = noStartDate;
	}

	public String getNoEndDate() {
		return noEndDate;
	}

	public void setNoEndDate(String noEndDate) {
		this.noEndDate = noEndDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "NotcieSearch [noStartDate=" + noStartDate + ", noEndDate=" + noEndDate + ", keyword=" + keyword + "]";
	}
	
	
}
