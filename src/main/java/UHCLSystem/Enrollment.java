package UHCLSystem;

import javax.persistence.*;

@Entity
@Table(name="enrollment")

public class Enrollment {

	@Id
	@Column(name="autoID")
	private int autoID;
		
	@Column(name="studentID")
	private String studentID;
		
	@Column(name="couserID")
	private String couserID;

	public Enrollment() {
		super();
	}

	public Enrollment(int autoID, String studentID, String couserID) {
		super();
		this.autoID = autoID;
		this.studentID = studentID;
		this.couserID = couserID;
	}

	public int getAutoID() {
		return autoID;
	}

	public void setAutoID(int autoID) {
		this.autoID = autoID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCouserID() {
		return couserID;
	}

	public void setCouserID(String couserID) {
		this.couserID = couserID;
	}
		
	

}
