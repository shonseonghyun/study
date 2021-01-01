package model.shop.dto.member;

import java.sql.Date;

public class MemberDTO {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private Date date;
	
	
	public Date getDate() {
		return date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public MemberDTO(String id, String pwd,String email) {
		this.id = id;
		this.pwd = pwd;
		this.email=email;
	}
	public MemberDTO() {
	}
}
