package com.kh.member.model.vo;
import java.sql.Date;
public class Report {
	
	private String repNum;
	private String repWriter;
	private String repMem;
	private Date repDate;
	private String repContent;
	private String status;
	
	public Report() {
		super();
	}
	
	
	public Report(String repNum, String repWriter, String repMem, Date repDate, String repContent, String status) {
		super();
		this.repNum = repNum;
		this.repWriter = repWriter;
		this.repMem = repMem;
		this.repDate = repDate;
		this.repContent = repContent;
		this.status = status;
	}
	
	public Report(String repNum, String repWriter, String repMem, String repContent,Date repDate) {
		super();
		this.repNum = repNum;
		this.repWriter = repWriter;
		this.repMem = repMem;
		this.repContent = repContent;
		this.repDate = repDate;
	}
	
	
	public Report(String repWriter, String repMem, String repContent) {
		super();
		this.repWriter = repWriter;
		this.repMem = repMem;
		this.repContent = repContent;
	}


	public String getRepNum() {
		return repNum;
	}
	public void setRepNum(String repNo) {
		this.repNum = repNo;
	}
	public String getRepWriter() {
		return repWriter;
	}
	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}
	public String getRepMem() {
		return repMem;
	}
	public void setRepMem(String repMem) {
		this.repMem = repMem;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	public String getRepContent() {
		return repContent;
	}
	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Report [repNum=" + repNum + ", repWriter=" + repWriter + ", repMem=" + repMem + ", repDate=" + repDate
				+ ", repContent=" + repContent + ", status=" + status + "]";
	}
	
	
}