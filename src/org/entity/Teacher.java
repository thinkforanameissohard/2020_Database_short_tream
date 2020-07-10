package org.entity;
/**
 * 教师表的数据封装
 * @author 坂田银时
 *
 */
public class Teacher {
	private String tno ;
	private String tname ;
	private int tage ;
	private String tbirth ;
	private int password;
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTbirth() {
		return tbirth;
	}
	public void setTbirth(String tbirth) {
		this.tbirth = tbirth;
	}
	public String getTaddress() {
		return taddress;
	}
	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	private String taddress ;
}
