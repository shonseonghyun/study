package study;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class MemberDTO {

	@NotEmpty
	@Length(min = 2,max = 5)
	private String id;
	
	@NotEmpty
	@Pattern(regexp = "[0-9a-zA-Z]{4,5}")
	private String pwd;
	
	@NotEmpty
	@Email
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
