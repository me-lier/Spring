package student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	
	@Id
	int rollno;
	String sname;
	String course;
	int fees;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + ", course=" + course + ", fees=" + fees + "]";
	}
	public Student(int rollno, String sname, String course, int fees) {
		super();
		this.rollno = rollno;
		this.sname = sname;
		this.course = course;
		this.fees = fees;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
