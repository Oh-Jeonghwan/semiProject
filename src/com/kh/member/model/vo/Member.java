package com.kh.member.model.vo;
import java.sql.Date;
public class Member {
    private String memNum;
    private String memId;
    private String memPwd;
    private String memName;
    private String idNum;
    private String email;
    private String phone;
    private String location;
    private String address;
    private String status;
    private int reportCnt;
    private String petsitterYN;
    private String myPetYN;
    private Date enrollDate;
    private Date updateDate;
    private int count;
    
    
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Member(String memNum, String memId, String memPwd, String memName, String idNum, String email, String phone,
            String location, String address, String status, int reportCnt, String petsitterYN, String myPetYN,
            Date enrollDate, Date updateDate) {
        super();
        this.memNum = memNum;
        this.memId = memId;
        this.memPwd = memPwd;
        this.memName = memName;
        this.idNum = idNum;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.address = address;
        this.status = status;
        this.reportCnt = reportCnt;
        this.petsitterYN = petsitterYN;
        this.myPetYN = myPetYN;
        this.enrollDate = enrollDate;
        this.updateDate = updateDate;
    }
    public Member( String memId, String memPwd, String memName, String idNum, String email, String phone,
            String location, String address) {
        super();
    
        this.memId = memId;
        this.memPwd = memPwd;
        this.memName = memName;
        this.idNum = idNum;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.address = address;
    
    }
    
    
    public Member(String memId, String memName, String idNum, String email, String phone, String location,
            String address) {
        super();
        this.memId = memId;
        this.memName = memName;
        this.idNum = idNum;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.address = address;
    }
    
    
    /*관리자모드 (정민0).*/
    
    public Member(String memNum, String memId, String memName, String memPwd, String idNum, String location,String address, String email,
            String myPetYN, String petsitterYN, Date enrollDate, String phone, int reportCnt) {
        super();
        this.memNum = memNum;
        this.memId = memId;
        this.memPwd = memPwd;
        this.memName = memName;
        this.idNum = idNum;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.address = address;
        this.reportCnt = reportCnt;
        this.petsitterYN = petsitterYN;
        this.myPetYN = myPetYN;
        this.enrollDate = enrollDate;
    }
    
    
    
    public Member(String memNum, String memId, String memName, String email, String phone) {
        super();
        this.memNum = memNum;
        this.memId = memId;
        this.memName = memName;
        this.email = email;
        this.phone = phone;
    }
    public Member(String location, int count) {
        super();
        this.location = location;
        this.count = count;
    }
    public String getMemNum() {
        return memNum;
    }
    public void setMemNum(String memNum) {
        this.memNum = memNum;
    }
    public String getMemId() {
        return memId;
    }
    public void setMemId(String memId) {
        this.memId = memId;
    }
    public String getMemPwd() {
        return memPwd;
    }
    public void setMemPwd(String memPwd) {
        this.memPwd = memPwd;
    }
    public String getMemName() {
        return memName;
    }
    public void setMemName(String memName) {
        this.memName = memName;
    }
    public String getIdNum() {
        return idNum;
    }
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getReportCnt() {
        return reportCnt;
    }
    public void setReportCnt(int reportCnt) {
        this.reportCnt = reportCnt;
    }
    public String getPetsitterYN() {
        return petsitterYN;
    }
    public void setPetsitterYN(String petsitterYN) {
        this.petsitterYN = petsitterYN;
    }
    public String getMyPetYN() {
        return myPetYN;
    }
    public void setMyPetYN(String myPetYN) {
        this.myPetYN = myPetYN;
    }
    public Date getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "Member [memNum=" + memNum + ", memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName
                + ", idNum=" + idNum + ", email=" + email + ", phone=" + phone + ", location=" + location + ", address="
                + address + ", status=" + status + ", reportCnt=" + reportCnt + ", petsitterYN=" + petsitterYN
                + ", myPetYN=" + myPetYN + ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + "]";
    }
    
    
    
    
    
}
