package com.azu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ReplyDAO {

	private static ReplyDAO instance = new ReplyDAO();
	public static ReplyDAO getInstance() {
		return instance;
	}
	private ReplyDAO() {
	}

	public boolean insertReply(ReplyVO vo){
		boolean check = false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn = ConnectionDBCP.getInstance().getConnection();
			pstmt=conn.prepareStatement("insert into reply values( reply_num.nextval , ?, ?, ? , ? , ? )");
			pstmt.setString(1, vo.getId() );
			pstmt.setString(2, vo.getContent());
			pstmt.setTimestamp(3, vo.getRdate());
			pstmt.setInt(4, vo.getRef());
			pstmt.setString(5, vo.getBoard());
			if(pstmt.executeUpdate()==1){
				check = true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error : Reply insert method");
		}finally {
			CloseDBCP.close(pstmt);
			CloseDBCP.close(conn);
		}
		return check;
	}
	public Vector<ReplyVO> select(int ref_num, String board) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ReplyVO re_vo = null;
		Vector<ReplyVO> list = new Vector<ReplyVO>();
		
		try {
			conn=ConnectionDBCP.getInstance().getConnection();
			String sql = "select * from reply where ref = ? and board = ? order by renum desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ref_num);
			pstmt.setString(2, board);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				re_vo = new ReplyVO();
				re_vo.setBoard(rs.getString("board"));
				re_vo.setRef(rs.getInt("ref"));
				re_vo.setId(rs.getString("id"));
				re_vo.setContent(rs.getString("content"));
				re_vo.setRdate(rs.getTimestamp("rdate"));
				
				list.add(re_vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error :  Reply select method");
		} finally {
			CloseDBCP.close(conn);
			CloseDBCP.close(pstmt);
			CloseDBCP.close(rs);
		}
		return list;
	}
	public boolean delete(ReplyVO vo) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionDBCP.getInstance().getConnection();
			String sql = "delete from reply where id = ? and rdate = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setTimestamp(2, vo.getRdate());
			
			if( pstmt.executeUpdate() == 1 ){
				check = true;
			}
			
		} catch (Exception e) {
			System.out.println("Error : Sos Reply delete method");
			e.printStackTrace();
		}
		return check;
	}
}
