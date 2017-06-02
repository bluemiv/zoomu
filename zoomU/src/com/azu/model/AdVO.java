package com.azu.model;

import java.sql.Timestamp;

public class AdVO {

	private String aEnterName; // varchar2(100) default '익명', -- 기업 이름 (기본값 익명)
	private int aMoney;// number not null, -- 기부 금액
	private Timestamp aDate;// date not null, -- 기부 날짜
	private String aEtc; // varchar2(1000) default '내용없음'-- 특이사항
	
	public AdVO(){
		
	}
	
	public String getaEnterName() {
		return aEnterName;
	}
	public void setaEnterName(String aEnterName) {
		this.aEnterName = aEnterName;
	}
	public int getaMoney() {
		return aMoney;
	}
	public void setaMoney(int aMoney) {
		this.aMoney = aMoney;
	}
	public Timestamp getaDate() {
		return aDate;
	}
	public void setaDate(Timestamp aDate) {
		this.aDate = aDate;
	}
	public String getaEtc() {
		return aEtc;
	}
	public void setaEtc(String aEtc) {
		this.aEtc = aEtc;
	}
	
	
}
