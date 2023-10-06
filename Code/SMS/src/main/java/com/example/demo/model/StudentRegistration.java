package com.example.demo.model;

public class StudentRegistration {

	
	int rollno;	
	String studname;
	String studclass;
	
	
	
	@Override
	public String toString() {
		return "StudentRegistration [rollno=" + rollno + ", studname=" + studname + ", studclass=" + studclass + "]";
	}

	public StudentRegistration() {
		
	}
	
	public StudentRegistration(int rollno, String studname, String studclass) {
		this.rollno = rollno;
		this.studname = studname;
		this.studclass = studclass;
	}
	
	
	
	public int getRollno() {
		return rollno;
	}
	
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getStudname() {
		return studname;
	}
	
	public void setStudname(String studname) {
		this.studname = studname;
	}
	
	public String getStudclass() {
		return studclass;
	}
	
	public void setStudclass(String studclass) {
		this.studclass = studclass;
	}
	
	
}
