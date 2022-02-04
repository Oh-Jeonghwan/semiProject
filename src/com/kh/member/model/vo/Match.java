package com.kh.member.model.vo;

import java.util.Date;

public class Match {
	
	private String matNo;
	private String boardNum;
	private String poNum;
	private String psNum;
	private String location;
	private String address;
	private Date requestdate;
	private Date careSdate;
	private Date careDdate;
	private String petNum;
	private String petType;
	private String isEnd;
	private String status;
	private int count;


	public Match() {
		super();
	}
	



	

	public int getCount() {
		return count;
	}






	public void setCount(int count) {
		this.count = count;
	}






	public Match(String location, int count) {
		super();
		this.location = location;
		this.count = count;
	}






	public Match(int count) {
		super();
		this.count = count;
	}






	public Match(String matNo, String boardNum, String poNum, String psNum, String location, String address,
			Date requestdate, Date careSdate, Date careDdate, String petNum, String petType, String isEnd,
			String status) {
		super();
		this.matNo = matNo;
		this.boardNum = boardNum;
		this.poNum = poNum;
		this.psNum = psNum;
		this.location = location;
		this.address = address;
		this.requestdate = requestdate;
		this.careSdate = careSdate;
		this.careDdate = careDdate;
		this.petNum = petNum;
		this.petType = petType;
		this.isEnd = isEnd;
		this.status = status;
	}






	public Match(String matNo, String boardNum, String psNum, String location, String address, Date requestdate,
			Date careSdate, Date careDdate, String petNum, String isEnd, String status) {
		this.matNo = matNo;
		this.boardNum = boardNum;
		this.psNum = psNum;
		this.location = location;
		this.address = address;
		this.requestdate = requestdate;
		this.careSdate = careSdate;
		this.careDdate = careDdate;
		this.petNum = petNum;
		this.isEnd = isEnd;
		this.status = status;
	}
	

	public Match(String matNo, String poNum, String psNum, String location, Date requestdate, Date careSdate,
			Date careDdate, String address, String petNum, String isEnd) {
		this.matNo = matNo;
		this.poNum = poNum;
		this.psNum = psNum;
		this.location = location;
		this.requestdate = requestdate;
		this.careSdate = careSdate;
		this.careDdate = careDdate;
		this.address = address;
		this.petNum = petNum;
		this.isEnd = isEnd;
	}
	
	public Match(String matNo, String poNum, String psNum, String location, String address, Date careSdate,
			Date careDdate, String petNum, String petType, String isEnd) {
		this.matNo = matNo;
		this.poNum = poNum;
		this.psNum = psNum;
		this.location = location;
		this.address = address;
		this.careSdate = careSdate;
		this.careDdate = careDdate;
		this.petType = petType;
		this.petNum = petNum;
		this.isEnd = isEnd;
	}
	
	
	
	

	


	

	public Match(String boardNum, String poNum, String psNum, String location, String address, Date careSdate,
			Date careDdate, String petNum) {
		super();
		this.boardNum = boardNum;
		this.poNum = poNum;
		this.psNum = psNum;
		this.location = location;
		this.address = address;
		this.careSdate = careSdate;
		this.careDdate = careDdate;
		this.petNum = petNum;
	}



	public String getPetType() {
		return petType;
	}


	public void setPetType(String petType) {
		this.petType = petType;
	}




	public String getMatNo() {
		return matNo;
	}
	public void setMatNo(String matNo) {
		this.matNo = matNo;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getPsNum() {
		return psNum;
	}
	public void setPsNum(String psNum) {
		this.psNum = psNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(Date requestdate) {
		this.requestdate = requestdate;
	}
	public Date getCareSdate() {
		return careSdate;
	}
	public void setCareSdate(Date careSdate) {
		this.careSdate = careSdate;
	}
	public Date getCareDdate() {
		return careDdate;
	}
	public void setCareDdate(Date careDdate) {
		this.careDdate = careDdate;
	}
	public String getPetNum() {
		return petNum;
	}
	public void setPetNum(String petNum) {
		this.petNum = petNum;
	}
	public String getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(String isEnd) {
		this.isEnd = isEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getPoNum() {
		return poNum;
	}


	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}






	@Override
	public String toString() {
		return "Match [matNo=" + matNo + ", boardNum=" + boardNum + ", psNum=" + psNum + ", poNum=" + poNum
				+ ", location=" + location + ", address=" + address + ", requestdate=" + requestdate + ", careSdate="
				+ careSdate + ", careDdate=" + careDdate + ", petNum=" + petNum + ", petType=" + petType + ", isEnd="
				+ isEnd + ", status=" + status + "]";
	}





	
	

}
