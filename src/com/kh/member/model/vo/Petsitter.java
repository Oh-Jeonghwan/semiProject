package com.kh.member.model.vo;
public class Petsitter {
    private String psNum;
    private String memNum;
    private int count;
    
    
    
    
    
    
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Petsitter(int count) {
        super();
        this.count = count;
    }
    public Petsitter() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Petsitter(String psNum, String memNum) {
        super();
        this.psNum = psNum;
        this.memNum = memNum;
    }
    public String getPsNum() {
        return psNum;
    }
    public void setPsNum(String psNum) {
        this.psNum = psNum;
    }
    public String getMemNum() {
        return memNum;
    }
    public void setMemNum(String memNum) {
        this.memNum = memNum;
    }
    @Override
    public String toString() {
        return "Petsitter [psNum=" + psNum + ", memNum=" + memNum + "]";
    }
    
    
    
    
}
