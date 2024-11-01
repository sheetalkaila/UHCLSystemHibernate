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
		
	@Column(name="courseID")
	private String courseID;

	public Enrollment() {
		super();
	}

	public Enrollment(int autoID, String studentID, String courseID) {
		super();
		this.autoID = autoID;
		this.studentID = studentID;
		this.courseID = courseID;
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
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
		
	

}
