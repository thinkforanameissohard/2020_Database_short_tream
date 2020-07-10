package org.entity;
/**
 * 课程数据表封装
 * @author 坂田银时
 *
 */
public class Course {
	private String cno;
	private String cname;
	private String coutline;
	private String cplan;
	private int credits;
	private String tno;
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCoutline() {
		return coutline;
	}
	public void setCoutline(String coutline) {
		this.coutline = coutline;
	}
	public String getCplan() {
		return cplan;
	}
	public void setCplan(String cplan) {
		this.cplan = cplan;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	
}
