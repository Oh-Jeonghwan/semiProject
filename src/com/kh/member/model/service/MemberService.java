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
		
		// ????????? ?????? ????????? ?????? ??????????????? => ???????????? ????????? ????????????
		Member updateMem = null;
		
		if(result > 0) { // ??????
			
		commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, m.getMemId());
		}
		else { // ??????
			
		rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
			
	}

	
	
	public Member updatePwdMember(String memId, String memPwd, String updatePwd) {
		
		Connection conn = getConnection();
		
		// ???????????? update ?????? dao ???????????? ?????? ??????
		int result = new MemberDao().updatePwdMember(conn, memId, memPwd, updatePwd);
		
		// ?????? ????????? ????????? ???????????? commit ?????? ?????? ?????? ????????? ????????? ?????? ????????????.
		Member updateMem = null;
		
		if(result > 0) { // ??????
			commit(conn);
			
			// ????????? ?????? ????????? ?????? ????????????
			updateMem = new MemberDao().selectMember(conn, memId);
		}
		else { // ??????
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
		
		// ???????????? 1, ???????????? 0 ??????
		if(result > 0) { // ???????????????
		commit(conn);
			
			// selectpetOwner = new MemberDao().selectPetOwner(conn, m.getPoNum());
		
		}
		else { // ???????????????
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
		
		// 1) Connection ?????? ??????
		Connection conn = getConnection();
		
		// 2) Dao ??? ??????
		PetOwner po = new MemberDao().selectPetOwner(conn, memNum);
		
		// 3) Connection ?????? ??????
		close(conn);
		
		// 4) Controller ??? ?????? ?????????
		return po;
	}
	
    public int updateMypetY(String memNum) {
        // TODO Auto-generated method stub
        
        Connection conn = getConnection();
        
        // ???????????? update ?????? dao ???????????? ?????? ??????
        int result = new MemberDao().updateMypetY(conn, memNum);
        
        
        if(result > 0) { // ??????
            commit(conn);
            
        }
        else { // ??????
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