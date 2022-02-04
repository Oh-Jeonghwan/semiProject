package com.kh.common.model.vo;

import java.sql.Date;

public class Attachment {

	
	private String fileNo;
	private String refBno;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private int file_level;
	private String status;
	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attachment(String fileNo, String refBno, String originName, String changeName, String filePath,
			Date uploadDate, int file_level, String status) {
		super();
		this.fileNo = fileNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.file_level = file_level;
		this.status = status;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public String getRefBno() {
		return refBno;
	}
	public void setRefBno(String refBno) {
		this.refBno = refBno;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getFile_level() {
		return file_level;
	}
	public void setFile_level(int file_level) {
		this.file_level = file_level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refBno=" + refBno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", file_level=" + file_level
				+ ", status=" + status + "]";
	}
	
	
	
	
}
