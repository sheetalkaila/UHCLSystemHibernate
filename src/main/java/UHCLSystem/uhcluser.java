package UHCLSystem;

import javax.persistence.*;

@Entity
@Table(name="uhcluser")
public class uhcluser {

	@Id
	@Column(name="loginID")
	private String loginID;
	
	@Column(name="password")
	private String password;
	
	@Column(name="major")
	private String major;
	
	@Column(name="type")
	private String type;

	public uhcluser() {
		super();
	}

	public uhcluser(String loginID, String password, String major, String type) {
		super();
		this.loginID = loginID;
		this.password = password;
		this.major = major;
		this.type = type;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
