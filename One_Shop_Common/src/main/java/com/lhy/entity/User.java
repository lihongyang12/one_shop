package com.lhy.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private Integer user_id;
	private String username;
	private String password;
	private String email;
	private String realname;
	private Integer telphone;
	private String sex;
	private Date createtime;
	private String third_id;
	private Integer status;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer user_id, String username, String password, String email, String realname, Integer telphone,
			String sex, Date createtime, String third_id, Integer status) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.realname = realname;
		this.telphone = telphone;
		this.sex = sex;
		this.createtime = createtime;
		this.third_id = third_id;
		this.status = status;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getTelphone() {
		return telphone;
	}
	public void setTelphone(Integer telphone) {
		this.telphone = telphone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getThird_id() {
		return third_id;
	}
	public void setThird_id(String third_id) {
		this.third_id = third_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", realname=" + realname + ", telphone=" + telphone + ", sex=" + sex + ", createtime=" + createtime
				+ ", third_id=" + third_id + ", status=" + status + "]";
	}
	
	
}
