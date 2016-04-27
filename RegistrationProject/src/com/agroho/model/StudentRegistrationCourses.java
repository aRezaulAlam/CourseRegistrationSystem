package com.agroho.model;

public class StudentRegistrationCourses {
	
	private int id;
	
	private int registered_course_id;
	
	private String studentId;
	
	private Boolean permitter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegistered_course_id() {
		return registered_course_id;
	}

	public void setRegistered_course_id(int registered_course_id) {
		this.registered_course_id = registered_course_id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Boolean getPermitter() {
		return permitter;
	}

	public void setPermitter(Boolean permitter) {
		this.permitter = permitter;
	}
	
	
	

}
