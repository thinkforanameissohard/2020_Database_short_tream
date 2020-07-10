package org.entity;
/*
 * 数据库的数据封装
 * */

public class infor {
	private String sno;
	private String tno;
	private String mconten;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getMconten() {
		return mconten;
	}
	public void setMconten(String mconten) {
		this.mconten = mconten;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	private String mtime;	
}
