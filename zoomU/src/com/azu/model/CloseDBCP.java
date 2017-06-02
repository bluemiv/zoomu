package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CloseDBCP {

	public static void close(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : conn close");
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : rs close");
		}
	}
	
	public static void close(PreparedStatement pstmt){
		try {
			if(pstmt != null){
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : pstmt close");
		}
	}
	
	public static void close(Statement stmt){
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : stmt close");
		}
	}
}
