package com.agroho.controller;

import java.sql.SQLException;

import com.agroho.dao.AdminDao;
import com.agroho.dao.FacultyDao;
//import com.agroho.dao.FacultyDao;
import com.agroho.dao.StudentDao;

public class LoginController {
	
	public boolean studentLogin(String studentId,String studentPassword) throws SQLException{
		return StudentDao.getStudentByIdAndPassword(studentId,studentPassword);
	}
	
	public boolean facultyLogin(String facultyId,String facultyPassword) throws SQLException{
		return FacultyDao.getFacultyByIdAndPassword(facultyId,facultyPassword);
	}
	
	public boolean adminLogin(String adminId,String adminPassword) throws SQLException{
		return AdminDao.getAdminByIdAndPassword(adminId,adminPassword);
	}

}
