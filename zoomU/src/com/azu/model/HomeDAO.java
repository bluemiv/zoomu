package com.azu.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class HomeDAO implements ITotalDAO{
	private HomeDAO(){}
	private static HomeDAO instance=new HomeDAO();
	public static HomeDAO getInstance(){
		return instance;
	}
	@Override
	public boolean insert(Object obj) throws Exception {
		boolean check = false;
		Connection conn=ConnectionDBCP.getInstance().getConnection();	
		String sql="insert into home values(home_num.nextval,?,?,?,?,?,?,?,?)";
		HomeVO vo=(HomeVO)obj;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getHid());
		pstmt.setString(2, vo.getHpwd());
		pstmt.setString(3, vo.getHpetname());
		pstmt.setString(4, vo.getHtype());
		pstmt.setString(5, vo.getHgender());
		pstmt.setString(6, vo.getHphoto());
		pstmt.setString(7, vo.getHyn());
		pstmt.setString(8, vo.getHetc());
		
		if(pstmt.executeUpdate() ==1){
			check = true;
		}
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		
		return check;
	}
	@Override
	public boolean delete(Object obj) throws Exception {
		boolean check = false;
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		
		String sql="select hid from home where hnum=?";
		HomeVO vo=(HomeVO)obj;
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1, vo.getHnum());
		
		ResultSet rs=pstmt.executeQuery();
	
		if(rs.next()){
			if(vo.getHid().equals(rs.getString(1))){
				sql="delete from home where hnum=?";
				pstmt=conn.prepareStatement(sql);		
				pstmt.setInt(1, vo.getHnum());
				pstmt.executeUpdate();
				check = true;
			}
		}
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		return check;
	}
	@Override
	public boolean update(Object obj) throws Exception {
		boolean check = false;
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		HomeVO vo=(HomeVO)obj;
//		String sql="update home set (hpetname,hgender,htype,hphoto,hyn,hetc)=(?,?,?,?,?,?) where hnum=?";
		String sql="update home set hpetname=?,hgender=?,htype=?,hphoto=?,hyn=?,hetc=? where hnum=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);		
		pstmt.setString(1,vo.getHpetname());
		pstmt.setString(2, vo.getHgender());
		pstmt.setString(3, vo.getHtype());		
		pstmt.setString(4, vo.getHphoto());
		pstmt.setString(5, vo.getHyn());
		pstmt.setString(6, vo.getHetc());
		pstmt.setInt(7, vo.getHnum());
		
		if(pstmt.executeUpdate()==1){
			check = true;
		}
		
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		
		return check;
	}
	
	public Vector<HomeVO> selectList(CountVO cvo) throws Exception{
		Vector<HomeVO> list=new Vector<HomeVO>();
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		String sql="select hnum,hphoto,hpetname,hetc from (select rownum r, A.* from (select hnum,hphoto,hpetname,hetc from home order by hnum desc) A) where R between ? and ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, cvo.getStartNum());
		pstmt.setInt(2, cvo.getEndNum());
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()){
			HomeVO vo=new HomeVO();
			vo.setHnum(rs.getInt("hnum"));
			vo.setHphoto(rs.getString("hphoto"));
			vo.setHpetname(rs.getString("hpetname"));
			vo.setHetc(rs.getString("hetc"));
			
			list.add(vo);
		}
		
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		
		return list;
	}
	public HomeVO selectContent(int hnum) throws Exception{
		HomeVO vo=new HomeVO();
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		String sql="select * from home where hnum=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, hnum);
		ResultSet rs=pstmt.executeQuery();		
		if(rs.next()){			
			vo.setHnum(hnum);
			vo.setHid(rs.getString(2));
			vo.setHpwd(rs.getString(3));			
			vo.setHpetname(rs.getString(4));
			vo.setHtype(rs.getString(5));
			vo.setHgender(rs.getString(6));
			vo.setHphoto(rs.getString(7));
			vo.setHyn(rs.getString(8));
			vo.setHetc(rs.getString(9));
		}
		
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		
		return vo;
	}
	public void img_copy(String sourceFilePath, String targitFileName) throws Exception{
		String targetFile = "C:/dog/WebContent/img/home/" + targitFileName;

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
	public CountVO countRecord(int curPage) throws Exception{
		CountVO cvo=new CountVO();
		int viewCount=3;
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		String sql="select count(*) from home";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) cvo.setTotalRecord(rs.getInt(1));		
		if(cvo.getTotalRecord()!=0){
			if((cvo.getTotalRecord()%viewCount)==0){
				cvo.setTotalPage(cvo.getTotalRecord()/viewCount);
			}else{
				cvo.setTotalPage((cvo.getTotalRecord()/viewCount)+1);				
			}
		}
		cvo.setStartNum((curPage-1)*viewCount+1);
		cvo.setEndNum(cvo.getStartNum()+viewCount-1);
		
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		
		return cvo;
	}
	public CountVO countRecord_search(int curPage, HomeVO home_vo) throws Exception {
		CountVO cvo=new CountVO();
		int viewCount=3;
		Connection conn=ConnectionDBCP.getInstance().getConnection();
		String sql="SELECT COUNT(*) FROM HOME WHERE REGEXP_LIKE (HPETNAME, ?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, home_vo.getHpetname());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) cvo.setTotalRecord(rs.getInt(1));		
		if(cvo.getTotalRecord()!=0){
			if((cvo.getTotalRecord()%viewCount)==0){
				cvo.setTotalPage(cvo.getTotalRecord()/viewCount);
			}else{
				cvo.setTotalPage((cvo.getTotalRecord()/viewCount)+1);				
			}
		}
		cvo.setStartNum((curPage-1)*viewCount+1);
		cvo.setEndNum(cvo.getStartNum()+viewCount-1);
		
		CloseDBCP.close(conn);
		CloseDBCP.close(pstmt);
		CloseDBCP.close(rs);
		
		return cvo;
	}
	public Vector<HomeVO> search(CountVO cvo, HomeVO home_vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HomeVO output_vo = null;
		Vector<HomeVO> list = new Vector<HomeVO>();
		
		try {
			//select * from (select rownum r, A.* from (SELECT * FROM FIND WHERE REGEXP_LIKE (FPETNAME, ?)) A) where R between ? and ?
			String sql = "select * from (select rownum r, A.* from (SELECT * FROM HOME WHERE REGEXP_LIKE (HPETNAME, ?)) A) where R between ? and ?";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, home_vo.getHpetname());
			pstmt.setInt(2, cvo.getStartNum());
			pstmt.setInt(3, cvo.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				output_vo = new HomeVO();
				output_vo.setHnum(rs.getInt("hNum"));
				output_vo.setHid(rs.getString("hId"));
				output_vo.setHpwd(rs.getString("hPwd"));			
				output_vo.setHpetname(rs.getString("hPetName"));
				output_vo.setHtype(rs.getString("hType"));
				output_vo.setHgender(rs.getString("hGender"));
				output_vo.setHphoto(rs.getString("hPhoto"));
				output_vo.setHyn(rs.getString("hYn"));
				output_vo.setHetc(rs.getString("hEtc"));
				
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
	public Vector selectAll() {
		Vector<HomeVO> list = new Vector<HomeVO>();
		HomeVO vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM HOME ORDER BY HNUM DESC";
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new HomeVO();
				vo.setHnum(rs.getInt("hNum"));
				vo.setHid(rs.getString("hId"));
				vo.setHpwd(rs.getString("hPwd"));			
				vo.setHpetname(rs.getString("hPetName"));
				vo.setHtype(rs.getString("hType"));
				vo.setHgender(rs.getString("hGender"));
				vo.setHphoto(rs.getString("hPhoto"));
				vo.setHyn(rs.getString("hYn"));
				vo.setHetc(rs.getString("hEtc"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("Error : Home selectAll method");
			e.printStackTrace();
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}

		return list;
	}
	
	public boolean deleteAdmin(HomeVO vo) {
		boolean check = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "DELETE HOME WHERE HNUM = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getHnum());
			if (pstmt.executeUpdate() == 1) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Home deleteAdmin method");
		} finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}

}
