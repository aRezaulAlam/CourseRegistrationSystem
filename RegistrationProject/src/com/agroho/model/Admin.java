package com.agroho.model;

public class Admin {
	
	private long adminId;
	private String adminName;
	private String adminUserId;
	private String adminPassword;
	private String adminRole;
	
	
	public Admin(String adminName, String adminUserId, String adminPassword, String adminRole) {
	
		this.adminName = adminName;
		this.adminUserId = adminUserId;
		this.adminPassword = adminPassword;
		this.adminRole = adminRole;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	
	

}
