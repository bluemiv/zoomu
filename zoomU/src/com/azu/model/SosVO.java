package com.azu.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SosVO {
	private int snum;
	private String sarea, stell, stitle, setc;
	private Timestamp sdate;
	private String swriter;
	private int scount;
	private int recount;
	


	// constructor
	public SosVO(){}
	
	// set get method
	public String getSwriter() {
		return swriter;
	}
	public void setSwriter(String swriter) {
		this.swriter = swriter;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getSarea() {
		return sarea;
	}
	public void setSarea(String sarea) {
		this.sarea = sarea;
	}
	public String getStell() {
		return stell;
	}
	public void setStell(String stell) {
		this.stell = stell;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getSetc() {
		return setc;
	}
	public void setSetc(String setc) {
		this.setc = setc;
	}

	public int getScount() {
		return scount;
	}

	public void setScount(int scount) {
		this.scount = scount;
	}
	
	public int getRecount() {
		return recount;
	}

	public void setRecount(int recount) {
		this.recount = recount;
	}
}
