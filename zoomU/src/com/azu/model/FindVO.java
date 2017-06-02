package com.azu.model;

import java.sql.Timestamp;

public class FindVO {

	private int fNum; // number constraint find_pk primary key, -- pr_key, 게시판 내부 번호
	private String fPetName; // varchar2(30) not null, -- 강아지 이름
	private String fType; //  varchar2(30) not null, -- 강아지 종류
	private String fGender; // varchar2(30) not null, -- 강아지 성별
	private Timestamp fDate; // date not null, -- 잃어버린 날짜
	private String fArea; // varchar2(30) not null, -- 잃어버린 지역
	private String fId; // varchar2(30) not null, -- 주인 ID
	private String fPwd; // varchar2(30) not null, -- 주인 Password
	private String fTel; // varchar2(30) not null, -- 주인 연락처
	private String fPhoto; // varchar2(100), -- 강아지 사진
	private String fEtc; // varchar2(1000) -- 기타 특이사항
	
	// default constructor
	public FindVO(){
		
	}
	
	// set, get method
	public int getfNum() {
		return fNum;
	}
	public void setfNum(int fNum) {
		this.fNum = fNum;
	}
	public String getfPetName() {
		return fPetName;
	}
	public void setfPetName(String fPetName) {
		this.fPetName = fPetName;
	}
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public String getfGender() {
		return fGender;
	}
	public void setfGender(String fGender) {
		this.fGender = fGender;
	}
	public Timestamp getfDate() {
		return fDate;
	}
	public void setfDate(Timestamp fDate) {
		this.fDate = fDate;
	}
	public String getfArea() {
		return fArea;
	}
	public void setfArea(String fArea) {
		this.fArea = fArea;
	}
	public String getfTel() {
		return fTel;
	}
	public void setfTel(String fTel) {
		this.fTel = fTel;
	}
	public String getfPhoto() {
		return fPhoto;
	}
	public void setfPhoto(String fPhoto) {
		this.fPhoto = fPhoto;
	}
	public String getfEtc() {
		return fEtc;
	}
	public void setfEtc(String fEtc) {
		this.fEtc = fEtc;
	}
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfPwd() {
		return fPwd;
	}
	public void setfPwd(String fPwd) {
		this.fPwd = fPwd;
	}
	
}
