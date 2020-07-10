package org.entity;

public class Administrator {
	private String ano ;
	private String aname ;
	private int password;
	public String getAno() {
		return ano;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
}
