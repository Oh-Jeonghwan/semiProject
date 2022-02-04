package com.kh.member.model.vo;
public class PetOwner {
	/*
	 * 	PO_NUM VARCHAR2(10) PRIMARY KEY,
	MEM_NUM VARCHAR2(10) NOT NULL,
    FOREIGN KEY(MEM_NUM) REFERENCES MEMBER(MEM_NUM)
	 */
	
	private String poNum;
	private String memNum;
	
	public PetOwner() {
		super();
	}
	public PetOwner(String poNum, String memNum) {
		super();
		this.poNum = poNum;
		this.memNum = memNum;
	}
	
	
	public String getPoNum() {
		return poNum;
	}
	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	@Override
	public String toString() {
		return "PetOwner [poNum=" + poNum + ", memNum=" + memNum + "]";
	}	
}