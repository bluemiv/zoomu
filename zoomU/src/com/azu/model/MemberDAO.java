package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO implements ITotalDAO {

	@Override
	public boolean insert(Object obj) throws Exception {

		boolean check = false;
		Connection conn = null;
		MemberVO vo = (MemberVO) obj;
		PreparedStatement pstmt = null;

		try {// 1. 회원 가입
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMtel());
			pstmt.setString(5, vo.getMaddr());
			pstmt.setString(6, vo.getMemail());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

	@Override
	public boolean delete(Object obj) throws Exception {
		boolean check = false;
		ConnectionDBCP connection = ConnectionDBCP.getInstance();
		Connection conn = connection.getConnection();
		MemberVO vo = (MemberVO) obj;
		PreparedStatement pstmt = null;

		try {// 회원 탈퇴
			conn = connection.getConnection();
			String sql = "DELETE FROM MEMBER WHERE MID=? AND MPWD=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpwd());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

	@Override
	public boolean update(Object obj) throws Exception {

		ConnectionDBCP connection = ConnectionDBCP.getInstance();
		Connection conn = connection.getConnection();
		MemberVO vo = (MemberVO) obj;
		PreparedStatement pstmt = null;

		try {
			conn = connection.getConnection();
			String sql = "UPDATE MEMBER SET MPWD=?, MNAME=?, MTEL=?, MADDR=?, MEMAIL=? WHERE MID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMpwd());
			pstmt.setString(2, vo.getMname());
			pstmt.setString(3, vo.getMtel());
			pstmt.setString(4, vo.getMaddr());
			pstmt.setString(5, vo.getMemail());
			pstmt.setString(6, vo.getMid());
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return false;
	}

	// 회원 아이디, 비밀번호 체크
	public boolean userCheck(MemberVO vo) throws Exception {
		boolean check = false;
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPWD = ?";
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getMid());
		pstmt.setString(2, vo.getMpwd());
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) { // id, pwd check
			check = true;
		}
		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);

		return check;
	}// use check() end

	public MemberVO select(MemberVO input_vo) {
		MemberVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "select * from member where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_vo.getMid()); // 세션에 있는 id 값
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setMid(rs.getString("mid"));
				vo.setMpwd(rs.getString("mpwd"));
				vo.setMname(rs.getString("mname"));
				vo.setMaddr(rs.getString("maddr"));
				vo.setMemail(rs.getString("memail"));
				vo.setMtel(rs.getString("mtel"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return vo;
	}

	// id 중복 체크
	public boolean confirmId(MemberVO vo) throws Exception {
		ConnectionDBCP connection = ConnectionDBCP.getInstance();
		Connection conn = connection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			conn = connection.getConnection();
			String sql = "select mid from member where mid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = false; // id 있음 else result=-true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return result;
	}
}
