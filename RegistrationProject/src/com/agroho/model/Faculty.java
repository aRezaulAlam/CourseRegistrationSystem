package com.agroho.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	
	private int id;
	private String facultyId;
	private String facultyPassword;
	private String name;
	private List<String> skills;
	
	
	public Faculty(String facultyId, String facultyPassword, String name, List skillList) {
		this.facultyId = facultyId;
		this.facultyPassword = facultyPassword;
		this.name = name;
		this.skills = skillList;
	}
	public Faculty() {
		// TODO Auto-generated constructor stub
	}
	public String getFacultyPassword() {
		return facultyPassword;
	}
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	

}
