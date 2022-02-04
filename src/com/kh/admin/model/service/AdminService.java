package com.kh.admin.model.service;
import java.sql.Connection;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;
import com.kh.admin.model.dao.AdminDao;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Report;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.Petsitter;
public class AdminService {
    
    public int AdminUserSelectListCount() {
        
        Connection conn = getConnection();
        
        int count = new AdminDao().AdminUserSelectListCount(conn);
        
        close(conn);
        
        return count;
        
        
    }
    public ArrayList<Member> adminUserSelect(PageInfo pi) {
        
        Connection conn = getConnection();
        ArrayList<Member> list = new AdminDao().adminUserSelect(conn,pi);
        
        close(conn);
        
        return list;
    }
    public ArrayList<Member> adminBlackListUserSelect() {
    
        Connection conn = getConnection();
        ArrayList<Member> blist = new AdminDao().adminBlackListUserSelect(conn);
        
        close(conn);
        
        return  blist;
    }
    public ArrayList<Report> adminReportSelect() {
    
        Connection conn = getConnection();
        
        ArrayList<Report> rList = new AdminDao().adminReportSelect(conn);
        
        close(conn);
        
        return rList;
    }
    public int adminDeleteUser(String memNum) {
        
        Connection conn = getConnection();
        
        int result = new AdminDao().adminDeleteUser(conn, memNum);
        
        if(result > 0) {
            commit(conn);
        }
        else {
            rollback(conn);
        }
        close(conn);
        
        return result;
        
        
    }
    public int adminRestoreUser(String memNum) {
        
    Connection conn = getConnection();
        
        int result = new AdminDao().adminRestoreUser(conn, memNum);
        
        if(result > 0) {
            commit(conn);
        }
        else {
            rollback(conn);
        }
        close(conn);
        
        return result;
        
    }
    public ArrayList<Match> staticSelect() {
    
        
        Connection conn = getConnection();
        
        ArrayList<Match> list = new AdminDao().staticSelect(conn);
        
        close(conn);
        
        return list;
    }
    
    //지역별 매칭 수 
public ArrayList<Match> astaticSelect() {
    
        
        Connection conn = getConnection();
        
        ArrayList<Match> alist = new AdminDao().astaticSelect(conn);
        
        close(conn);
        
        return alist;
    }
public ArrayList<Match> monthStaticSelect() {
    
    Connection conn = getConnection();
    
    ArrayList<Match> monthList = new AdminDao().monthStaticSelect(conn);
    
    close(conn);
    
    return monthList;
}
public ArrayList<Member> adminSearch(String keyword) {
    
    Connection conn  = getConnection();
    
    ArrayList<Member> list = new AdminDao().adminSearch(conn,keyword);
    
    close(conn);
    
    return list;
    
    
}
public ArrayList<Member> memberStaticSelect() {
    
    Connection conn = getConnection();
    
    ArrayList<Member> memberList = new AdminDao().memberStaticSelect(conn);
    
    close(conn);
    
    return memberList;
    
    
}
public ArrayList<Mypet> petList() {
    
    Connection conn = getConnection();
    
    ArrayList<Mypet> petList = new AdminDao().petList(conn);
    
    close(conn);
    
    return petList;
}
public ArrayList<Petsitter> petsitterList() {
    
    Connection conn = getConnection();
    
    ArrayList<Petsitter> petsitterList = new AdminDao().petsitterList(conn);
    
    close(conn);
    
    return petsitterList;
}
    
    
}