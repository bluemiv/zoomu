package com.azu.model;

import java.sql.Timestamp;

public class ReplyVO {
	private int renum;	// 글의순서
	private int ref; 	// 어느글에 속해있는지 (Snum)
	private String id; // id
	private String content; // 내용
	private Timestamp rdate; // 댓글입력시간
	private String board;
	
	public ReplyVO(){
		
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getRenum() {
		return renum;
	}
	public void setRenum(int renum) {
		this.renum = renum;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	
	
}
