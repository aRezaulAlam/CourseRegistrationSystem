package com.agroho.controller;

import java.sql.SQLException;
import java.util.List;

import com.agroho.dao.AdminDao;
import com.agroho.dao.FacultyDao;
import com.agroho.model.Admin;
import com.agroho.model.Faculty;

public class AdminController {
	
Admin admin;
	
	 public AdminController(Admin admin) {
		 
		 this.admin = admin;
	 }
	public void register() throws ClassNotFoundException, SQLException{
		System.out.println("Password From Controller"+ admin.getAdminName());
		AdminDao.save(admin);
	}
	
/*	public boolean checkLogin(long studentId,String studentPassword) throws SQLException{
		return StudentDao.getStudentByIdAndPassword(studentId,studentPassword);
	}
	*/
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
}
