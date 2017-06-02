package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SosDAO {

	private static SosDAO instance = new SosDAO();

	public static SosDAO getInstance() {
		return instance;
	}

	private SosDAO() { }

	public int getListAllCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		try {
			conn = ConnectionDBCP.getInstance().getConnection(); // ����

			pstmt = conn.prepareStatement("select count(*) from sos");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return count;
	}

	public List<SosVO> getSelectAll(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List list = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			StringBuffer sb = new StringBuffer();

			sb.append("select * from sos where rownum>= ? and rownum <= ?");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList(end);
				do {
					SosVO vo = new SosVO();
					vo.setSnum(rs.getInt("snum"));
					vo.setSarea(rs.getString("sarea"));
					vo.setStell(rs.getString("stell"));
					vo.setStitle(rs.getString("stitle"));
					vo.setSetc(rs.getString("setc"));

					list.add(vo);

				} while (rs.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos getSelectAll method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return list;
	}

	public SosVO select(SosVO input_vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SosVO vo = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM SOS WHERE SNUM=?");
			pstmt.setInt(1, input_vo.getSnum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new SosVO();
				vo.setSnum(rs.getInt("snum"));
				vo.setSarea(rs.getString("sarea"));
				vo.setStitle(rs.getString("stitle"));
				vo.setStell(rs.getString("stell"));
				vo.setSdate(rs.getTimestamp("sdate"));
				vo.setSwriter(rs.getString("swriter"));
				vo.setSetc(rs.getString("setc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos select method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return vo;
	}

	public void update(int snum, SosVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		try {
			conn = ConnectionDBCP.getInstance().getConnection();

			sql = "update sos set sarea=?, stell=?, stitle=?,setc=? where snum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSarea());
			pstmt.setString(2, vo.getStell());
			pstmt.setString(3, vo.getStitle());
			pstmt.setString(4, vo.getSetc());
			pstmt.setInt(5, snum);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos update method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

	}

	// 게시물 삽입
	public boolean insert(SosVO vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO SOS VALUES(SOS_NUM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSarea());
			pstmt.setString(2, vo.getStitle());
			pstmt.setString(3, vo.getStell());
			pstmt.setTimestamp(4, vo.getSdate());
			pstmt.setString(5, vo.getSwriter());
			pstmt.setString(6, vo.getSetc());
			pstmt.setInt(7, vo.getScount());

			if (pstmt.executeUpdate() == 1) {
				check =  true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos insert method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return check;
	}

	public boolean delete(SosVO input_vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement("DELETE FROM SOS WHERE SNUM = ?");
			pstmt.setInt(1, input_vo.getSnum());
			System.out.println("input_vo.getSnum() : " + input_vo.getSnum());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos delete method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

	public SosVO detail(SosVO input_vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		SosVO vo = null;
		String sql = "";
		try {
			conn = ConnectionDBCP.getInstance().getConnection();

			pstmt = conn.prepareStatement("SELECT * FROM SOS WHERE SNUM=?");
			pstmt.setInt(1, input_vo.getSnum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new SosVO();
				vo.setSnum(rs.getInt("snum"));
				vo.setSarea(rs.getString("sarea"));
				vo.setStitle(rs.getString("stitle"));
				vo.setStell(rs.getString("stell"));
				vo.setSdate(rs.getTimestamp("sdate"));
				vo.setSwriter(rs.getString("swriter"));
				vo.setSetc(rs.getString("setc"));
				vo.setScount(rs.getInt("scount"));
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

	// List Form에 출력할 모든 게시물
	public Vector<SosVO> selectAll() {
		Vector<SosVO> list = new Vector<SosVO>();
		SosVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT * FROM SOS ORDER BY SDATE DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new SosVO();
				vo.setSnum(rs.getInt("snum"));
				vo.setSarea(rs.getString("sarea"));
				vo.setStitle(rs.getString("stitle"));
				vo.setStell(rs.getString("stell"));
				vo.setSdate(rs.getTimestamp("sdate"));
				vo.setSwriter(rs.getString("swriter"));
				vo.setSetc(rs.getString("setc"));
				vo.setScount(rs.getInt("scount"));

				pstmt = conn.prepareStatement("select count(*) from reply where ref=? and board='sos'");
				pstmt.setInt(1, vo.getSnum());
				ResultSet crs = pstmt.executeQuery();

				if (crs.next()) {
					vo.setRecount(crs.getInt(1));
				}

				// vo 객체 삽입
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos selectAll method");
		} finally {
			// 꼭 닫아야함!!!!!!!!!!
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return list;
	}

	public Vector<SosVO> selectList(CountVO cvo) throws Exception {
		Vector<SosVO> list = new Vector<SosVO>();
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select * from (select rownum r, A.* from (select * from sos order by snum desc) A) where R between ? and ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cvo.getStartNum());
		pstmt.setInt(2, cvo.getEndNum());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			SosVO vo = new SosVO();
			vo.setSnum(rs.getInt("snum"));
			vo.setSarea(rs.getString("sarea"));
			vo.setStitle(rs.getString("stitle"));
			vo.setStell(rs.getString("stell"));
			vo.setSdate(rs.getTimestamp("sdate"));
			vo.setSwriter(rs.getString("swriter"));
			vo.setSetc(rs.getString("setc"));
			vo.setScount(rs.getInt("scount"));
			vo.setRecount(replyCountCall(vo));
			
			list.add(vo);
		}
		
		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);
		
		return list;
	}

	public int replyCountCall(SosVO vo){
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "select count(*) from reply where ref = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSnum());
			rs= pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos replyCountCall method");
		} finally{
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
			CloseDBCP.close(conn);
		}
		return count;
	}
	
	
	
	
	public CountVO countRecord(int curPage) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 10;
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select count(*) from sos";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			cvo.setTotalRecord(rs.getInt(1));
		if (cvo.getTotalRecord() != 0) {
			if ((cvo.getTotalRecord() % viewCount) == 0) {
				cvo.setTotalPage(cvo.getTotalRecord() / viewCount);
			} else {
				cvo.setTotalPage((cvo.getTotalRecord() / viewCount) + 1);
			}
		}
		cvo.setStartNum((curPage - 1) * viewCount + 1);
		cvo.setEndNum(cvo.getStartNum() + viewCount - 1);
		
		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);
		
		return cvo;
	}

	public CountVO countRecord_search(int curPage, SosVO input_vo) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 10;
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "SELECT COUNT(*) FROM SOS WHERE REGEXP_LIKE (STITLE, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, input_vo.getStitle());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			cvo.setTotalRecord(rs.getInt(1));
		if (cvo.getTotalRecord() != 0) {
			if ((cvo.getTotalRecord() % viewCount) == 0) {
				cvo.setTotalPage(cvo.getTotalRecord() / viewCount);
			} else {
				cvo.setTotalPage((cvo.getTotalRecord() / viewCount) + 1);
			}
		}
		cvo.setStartNum((curPage - 1) * viewCount + 1);
		cvo.setEndNum(cvo.getStartNum() + viewCount - 1);

		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);
		
		return cvo;
	}

	public Vector<SosVO> search(CountVO cvo, SosVO input_vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SosVO output_vo = null;
		Vector<SosVO> list = new Vector<SosVO>();
		
		try {
			String sql = "select * from (select rownum r, A.* from (SELECT * FROM SOS WHERE REGEXP_LIKE (STITLE, ?)) A) where R between ? and ?";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_vo.getStitle());
			pstmt.setInt(2, cvo.getStartNum());
			pstmt.setInt(3, cvo.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				output_vo = new SosVO();
				output_vo.setSnum(rs.getInt("snum"));
				output_vo.setSarea(rs.getString("sarea"));
				output_vo.setStitle(rs.getString("stitle"));
				output_vo.setStell(rs.getString("stell"));
				output_vo.setSdate(rs.getTimestamp("sdate"));
				output_vo.setSwriter(rs.getString("swriter"));
				output_vo.setSetc(rs.getString("setc"));
				output_vo.setScount(rs.getInt("scount"));
				output_vo.setRecount(replyCountCall(output_vo));

				list.add(output_vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Sos search method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		
		return list;
	}

	public void readcount(SosVO input_vo, int checkCount){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="";
		if(checkCount==1){
			try{
				conn= ConnectionDBCP.getInstance().getConnection();
				sql="update sos set scount=scount+1 where snum=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, input_vo.getSnum());
				pstmt.executeUpdate();
				System.out.println("scount update 성공");
				
			}catch(Exception e){
				
			}finally {
				CloseDBCP.close(pstmt);
				CloseDBCP.close(conn);
			}
		}else if(checkCount != 1){
			System.out.println("scount update 실패");
		}
	}

	public boolean deleteAdmin(SosVO vo) {
		boolean check = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "DELETE SOS WHERE SNUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSnum());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : SOS deleteAdmin method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}
	

}
