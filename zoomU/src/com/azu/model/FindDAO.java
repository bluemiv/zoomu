package com.azu.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FindDAO implements ITotalDAO {

	@Override
	public boolean insert(Object obj) throws Exception {
		boolean check = false;
		FindVO vo = (FindVO) obj;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO FIND VALUES (FIND_NUM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getfPetName());
			pstmt.setString(2, vo.getfType());
			pstmt.setString(3, vo.getfGender());
			pstmt.setTimestamp(4, vo.getfDate());
			pstmt.setString(5, vo.getfArea());
			pstmt.setString(6, vo.getfId());
			pstmt.setString(7, vo.getfPwd());
			pstmt.setString(8, vo.getfTel());
			pstmt.setString(9, vo.getfPhoto());
			pstmt.setString(10, vo.getfEtc());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}

		} catch (Exception e) {
			System.out.println("Error : Find insert method");
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
		FindVO vo = (FindVO) obj;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FIND WHERE FNUM = ? AND FID = ? AND FPWD = ?";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getfNum());
			pstmt.setString(2, vo.getfId());
			pstmt.setString(3, vo.getfPwd());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			System.out.println("Error : Find delete method");
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

	@Override
	public boolean update(Object obj) throws Exception {
		boolean check = false;
		FindVO vo = (FindVO) obj;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE FIND SET FPETNAME = ?, FTYPE = ? , FGENDER = ? , FDATE = ?"
					+ ", FAREA = ? , FTEL = ? , FPHOTO =? , FETC = ? WHERE FNUM = ?";

			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getfPetName());
			pstmt.setString(2, vo.getfType());
			pstmt.setString(3, vo.getfGender());
			pstmt.setTimestamp(4, vo.getfDate());
			pstmt.setString(5, vo.getfArea());
			pstmt.setString(6, vo.getfTel());
			pstmt.setString(7, vo.getfPhoto());
			pstmt.setString(8, vo.getfEtc());
			pstmt.setInt(9, vo.getfNum());

			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			System.out.println("Error : Find update method");
			e.printStackTrace();
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

	public Vector selectAll() {
		Vector<FindVO> list = new Vector<FindVO>();
		FindVO vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM FIND ORDER BY FNUM DESC";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new FindVO();
				vo.setfNum(rs.getInt("fNum"));
				vo.setfPetName(rs.getString("fPetName"));
				vo.setfType(rs.getString("fType"));
				vo.setfGender(rs.getString("fGender"));
				vo.setfDate(rs.getTimestamp("fDate"));
				vo.setfArea(rs.getString("fArea"));
				vo.setfId(rs.getString("fId"));
				vo.setfTel(rs.getString("fTel"));
				vo.setfPhoto(rs.getString("fPhoto"));
				vo.setfEtc(rs.getString("fEtc"));
				System.out.println(vo.getfPhoto());
				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("Error : Find selectAll method");
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return list;
	}

	public FindVO select(FindVO input_vo) {
		FindVO output_vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "SELECT * FROM FIND WHERE FNUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input_vo.getfNum());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				output_vo = new FindVO();
				output_vo.setfNum(rs.getInt("fNum"));
				output_vo.setfPetName(rs.getString("fPetName"));
				output_vo.setfType(rs.getString("fType"));
				output_vo.setfGender(rs.getString("fGender"));
				output_vo.setfDate(rs.getTimestamp("fDate"));
				output_vo.setfArea(rs.getString("fArea"));
				output_vo.setfId(rs.getString("fId"));
				output_vo.setfPwd(rs.getString("fPwd"));
				output_vo.setfTel(rs.getString("fTel"));
				output_vo.setfPhoto(rs.getString("fPhoto"));
				output_vo.setfEtc(rs.getString("fEtc"));
			}
		} catch (Exception e) {
			System.out.println("Error : Find select method");
			e.printStackTrace();
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return output_vo;
	}

	public void img_copy(String sourceFilePath, String targitFileName) throws Exception {
		String targetFile = "C:/dog/WebContent/img/find/" + targitFileName;

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
	}

	public Vector<FindVO> search(CountVO cvo, FindVO input_vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FindVO output_vo = null;
		Vector<FindVO> list = new Vector<FindVO>();

		try {
			String sql = "select * from (select rownum r, A.* from (SELECT * FROM FIND WHERE REGEXP_LIKE (FPETNAME, ?)) A) where R between ? and ?";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_vo.getfPetName());
			pstmt.setInt(2, cvo.getStartNum());
			pstmt.setInt(3, cvo.getEndNum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				output_vo = new FindVO();
				output_vo.setfNum(rs.getInt("fNum"));
				output_vo.setfPetName(rs.getString("fPetName"));
				output_vo.setfType(rs.getString("fType"));
				output_vo.setfGender(rs.getString("fGender"));
				output_vo.setfDate(rs.getTimestamp("fDate"));
				output_vo.setfArea(rs.getString("fArea"));
				output_vo.setfId(rs.getString("fId"));
				output_vo.setfTel(rs.getString("fTel"));
				output_vo.setfPhoto(rs.getString("fPhoto"));
				output_vo.setfEtc(rs.getString("fEtc"));

				list.add(output_vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Find search method");
		} finally {
			CloseDBCP.close(rs);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}

		return list;
	}

	public Vector<FindVO> selectList(CountVO cvo) throws Exception {
		Vector<FindVO> list = new Vector<FindVO>();
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select * from (select rownum r, A.* from (select * from find order by fnum desc) A) where R between ? and ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cvo.getStartNum());
		pstmt.setInt(2, cvo.getEndNum());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			FindVO vo = new FindVO();
			vo.setfNum(rs.getInt("fNum"));
			vo.setfPetName(rs.getString("fPetName"));
			vo.setfType(rs.getString("fType"));
			vo.setfGender(rs.getString("fGender"));
			vo.setfDate(rs.getTimestamp("fDate"));
			vo.setfArea(rs.getString("fArea"));
			vo.setfId(rs.getString("fId"));
			vo.setfTel(rs.getString("fTel"));
			vo.setfPhoto(rs.getString("fPhoto"));
			vo.setfEtc(rs.getString("fEtc"));

			list.add(vo);
		}

		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);

		return list;
	}

	public CountVO countRecord(int curPage) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 3;
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "select count(*) from find";
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

		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		return cvo;
	}

	public CountVO countRecord_search(int curPage, FindVO vo) throws Exception {
		CountVO cvo = new CountVO();
		int viewCount = 3;
		Connection conn = ConnectionDBCP.getInstance().getConnection();
		String sql = "SELECT COUNT(*) FROM FIND WHERE REGEXP_LIKE (FPETNAME, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getfPetName());
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

		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		return cvo;
	}

	public boolean deleteAdmin(FindVO vo) {
		boolean check = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "DELETE FIND WHERE FNUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getfNum());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Find deleteAdmin method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}
}
