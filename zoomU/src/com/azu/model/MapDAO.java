package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MapDAO{

	// 싱글 톤
	private static MapDAO instance = new MapDAO();
	private MapDAO(){ }
	public static MapDAO getInstance(){
		return instance;
	}
	
	public Vector<MapVO> selectAll(MapVO input_vo){
		Vector<MapVO> list = new Vector<MapVO>();
		MapVO output_vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			
			if(input_vo.getmCenterName() == null){
				sql = "SELECT * FROM MAP WHERE MAREA = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, input_vo.getmArea());
			} else if (input_vo.getmCenterName() != null){
				sql = "SELECT * FROM MAP WHERE MAREA = ? AND MCENTERNAME = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, input_vo.getmArea());
				pstmt.setString(2, input_vo.getmCenterName());
			}
			
			rs= pstmt.executeQuery();
			while(rs.next()){
				output_vo = new MapVO();
				output_vo.setmCenterName(rs.getString("mCenterName"));
				output_vo.setmMapX(rs.getString("mMapX"));
				output_vo.setmMapY(rs.getString("mMapY"));
				output_vo.setmArea(rs.getString("mArea"));
				output_vo.setmEtc(rs.getString("mEtc"));
				
				list.add(output_vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : Map selectAll method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}
		
		return list;
	}

	
	
}
