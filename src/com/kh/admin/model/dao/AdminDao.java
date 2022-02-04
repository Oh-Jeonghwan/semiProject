package com.kh.admin.model.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.vo.Report;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.Petsitter;
public class AdminDao {
    
    
    private Properties prop = new Properties();
    
    public AdminDao() {
        String fileName = AdminDao.class.getResource("/sql/member/member-mapper.xml").getPath();
    
        try {
            prop.loadFromXML(new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
public int AdminUserSelectListCount(Connection conn) {
        
        int count = 0;
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("AdminUserSelectListCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
        
            while(rset.next()) {
            count = rset.getInt("COUNT");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return count;
    }
    public ArrayList<Member> adminUserSelect(Connection conn,PageInfo pi) {
        
        
        ArrayList<Member> list = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql =prop.getProperty("adminUserSelect");
        
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() +1;
            int endRow = startRow + pi.getBoardLimit() -1;
            
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);
            
            rset = pstmt.executeQuery();
            
            
            
            while(rset.next()) {
                
                Member m = new Member(rset.getString("MEM_NUM"),
                                      rset.getString("MEM_ID"),
                                      rset.getString("MEM_NAME"),
                                      rset.getString("MEM_PWD"),
                                      rset.getString("ID_NUM"),
                                      rset.getString("LOCATION"),
                                      rset.getString("ADDRESS"),
                                      rset.getString("EMAIL"),
                                      rset.getString("MYPET_YN"),
                                      rset.getString("PETSITTER_YN"),
                                      rset.getDate("ENROLL_DATE"),
                                      rset.getString("PHONE"),
                                      rset.getInt("REPORT_CNT"));
                
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
        
    
    }
    public ArrayList<Member> adminBlackListUserSelect(Connection conn) {
        
        ArrayList<Member> blist = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("adminBlackListUserSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member b = new Member(rset.getString("MEM_NUM"),
                          rset.getString("MEM_ID"),
                          rset.getString("MEM_NAME"),
                          rset.getString("MEM_PWD"),
                          rset.getString("ID_NUM"),
                          rset.getString("LOCATION"),
                          rset.getString("ADDRESS"),
                          rset.getString("EMAIL"),
                          rset.getString("MYPET_YN"),
                          rset.getString("PETSITTER_YN"),
                          rset.getDate("ENROLL_DATE"),
                          rset.getString("PHONE"),
                          rset.getInt("REPORT_CNT"));
                
                
                blist.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return blist;
        
    }
    public ArrayList<Report> adminReportSelect(Connection conn) {
        
        ArrayList<Report> rList = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("adminReportSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Report r = new Report(rset.getString("REPORT_NUM") ,
                                      rset.getString("WRI"),
                                      rset.getString("MEM"), 
                                      rset.getString("REPORT_CONTENT"),
                                      rset.getDate("REPORT_DATE"));
                
                rList.add(r);
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return rList;
        
    }
    public int adminDeleteUser(Connection conn, String memNum) {
        
        int result = 0;
        
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("adminDeleteUser");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, memNum);
            
            result = pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
        
        
    }
    public int adminRestoreUser(Connection conn, String memNum) {
        
        int result = 0;
        
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("adminRestoreUser");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, memNum);
            
            result = pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
        
        
    }
    public ArrayList<Match> staticSelect(Connection conn) {
    
        ArrayList<Match> list = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("staticSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Match m  = new Match(rset.getInt("COUNT"));
                                        
                list.add(m);
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return list;
    
    
    }
    
    
    //지역 별 매칭 수
    
    public ArrayList<Match> astaticSelect(Connection conn) {
        
        ArrayList<Match> alist = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("astaticSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                
                Match m  = new Match(rset.getString("LOCATION") ,
                                    rset.getInt("COUNT")
                        );
                                        
                alist.add(m);
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return alist;
    
    
    }
    public ArrayList<Match> monthStaticSelect(Connection conn) {
        
        ArrayList<Match> monthList = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("monthStaticSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Match m = new Match(rset.getString("MONTH") , 
                                    rset.getInt("COUNT"));
                
                monthList.add(m);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return monthList;
    }
    public ArrayList<Member> adminSearch(Connection conn, String keyword) {
    
        ArrayList<Member> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("adminSearch");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,keyword);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member m = new Member(rset.getString("MEM_NUM") ,
                          rset.getString("MEM_ID"),
                          rset.getString("MEM_NAME"),
                          rset.getString("MEM_PWD"),
                          rset.getString("ID_NUM"),
                          rset.getString("LOCATION"),
                          rset.getString("ADDRESS"),
                          rset.getString("EMAIL"),
                          rset.getString("MYPET_YN"),
                          rset.getString("PETSITTER_YN"),
                          rset.getDate("ENROLL_DATE"),
                          rset.getString("PHONE"),
                          rset.getInt("REPORT_CNT")
                                    );
                
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return list;
        
        
        
    }
    public ArrayList<Member> memberStaticSelect(Connection conn) {
    
        ArrayList<Member> memberList = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("memberStaticSelect");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Member m = new Member(rset.getString("LOCATION") , 
                                    rset.getInt("COUNT"));
                
                memberList.add(m);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return memberList;
    }
    public ArrayList<Mypet> petList(Connection conn) {
        
        ArrayList<Mypet> petList = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("petList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) 
            {
                Mypet m = new Mypet(rset.getString("PET_TYPE"),
                                    rset.getInt("COUNT"));
                
                petList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return petList;
        
        
    }
    public ArrayList<Petsitter> petsitterList(Connection conn) {
        
        
        ArrayList<Petsitter> petsitterList = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        
        ResultSet rset = null;
        
        String sql = prop.getProperty("petsitterList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rset = pstmt.executeQuery();
            
            while(rset.next()) 
            {
                Petsitter p = new Petsitter(
                                            rset.getInt("COUNT"));
                
                petsitterList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return petsitterList;
         
    }
    
    
    
    
    
}