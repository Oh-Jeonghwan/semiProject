package com.kh.member.model.vo;
public class Mypet {
    
    private String petNum; //PET_NUM VARCHAR2(10) PRIMARY KEY,
    private String petName;//PET_NAME VARCHAR2(20),
    private String petGender;//PET_GENDER VARCHAR2(2),
    private String petType; //PET_TYPE VARCHAR2(30),
    private String petBirth; //PET_BIRTH NUMBER,
    private String petWeight; //PET_WEIGHT NUMBER,
    private String petDec; // PET_DEC VARCHAR2(200),
    private String poNum; //PO_NUM VARCHAR2(10) NOT NULL,
    private String status; // STATUS VARCHAR2(2)    DEFAULT 'Y' CHECK (STATUS IN('Y', 'N')),
    private String titleImg;
    private int count;
    
   
    public Mypet(String petType, int count) {
        super();
        this.petType = petType;
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Mypet(String petNum, String petName, String petGender, String petType, String petBirth, String petWeight,
            String petDec, String poNum, String status, String titleImg) {
        super();
        this.petNum = petNum;
        this.petName = petName;
        this.petGender = petGender;
        this.petType = petType;
        this.petBirth = petBirth;
        this.petWeight = petWeight;
        this.petDec = petDec;
        this.poNum = poNum;
        this.status = status;
        this.titleImg = titleImg;
    }
    
    public Mypet(int count) {
        super();
        this.count = count;
    }
    
    
    public Mypet() {
        super();
    }
    public Mypet(String petNum, String petName, String petGender, String petType, String petBirth, String petWeight, String petDec,
            String poNum, String titleImg) {
        super();
        this.petNum = petNum;
        this.petName = petName;
        this.petGender = petGender;
        this.petType = petType;
        this.petBirth = petBirth;
        this.petWeight = petWeight;
        this.petDec = petDec;
        this.poNum = poNum;
        this.titleImg = titleImg;
    }
    public String getPetNum() {
        return petNum;
    }
    public void setPetNum(String petNum) {
        this.petNum = petNum;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getPetGender() {
        return petGender;
    }
    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }
    public String getPetType() {
        return petType;
    }
    public void setPetType(String petType) {
        this.petType = petType;
    }
    public String getPetBirth() {
        return petBirth;
    }
    public void setPetBirth(String petBirth) {
        this.petBirth = petBirth;
    }
    public String getPetWeight() {
        return petWeight;
    }
    public void setPetWeight(String petWeight) {
        this.petWeight = petWeight;
    }
    public String getPetDec() {
        return petDec;
    }
    public void setPetDec(String petDec) {
        this.petDec = petDec;
    }
    public String getPoNum() {
        return poNum;
    }
    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTitleImg() {
        return titleImg;
    }
    public void setTitleImg(String titleImg) {
        this.titleImg = titleImg;
    }
    @Override
    public String toString() {
        return "Mypet [petNum=" + petNum + ", petName=" + petName + ", petGender=" + petGender + ", petType=" + petType
                + ", petBirth=" + petBirth + ", petWeight=" + petWeight + ", petDec=" + petDec + ", poNum=" + poNum
                + ", status=" + status + ", titleImg=" + titleImg + "]";
    }
}