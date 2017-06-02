package com.azu.model;

public class MapVO {

	private String mCenterName;// varchar2(30) not null, -- 보호소 이름
	private String mMapX;// varchar2(10) not null, -- x좌표
	private String mMapY;// varchar2(10) not null, -- y좌표
	private String mArea;// varchar2(30) not null, -- 보호소 위치
	private String mEtc;// varchar2(1000) not null -- 특이사항
	
	public MapVO (){
		
	}
	
	public String getmCenterName() {
		return mCenterName;
	}
	public void setmCenterName(String mCenterName) {
		this.mCenterName = mCenterName;
	}
	public String getmMapX() {
		return mMapX;
	}
	public void setmMapX(String mMapX) {
		this.mMapX = mMapX;
	}
	public String getmMapY() {
		return mMapY;
	}
	public void setmMapY(String mMapY) {
		this.mMapY = mMapY;
	}
	public String getmArea() {
		return mArea;
	}
	public void setmArea(String mArea) {
		this.mArea = mArea;
	}
	public String getmEtc() {
		return mEtc;
	}
	public void setmEtc(String mEtc) {
		this.mEtc = mEtc;
	}
	
	
}
