package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	// JDBC	과정 중 반복적으로 쓰이는 구문들을 각각 메소드로 정의해둘 곳
	// "재사용될 목적"
	
	// 이 클래스의 모든 메소드를 다 static으로 만들 것 
	// 싱클톤 패턴: 메모리 영역에 단 한번만 올라간 것을 재사용한 개념
	
	// 공통적인 부분 뽑아내기
	// 1. DB와 접속된 Connection객체를 생성해서 반환시켜주는 메소드
		
	
	// 싱글톤 패턴 자주쓰 이는것들을 static만들어 놓고 바로바로 호출에서 쓰는 재사용의 개념..
	public static Connection getConnection() {
		
	
		
		Properties prop = new Properties();
	
		
		
		Connection conn = null;
		
		// 읽어오자 하는 파일의 물리적인 path: 
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		try {
		
											
			prop.load(new FileInputStream(fileName));
			
			// prop으로부터 getProperty메소드 이용해서 각 키에 해당하는 벨류 뽑아오기
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),prop.getProperty("password"));
			
			
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}catch( FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		return conn;		
	}
		
	// 2. 전달받은 JDBC 용 객체를 반납시켜주는 메소드(각 객체별로)
	// 2_1) Connection객체를 전달받아서 반납시켜주는 메소드
	public static void close( Connection conn) {
		
		try {
			// 주의사항!!!!
			// 만약에 conn이 null 이라면 NullPointer Exception발생
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//2_2 오버로딩 적용
	// Statement은 PreparedStatment의 부모 => 다형성에 의해서 PreparedStatement 객체 또한 매개변수로 받을 수 있다.
	public static void close(Statement stmt){
		try {
			// 주의사항!!!!
			// 만약에 conn이 null 이라면 NullPointer Exception발생
			
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//2_3 
	public static void close(ResultSet rset){
		try {
			// 주의사항!!!!
			// 만약에 conn이 null 이라면 NullPointer Exception발생
			
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	// 3. 전달받은 Connection객체를 가지고 트렌젝션 처리를 해주는 메소드
	
	//3_1) commit
	
	public static void commit(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.commit();
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
	}
	//3_2 rollback
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
}
	


}
