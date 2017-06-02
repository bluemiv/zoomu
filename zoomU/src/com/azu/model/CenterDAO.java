package com.azu.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CenterDAO {
	private static CenterDAO instance = new CenterDAO(); // 한번만 객체 생성해서 모든 클라이언트
															// 공유

	public static CenterDAO getInstance() {
		return instance;
	}// getInstance() end

	// 생성자
	private CenterDAO() {
	}

	// insert
	public boolean insert(CenterVO vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection(); // 연결
			String sql = "insert into center values(center_num.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getcPetName());
			pstmt.setString(2, vo.getcGender());
			pstmt.setString(3, vo.getcType());
			pstmt.setString(4, vo.getcArea());
			pstmt.setString(5, vo.getcName());
			pstmt.setString(6, vo.getCphoto());
			pstmt.setString(7, vo.getcYn());
			pstmt.setString(8, vo.getcEtc());
			pstmt.setString(9, vo.getcId());
			pstmt.setString(10, vo.getcPwd());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		} // try end
		return check;

	}// insert() end

	// Update
	public boolean update(CenterVO vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();// 연결

			String sql;

			sql = "update center set cpetname=?, cgender=?, ctype=?, carea=?, cname=?, cphoto=?, cyn=?, cetc=? where cnum=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getcPetName());
			pstmt.setString(2, vo.getcGender());
			pstmt.setString(3, vo.getcType());
			pstmt.setString(4, vo.getcArea());
			pstmt.setString(5, vo.getcName());
			pstmt.setString(6, vo.getCphoto());
			pstmt.setString(7, vo.getcYn());
			pstmt.setString(8, vo.getcEtc());
			pstmt.setInt(9, vo.getcNum());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		} // try end
		return check;
	}// update() end

	// delete
	public boolean delete(CenterVO vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection(); // 연결
			String sql = "delete from center where cNum=? and cId=? and cPwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getcNum());
			pstmt.setString(2, vo.getcId());
			pstmt.setString(3, vo.getcPwd());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Center delete method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		} // try end
		return check;
	}// delete() end

	// selectAll
	public Vector selectAll() {
		Vector list = new Vector();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CenterVO vo = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();// 연결
			String sql = "select * from center";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CenterVO();
				vo.setcNum(rs.getInt("cNum"));
				vo.setcPetName(rs.getString("cPetName"));
				vo.setcGender(rs.getString("cGender"));
				vo.setcType(rs.getString("cType"));
				vo.setcArea(rs.getString("cArea"));
				vo.setcName(rs.getString("cName"));
				vo.setCphoto(rs.getString("Cphoto"));
				vo.setcYn(rs.getString("cYn"));
				vo.setcEtc(rs.getString("cEtc"));

				list.add(vo);
			} // while end

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		} // try end
		return list;
	}// selectAll() end

	// Detail
	public CenterVO Detail(int cNum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CenterVO vo = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();// 연결
			String sql = "select * from center where cnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CenterVO();
				vo.setcNum(rs.getInt("cNum"));
				vo.setcPetName(rs.getString("cPetName"));
				vo.setcGender(rs.getString("cGender"));
				vo.setcType(rs.getString("cType"));
				vo.setcArea(rs.getString("cArea"));
				vo.setcName(rs.getString("cName"));
				vo.setCphoto(rs.getString("Cphoto"));
				vo.setcYn(rs.getString("cYn"));
				vo.setcEtc(rs.getString("cEtc"));

			} // while end

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		} // try end
		return vo;
	}// Detail() end

	// image copy
	public void img_copy(String sourceFilePath, String targitFileName) throws Exception {
		String targetFile = "C:/dog/WebContent/img/center/" + targitFileName;

		FileInputStream fis = null;
		FileOutputStream fos = null;

		int n = 0;
		int count = 0;
		byte ba[] = new byte[1024];
		int total = 0;

		fis = new FileInputStream(sourceFilePath);
		fos = new FileOutputStream(targetFile);

		while ((n = fis.read(ba)) != -1) {
			fos.write(ba, 0, n);
			fos.flush();
			count++;
			total += n;
		}
		fis.close();
		fos.close();
	}// image copy end

	// selectupdate
	public CenterVO selectupdate(int cNum) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CenterVO vo = new CenterVO();

		conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select * from center where cNum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cNum); // null point error
		rs = pstmt.executeQuery();

		while (rs.next()) {
			vo.setcNum(rs.getInt("cNum"));
			vo.setcPetName(rs.getString("cPetName"));
			vo.setcGender(rs.getString("cGender"));
			vo.setcType(rs.getString("cType"));
			vo.setcArea(rs.getString("cArea"));
			vo.setcName(rs.getString("cName"));
			vo.setCphoto(rs.getString("Cphoto"));
			vo.setcYn(rs.getString("cYn"));
			vo.setcEtc(rs.getString("cEtc"));
			vo.setcId(rs.getString("cId"));
			vo.setcPwd(rs.getString("cPwd"));
		}

		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);
		return vo;
	}

	// selectList
	public Vector<CenterVO> selectList(CountVO cvo) throws Exception {
		Vector<CenterVO> list = new Vector<CenterVO>();

		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select cNum,cPhoto,cPetName,cEtc from (select rownum r, A.* from (select cNum,cPhoto,cPetName,cEtc from center order by cnum desc) A) where R between ? and ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// system.out.println(cvo.getStartNum()+"/"+cvo.getEndNum());
		pstmt.setInt(1, cvo.getStartNum());
		pstmt.setInt(2, cvo.getEndNum());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CenterVO vo = new CenterVO();
			vo.setcNum(rs.getInt("cNum"));
			vo.setCphoto(rs.getString("Cphoto"));
			vo.setcPetName(rs.getString("cPetName"));
			vo.setcEtc(rs.getString("cEtc"));
			list.add(vo);
		}

		CloseDBCP.close(rs);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(conn);

		return list;
	}

	// countRecord
	public CountVO countRecord(int curPage) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 3;

		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select count(*) from center";
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

	// search
	public Vector<CenterVO> search(CountVO cvo, String search) {
		Vector<CenterVO> list = new Vector<CenterVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CenterVO vo = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT * FROM (SELECT ROWNUM RNUM, A.* FROM (SELECT * FROM CENTER WHERE REGEXP_LIKE(CPETNAME, ?) ORDER BY CNUM DESC) A ) WHERE RNUM BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, cvo.getStartNum());
			pstmt.setInt(3, cvo.getEndNum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new CenterVO();
				vo.setcNum(rs.getInt("cNum"));
				vo.setCphoto(rs.getString("Cphoto"));
				vo.setcPetName(rs.getString("cPetName"));
				vo.setcEtc(rs.getString("cEtc"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Center search method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return list;
	}

	public CountVO countRecord_search(int curPage, CenterVO vo) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 3;
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "SELECT COUNT(*) FROM CENTER WHERE REGEXP_LIKE (CPETNAME, ?) ORDER BY CNUM DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getcPetName());
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

	public boolean deleteAdmin(CenterVO vo) {
		boolean check = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "DELETE CENTER WHERE CNUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getcNum());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Center deleteAdmin method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}
}
