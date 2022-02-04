package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.model.vo.Attachment;
import com.kh.member.model.vo.Match;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.Mypet;
import com.kh.member.model.vo.PetOwner;
import com.kh.member.model.vo.Petsitter;
import com.kh.member.model.vo.Report;

public class MemberDao {
	
	
	private Properties prop = new Properties();
	
	public  MemberDao() {
		
	
		try {
			String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
			
	}
			
	

	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");
	
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPwd());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getIdNum());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getLocation());
			pstmt.setString(8, m.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}



	public Member loginMember(Connection conn, String userId, String userPwd) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
	
		Member m = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			
			rset = pstmt.executeQuery();
		

			if(rset.next()) {
			
				
				 m = new Member( 	rset.getString("MEM_NUM")
									,	rset.getString("MEM_ID")
									,	rset.getString("MEM_PWD")
									,	rset.getString("MEM_NAME")
									,	rset.getString("ID_NUM")
									,	rset.getString("EMAIL")
									,	rset.getString("PHONE")
									,	rset.getString("LOCATION")
									,	rset.getString("ADDRESS")
									,	rset.getString("STATUS")
									,	rset.getInt("REPORT_CNT")
									,	rset.getString("PETSITTER_YN")
									,	rset.getString("MYPET_YN")
									,	rset.getDate("ENROLL_DATE")
									,	rset.getDate("UPDATE_DATE")
									);
									
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return m;
	}



	public int insertMatching(Connection conn, Match ma) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMatching");
		System.out.println("sql insertMatch dao:"+ sql);
	//(bno, psNum, poNum, location, address, careSdate, careDdate ,  petNum);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ma.getBoardNum());
			pstmt.setString(2, ma.getPsNum());
			pstmt.setString(3, ma.getPetNum());
			pstmt.setString(4, ma.getLocation());
			pstmt.setString(5, ma.getAddress());
			pstmt.setDate(6, (Date) ma.getCareSdate());
			pstmt.setDate(7, (Date) ma.getCareDdate());
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}



	public Petsitter selectPetsitter(Connection conn, String memNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPetsitter");
		
		Petsitter pe = null;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNum);
		

			rset = pstmt.executeQuery();
		
			
			if(rset.next()) {
			
				
				pe = new Petsitter( 	rset.getString("PS_NUM")
									,	rset.getString("MEM_NUM")
							
									);
									
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return pe;
	}



	public int insertPetsitter(Connection conn, String memNum) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPetsitter");
	
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNum);
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public ArrayList<Mypet> selectMyPetMatchList(Connection conn, String psNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyPetMatchList");
	
		
		ArrayList<Mypet> list = new ArrayList<Mypet>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, psNum);
			rset = pstmt.executeQuery();
			
		

			while(rset.next()) {
			
			
				Mypet p = new Mypet( rset.getString("PET_NUM")
									, rset.getString("PET_NAME")
									, rset.getString("PET_GENDER")
									, rset.getString("PET_TYPE")
									, rset.getString("PET_BIRTH")
									, rset.getString("PET_WEIGHT")
									, rset.getString("PET_DEC")
									, rset.getString("PO_NUM")
									, rset.getString("STATUS")
									, rset.getString("MAINIMG")
									
								);
									
				
				list.add(p);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return list;
	}

	
	public int updateMember(Connection conn, Member m) {
		// UPDATE 문 => 처리된 행의 갯수
		
		// 필요한 변수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemName());
			pstmt.setString(2, m.getIdNum());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getLocation());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getMemId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	public Member selectMember(Connection conn, String memId) {
		
		// SELECT 문 => ResultSet 형태로 결과 반환 => Member
		// 필요한 변수
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				m = new Member( 	rset.getString("MEM_NUM")
						,	rset.getString("MEM_ID")
						,	rset.getString("MEM_PWD")
						,	rset.getString("MEM_NAME")
						,	rset.getString("ID_NUM")
						,	rset.getString("EMAIL")
						,	rset.getString("PHONE")
						,	rset.getString("LOCATION")
						,	rset.getString("ADDRESS")
						,	rset.getString("STATUS")
						,	rset.getInt("REPORT_CNT")
						,	rset.getString("PETSITTER_YN")
						,	rset.getString("MYPET_YN")
						,	rset.getDate("ENROLL_DATE")
						,	rset.getDate("UPDATE_DATE")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}

		
		return m;
	}

	public int updatePwdMember(Connection conn, String memId, String memPwd, String updatePwd) {
		
		// UPDATE 문 => 처리된 행의 갯수
		// 필요한 변수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, memId);
			pstmt.setString(3, memPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertMypetBoard(Connection conn, Mypet mp) {
		
		// INSERT => 처리된 행의 갯수
		// 변수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMypetBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mp.getPetName());
			pstmt.setString(2, mp.getPetGender());
			pstmt.setString(3, mp.getPetType());
			pstmt.setString(4, mp.getPetBirth());
			pstmt.setString(5, mp.getPetWeight());
			pstmt.setString(6, mp.getPetDec());
			pstmt.setString(7, mp.getPoNum());
			
			
			
			// pstmt.setInt(3, Integer.parseInt(b.getBoardWriter()));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachmentList(Connection conn, ArrayList<Attachment> list) {
		
		// INSERT => 처리된 행의 갯수
		// 변수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAttachmentList");
		
		// 반복적으로 리스트에 접근해서 한개씩 INSERT 
		try {
			for(Attachment at : list) {
				// 반복문이 돌 때 마다 미완성된  SQL 문을 담은 pstmt 객체 생성
				pstmt = conn.prepareStatement(sql);
				
				// 완성형태로 만들기 => at 로 부터 뽑아오기
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFile_level());
				
				// 실행
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int insertPetOwner(Connection conn, String memNum) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPetOwner");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}


	public ArrayList<Mypet> selectMypetList(Connection conn, String memNum) {
		
		// SELECT => ResultSet => 여러행 (while, ArrayList)
		// 변수
		ArrayList<Mypet> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMypetList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNum);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				Mypet mp = new Mypet();
				
				mp.setPetName(rset.getString("PET_NAME"));
				mp.setPetGender(rset.getString("PET_GENDER"));
				mp.setPetType(rset.getString("PET_TYPE"));
				mp.setTitleImg(rset.getString("TITLEIMG"));
				mp.setPetNum(rset.getString("PET_NUM"));
			
				list.add(mp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public PetOwner selectPetOwner(Connection conn, String memNum) {
		
		
		// SELECT 문 => ResultSet 형태로 결과 반환 => Member
		// 필요한 변수
		PetOwner m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPetOwner");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNum);
			
			rset = pstmt.executeQuery();
				
			if(rset.next()) {
				
				m = new PetOwner( 	rset.getString("PO_NUM")
						,	rset.getString("MEM_NUM")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
    public int updateMypetY(Connection conn, String memNum) {
        
        // UPDATE 문 => 처리된 행의 갯수
        // 필요한 변수
        int result = 0;
        
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("updateMypetY");
        
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
    
	public ArrayList<Mypet> selectMypet(Connection conn, String petNum) {
		
		// SELECT => ResultSet => 여러행 (while, ArrayList)
		// 변수
		ArrayList<Mypet> list2 = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMypet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, petNum);
			
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				Mypet mp2 = new Mypet();
				
				
				mp2.setPetName(rset.getString("PET_NAME"));
				mp2.setPetGender(rset.getString("PET_GENDER"));
				mp2.setPetType(rset.getString("PET_TYPE"));
				mp2.setPetBirth(rset.getString("PET_BIRTH"));
				mp2.setPetWeight(rset.getString("PET_WEIGHT"));
				mp2.setPetDec(rset.getString("PET_DEC"));
				mp2.setTitleImg(rset.getString("TITLEIMG"));
				mp2.setPetNum(rset.getString("PET_NUM"));
				
				list2.add(mp2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list2;
	}


	public int deleteMypet(Connection conn, String petNum) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		
		String sql = prop.getProperty("deleteMyPet");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, petNum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}



	public Mypet selectMyPetImg(Connection conn, String petNum) {
		
		
				Mypet mp = new Mypet();
				
				PreparedStatement pstmt = null;
				
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectMyPetImg");
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, petNum);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						
						mp = new Mypet(rset.getString("PET_NUM"),
									   rset.getString("PET_NAME"),
									   rset.getString("PET_GENDER"),
									   rset.getString("PET_TYPE"),
									   rset.getString("PET_BIRTH"),
									   rset.getString("PET_WEIGHT"),
									   rset.getString("PET_DEC"),
									   rset.getString("PO_NUM"),
									   rset.getString("TITLEIMG"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
					close(rset);
					close(pstmt);
				}
				
				return mp;
	}


	public PetOwner changeMemNumPoNum(Connection conn, String reviewWriter) {
		
		PetOwner po = new PetOwner();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("changeMemIdPoNum");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewWriter);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				po = new PetOwner(rset.getString("PO_NUM"),
							   rset.getString("MEM_NUM"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return po;
	}



	public int insertReport(Connection conn, Report rep) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReport");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rep.getRepWriter());
			pstmt.setString(2, rep.getRepMem());
			pstmt.setString(3, rep.getRepContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}



	public int updateReportCnt(Connection conn, String repMem) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReportCnt");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, repMem);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	
public int idCheck(Connection conn, String checkId) {
		
		//SELECT => ResultSet => COUNT함수 이용 (숫자 한개나옴)
				//변수
				int count = 0;
				
				PreparedStatement pstmt = null;
				
				ResultSet rset = null;
				
				String sql =prop.getProperty("idCheck");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, checkId);
					
					rset=  pstmt.executeQuery();
					
					if(rset.next()) {
						count = rset.getInt("COUNT(*)");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}	finally {
					close(rset);
					close(pstmt);
				}
				return count;
	}



	public Member selectJoinMem(Connection conn, String memId) {
	
		Member joinMem = new Member();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectJoinMem");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				joinMem = new Member(rset.getString("MEM_NUM"),
							   rset.getString("MEM_ID"),
							   rset.getString("MEM_NAME"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return joinMem;
	}



	public Member changeMemIdMemNum(Connection conn, String memId) {
		
		Member petowner = new Member();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectJoinMem");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				petowner = new Member(rset.getString("MEM_NUM"),
							   rset.getString("MEM_ID"),
							   rset.getString("MEM_NAME"),
							   rset.getString("EMAIL"),
							   rset.getString("PHONE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		return petowner;
	}
	
	public ArrayList<Mypet> selectPetsitterPetList(Connection conn, String psNum) {
		
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectPetsitterPetList");
		
			
			ArrayList<Mypet> list = new ArrayList<Mypet>();
			try {
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, psNum);
				rset = pstmt.executeQuery();
				
			

				while(rset.next()) {
		
					Mypet p = new Mypet( rset.getString("PET_NUM")
										, rset.getString("PET_NAME")
										, rset.getString("PET_GENDER")
										, rset.getString("PET_TYPE")
										, rset.getString("PET_BIRTH")
										, rset.getString("PET_WEIGHT")
										, rset.getString("PET_DEC")
										, rset.getString("PO_NUM")
										, rset.getString("STATUS")
										, rset.getString("MAINIMG")
										
									);
										
					
					list.add(p);
				}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
		
			return list;
		}



	public int updateMemberPetsitter(Connection conn, String memNum) {
		 
        int result = 0;
        
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("updateMemberPetsitter");
        
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

}
