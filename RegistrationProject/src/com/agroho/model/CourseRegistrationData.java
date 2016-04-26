package com.agroho.model;

public class CourseRegistrationData {

	//"CSE308", "Apple", "Morshed Hasan", new Double(7.35), true
	
	public String id;
	
	private String courseId;
	
	private String courseName;
	
	private String facultyName;
	
	private Double courseCredit;
	
	private Boolean coursePermitted;
	
	private String courseDescription;
	
	private String courseTimetable;
	
	private String classRoom;
	
	public String getCourseTimetable() {
		return courseTimetable;
	}

	public void setCourseTimetable(String courseTimetable) {
		this.courseTimetable = courseTimetable;
	}

	
	
	
	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	private String facultyId;
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

	
	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public Double getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(Double courseCredit) {
		this.courseCredit = courseCredit;
	}

	public Boolean getCoursePermitted() {
		return coursePermitted;
	}

	public void setCoursePermitted(Boolean coursePermitted) {
		this.coursePermitted = coursePermitted;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	
	
	
	
	
	
}
