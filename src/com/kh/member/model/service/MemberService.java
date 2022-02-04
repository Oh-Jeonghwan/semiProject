package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Attachment;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;
import com.kh.member.model.vo.Petsitter;
import com.kh.member.model.vo.Report;

public class MemberService {
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
	}

	public int insertMatching(Match ma) {
	Connection conn = getConnection();
		
		int result = new MemberDao().insertMatching(conn, ma);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Petsitter selectPetsitter(String memNum) {
		Connection conn = getConnection();
		Petsitter pe = new MemberDao().selectPetsitter(conn, memNum);
		
		close(conn);
		
		return pe;
	}

	public int insertPetsitter(String memNum) {
		
		Connection conn = getConnection();
		
		int result1 = new MemberDao().insertPetsitter(conn, memNum);
		int result2 = 1;
		if(result1 > 0) {
			
			result2 = new MemberDao().updateMemberPetsitter(conn, memNum);
		}
		
		if(result1 * result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}

	public ArrayList<Mypet> selectMyPetMatchList(String poNum) {
		Connection conn = getConnection();
		ArrayList<Mypet> list =	new MemberDao().selectMyPetMatchList(conn,poNum);
		close(conn);
		return list;
	}

	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		// 갱신된 회원 객체를 다시 조회해오기 => 업데이트 성공한 경우에만
		Member updateMem = null;
		
		if(result > 0) { // 성공
			
		commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, m.getMemId());
		}
		else { // 실패
			
		rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
			
	}

	
	
	public Member updatePwdMember(String memId, String memPwd, String updatePwd) {
		
		Connection conn = getConnection();
		
		// 비밀번호 update 관련 dao 메소드를 먼저 호출
		int result = new MemberDao().updatePwdMember(conn, memId, memPwd, updatePwd);
		
		// 호출 결과에 따라서 성공이면 commit 후에 새로 바뀐 회원의 정보를 다시 받아온다.
		Member updateMem = null;
		
		if(result > 0) { // 성공
			commit(conn);
			
			// 갱신된 회원 객체를 다시 받아오기
			updateMem = new MemberDao().selectMember(conn, memId);
		}
		else { // 실패
			rollback(conn);
		}
		
	close(conn);
		
		return updateMem;
	}
	
	public int insertMypetBoard(Mypet mp, ArrayList<Attachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new MemberDao().insertMypetBoard(conn, mp);
		
		int result2 = new MemberDao().insertAttachmentList(conn, list);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
	}
	
	public int insertPetOwner(String memNum) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertPetOwner(conn, memNum);
		
		// PetOwner selectpetOwner = null;
		
		// 성공하면 1, 실패하면 0 리턴
		if(result > 0) { // 성공했다면
		commit(conn);
			
			// selectpetOwner = new MemberDao().selectPetOwner(conn, m.getPoNum());
		
		}
		else { // 실패했다면
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Mypet> selectMypetList(String memNum) {
		
		Connection conn = getConnection();
		
		ArrayList<Mypet> list = new MemberDao().selectMypetList(conn, memNum);
		
		close(conn);
		
		return list;
	}

	public PetOwner selectPetOwner(String memNum) {
		// TODO Auto-generated method stub
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Dao 에 요청
		PetOwner po = new MemberDao().selectPetOwner(conn, memNum);
		
		// 3) Connection 객체 반납
		close(conn);
		
		// 4) Controller 로 결과 넘기기
		return po;
	}
	
    public int updateMypetY(String memNum) {
        // TODO Auto-generated method stub
        
        Connection conn = getConnection();
        
        // 비밀번호 update 관련 dao 메소드를 먼저 호출
        int result = new MemberDao().updateMypetY(conn, memNum);
        
        
        if(result > 0) { // 성공
            commit(conn);
            
        }
        else { // 실패
            rollback(conn);
        }
        
        close(conn);
        
        return result;
    }
    
	public ArrayList<Mypet> selectMypet(String petNum) {
		
		Connection conn = getConnection();
		
		ArrayList<Mypet> list2 = new MemberDao().selectMypet(conn, petNum);
		
		close(conn);
		
		return list2;
	}
	
	public int deleteMypet(String petNum) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMypet(conn, petNum);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Member selectMember(String memId) {
		Connection conn = getConnection();
		Member m = new MemberDao().selectMember(conn,memId);
		
		close(conn);
		
		return m;
	}

	public Mypet selectMyPetImg(String petNum) {
		
		Connection conn = getConnection();
		
		Mypet pet = new MemberDao().selectMyPetImg(conn, petNum);
		
		close(conn);
		
		return pet;
		
		
	}

	public PetOwner changeMemNumPoNum(String reviewWriter) {
		Connection conn = getConnection();
		PetOwner po = new MemberDao().changeMemNumPoNum(conn, reviewWriter);
		
		close(conn);
		
		return po;
	}

	public int insertReport(Report rep) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertReport(conn, rep);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int updateReportCnt(String repMem) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateReportCnt(conn, repMem);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public int idCheck(String checkId) {
		
		
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn,checkId);
	
		close(conn);
		
		return count;
	}
	
	public Member selectJoinMem(String memId) {
		
		Connection conn = getConnection();
		
		Member joinMem = new MemberDao().selectJoinMem(conn, memId);
		
		close(conn);
		
		return joinMem;
	}

	public Member changeMemIdMemNum(String memId) {
		
		Connection conn = getConnection();
		
		Member petowner = new MemberDao().changeMemIdMemNum(conn, memId);
		
		close(conn);
		
		return petowner;
	}
	public ArrayList<Mypet> selectPetsitterPetList(String psNum) {
		Connection conn = getConnection();
		ArrayList<Mypet> list =	new MemberDao().selectPetsitterPetList(conn,psNum);
		close(conn);
		return list;
	}
	
}