package study;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserVO {	
	private Integer no;
	
	@NotEmpty
	@Length(min = 2,max = 5)
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "[0-9a-zA-Z]{4,5}")
	private String pwd;
	
	@NotEmpty
	private String gender;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
