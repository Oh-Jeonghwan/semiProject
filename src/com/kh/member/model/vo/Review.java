package com.kh.member.model.vo;

import java.sql.Date;

public class Review {
	
	private String reviewNum;
	private String reviewWriter;
	private String boardNum;
	private Date reviewDate;
	private String reviewContent;
	private String writerName;
	private String status;
	
	public Review(String reviewNum, String reviewWriter, String boardNum, Date reviewDate, String reviewContent,
			String status) {
		super();
		this.reviewNum = reviewNum;
		this.reviewWriter = reviewWriter;
		this.boardNum = boardNum;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.status = status;
	}
	
	public Review(String reviewNum, String reviewWriter, String boardNum, Date reviewDate, String reviewContent,
		String writerName,	String status) {
		super();
		this.reviewNum = reviewNum;
		this.reviewWriter = reviewWriter;
		this.boardNum = boardNum;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.writerName = 	writerName;
		this.status = status;
	}
	
	

	public Review(String reviewWriter, String boardNum, String reviewContent) {
		super();
		this.reviewWriter = reviewWriter;
		this.boardNum = boardNum;
		this.reviewContent = reviewContent;
	}

	public Review() {
		super();
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", reviewWriter=" + reviewWriter + ", boardNum=" + boardNum
				+ ", reviewDate=" + reviewDate + ", reviewContent=" + reviewContent + ", writerName=" + writerName
				+ ", status=" + status + "]";
	}

	

	
	
}
