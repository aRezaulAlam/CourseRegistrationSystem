package com.agroho.model;

public class StudentEnrollment {
	
	private int id;
	
	private int registered_course_id;
	
	private String CourseId;
	
	private String CourseName;
	
	public String getCourseId() {
		return CourseId;
	}

	public void setCourseId(String courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	private String studentId;
	
	private String StudentName;
	
		
	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	private Boolean permitter;
	
	private String acceptedStatus;
	
	private String facultyName;
	
	private double courseCredit;
	
	
	
	public double getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(double courseCredit) {
		this.courseCredit = courseCredit;
	}

	private String room;
	
	private String time;
	
	
	
	public String getAcceptedStatus() {
		return acceptedStatus;
	}

	public void setAcceptedStatus(String acceptedStatus) {
		this.acceptedStatus = acceptedStatus;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

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
