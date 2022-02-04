package com.kh.board.model.vo;

public class Board {

	
	private String boardNum;
	private String psNum;
	private String psExp;
	private String psPet;
	private String psKid;
	private String psSmoke;
	private int petCap;
	private int price;
	private String psTitle;
	private String psDesc;
	private String condition;
	private String status;
	private String writer;
	private String writerLocation;
	private String writerAddress;
	private String mainImg;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(String boardNum, String psNum, String psExp, String psPet, String psKid, String psSmoke, int petCap,
			int price, String psTitle, String psDesc, String condition, String status) {
		super();
		this.boardNum = boardNum;
		this.psNum = psNum;
		this.psExp = psExp;
		this.psPet = psPet;
		this.psKid = psKid;
		this.psSmoke = psSmoke;
		this.petCap = petCap;
		this.price = price;
		this.psTitle = psTitle;
		this.psDesc = psDesc;
		this.condition = condition;
		this.status = status;
	}
	

	public Board( String psNum, String psExp, String psPet, String psKid, String psSmoke, int petCap,
			int price, String psTitle, String psDesc, String condition) {
		super();
	
		this.psNum = psNum;
		this.psExp = psExp;
		this.psPet = psPet;
		this.psKid = psKid;
		this.psSmoke = psSmoke;
		this.petCap = petCap;
		this.price = price;
		this.psTitle = psTitle;
		this.psDesc = psDesc;
		this.condition = condition;
		
	
	}
	
	public Board(String boardNum, String psNum, String psExp, String psPet, String psKid, String psSmoke, int petCap,
			int price, String psTitle, String psDesc, String condition,String status, String writer, String writerLocation, String writerAddress, String mainImg) {
		super();
		this.boardNum = boardNum;
		this.psNum = psNum;
		this.psExp = psExp;
		this.psPet = psPet;
		this.psKid = psKid;
		this.psSmoke = psSmoke;
		this.petCap = petCap;
		this.price = price;
		this.psTitle = psTitle;
		this.psDesc = psDesc;
		this.condition = condition;
		this.status = status;
		this.writer = writer;
		this.writerLocation = writerLocation;
		this.writerAddress = writerAddress;
		this.mainImg = mainImg;
	
	}

	public Board(String boardNum, String psNum, String psExp, String psPet, String psKid, String psSmoke, int petCap,
			int price, String psTitle, String psDesc, String condition,String status, String writer, String writerLocation, String writerAddress) {
		super();
		this.boardNum = boardNum;
		this.psNum = psNum;
		this.psExp = psExp;
		this.psPet = psPet;
		this.psKid = psKid;
		this.psSmoke = psSmoke;
		this.petCap = petCap;
		this.price = price;
		this.psTitle = psTitle;
		this.psDesc = psDesc;
		this.condition = condition;
		this.status = status;
		this.writer = writer;
		this.writerLocation = writerLocation;
		this.writerAddress = writerAddress;
	
	
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

	public String getPsExp() {
		return psExp;
	}

	public void setPsExp(String psExp) {
		this.psExp = psExp;
	}

	public String getPsPet() {
		return psPet;
	}

	public void setPsPet(String psPet) {
		this.psPet = psPet;
	}

	public String getPsKid() {
		return psKid;
	}

	public void setPsKid(String psKid) {
		this.psKid = psKid;
	}

	public String getPsSmoke() {
		return psSmoke;
	}

	public void setPsSmoke(String psSmoke) {
		this.psSmoke = psSmoke;
	}

	public int getPetCap() {
		return petCap;
	}

	public void setPetCap(int petCap) {
		this.petCap = petCap;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPsTitle() {
		return psTitle;
	}

	public void setPsTitle(String psTitle) {
		this.psTitle = psTitle;
	}

	public String getPsDesc() {
		return psDesc;
	}

	public void setPsDesc(String psDesc) {
		this.psDesc = psDesc;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriterLocation() {
		return writerLocation;
	}

	public void setWriterLocation(String writerLocation) {
		this.writerLocation = writerLocation;
	}
	
	
	

	public String getWriterAddress() {
		return writerAddress;
	}

	public void setWriterAddress(String writerAddress) {
		this.writerAddress = writerAddress;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", psNum=" + psNum + ", psExp=" + psExp + ", psPet=" + psPet + ", psKid="
				+ psKid + ", psSmoke=" + psSmoke + ", petCap=" + petCap + ", price=" + price + ", psTitle=" + psTitle
				+ ", psDesc=" + psDesc + ", condition=" + condition + ", status=" + status + ", writer=" + writer
				+ ", writerLocation=" + writerLocation + ", writerAddress=" + writerAddress + ", mainImg=" + mainImg
				+ "]";
	}



	
	
	
	
}
