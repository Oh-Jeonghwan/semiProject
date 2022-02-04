package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {
	private String noticeNum;//NOTICE_NUM VARCHAR2(10) PRIMARY KEY,
	private String noticeTitle;//NOTICE_TITLE VARCHAR2(50),
	private Date noticeDate;//NOTICE_DATE DATE DEFAULT SYSDATE,
	private String noticeWriter;//NOTICE_WRITER	VARCHAR2(10) NOT NULL,
	private String noticeContent;//NOTICE_CONTENT VARCHAR2(500),
	private int noticeViewer;//NOTICE_VIEWER NUMBER,
	private String status;//STATUS VARCHAR2(2)DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
	
	public Notice() {
		super();
	}
	
	public Notice(String noticeNum, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
			int noticeViewer, String status) {
		super();
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeViewer = noticeViewer;
		this.status = status;
	}

	public Notice(String noticeNum, String noticeTitle, Date noticeDate, String noticeWriter, String noticeContent,
			int noticeViewer) {
		super();
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeViewer = noticeViewer;
	}

	public Notice(String noticeNum, String noticeTitle, String noticeWriter, Date noticeDate,  String noticeContent) {
		super();
		this.noticeNum = noticeNum;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
	}

	public String getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(String noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeViewer() {
		return noticeViewer;
	}

	public void setNoticeViewer(int noticeViewer) {
		this.noticeViewer = noticeViewer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeWriter=" + noticeWriter + ", noticeContent=" + noticeContent + ", noticeViewer="
				+ noticeViewer + ", status=" + status + "]";
	}
	
	
	
}