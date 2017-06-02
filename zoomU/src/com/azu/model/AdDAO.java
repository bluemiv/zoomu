package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class AdDAO {

	// 싱글톤
	private static AdDAO instance = new AdDAO();

	private AdDAO() {

	}

	public static AdDAO getInstance() {
		return instance;
	}

	// 총 누적 기부 금액
	public int totalStackMoney() {
		int total_money = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT SUM(AMONEY) FROM AD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total_money = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Ad totalStackMoney method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}

		return total_money;
	}

	// 기업당 누적 기부 금액
	public int stackMoney(AdVO vo) {
		int money = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT SUM(AMONEY) FROM AD WHERE AENTERNAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getaEnterName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Ad stackMoney method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}

		return money;
	}

	// 기업 이름
	public Vector<AdVO> enterNameList() {
		Vector<AdVO> list = new Vector<AdVO>();
		AdVO output_vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT DISTINCT AENTERNAME FROM AD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				output_vo = new AdVO();
				output_vo.setaEnterName(rs.getString(1));
				output_vo.setaMoney(stackMoney(output_vo));

				list.add(output_vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Ad enterNameList method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}

		return list;
	}

	public boolean insert(AdVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "INSERT INTO AD VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getaEnterName());
			pstmt.setInt(2, vo.getaMoney());
			pstmt.setTimestamp(3, vo.getaDate());
			pstmt.setString(4, vo.getaEtc());
			
			if(pstmt.executeUpdate()==1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Ad insert method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
		}
		return false;
	}

}
