package com.agroho.controller;

import java.sql.SQLException;
import java.util.List;

import com.agroho.dao.StudentDao;
import com.agroho.model.Student;
import com.agroho.model.StudentEnrollment;
import com.agroho.service.CourseService;

public class StudentController {
	
	Student student;
	
	public StudentController(Student student){
		
		this.student = student;
	}
	
	public void register() throws ClassNotFoundException, SQLException{
		/*studentDAO.save(student);*/
		System.out.println("Password From Controller"+ student.getPassword());
		StudentDao.save(student);
	}
	
	
	
	public StudentController(){
		
		
	}

	public Student getStudentDetailsById(String userId) {
		
		Student student = StudentDao.getStudentDetailsByID(userId);
		
		return student;
		
		
	}

	
}
