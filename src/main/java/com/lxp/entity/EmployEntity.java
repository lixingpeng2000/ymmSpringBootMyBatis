package com.lxp.entity;

import java.io.Serializable;

public class EmployEntity  implements Serializable{
	private Integer empNo;
	private String ename;
	private String tel;
	private String mail;
	private String jname;
	private String jcity;

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public String getJcity() {
		return jcity;
	}

	public void setJcity(String jcity) {
		this.jcity = jcity;
	}

	public EmployEntity(String ename, String tel, String mail) {
		super();
		this.ename = ename;
		this.tel = tel;
		this.mail = mail;
	}
	
	public EmployEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	

}
