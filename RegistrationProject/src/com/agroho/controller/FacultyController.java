package com.agroho.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.agroho.dao.CourseDao;
import com.agroho.dao.FacultyDao;
import com.agroho.dao.StudentDao;
import com.agroho.model.Course;
import com.agroho.model.Faculty;
import com.agroho.model.Student;
import com.agroho.model.StudentEnrollment;

public class FacultyController {
	
Faculty faculty;
	
	public FacultyController(Faculty faculty){
		
		this.faculty = faculty;
	}
	
	public void register() throws ClassNotFoundException, SQLException{
		/*studentDAO.save(student);*/
		System.out.println("Password From Controller"+ faculty.getFacultyPassword());
		
		List<String> skills = faculty.getSkills();
		System.out.println("And Skills are: ");
		for (int i = 0; i < skills.size(); i++) {
			System.out.println(skills.get(i));
					}
		
		FacultyDao.save(faculty);
		//StudentDao.save(student);
	}
	
/*	public boolean checkLogin(long studentId,String studentPassword) throws SQLException{
		return StudentDao.getStudentByIdAndPassword(studentId,studentPassword);
	}
	*/
	public FacultyController(){
		
		
	}

	public static List<String> getFacultyByCourseId(String courseCode) {
		
		List<Faculty> faculties = FacultyDao.getFacultyByCourseCode(courseCode);
		List<String> facultiesName = new ArrayList<String>();
		System.out.println("And Faculties are: ");
		for (int i = 0; i < faculties.size(); i++) {
			System.out.println(faculties.get(i).getName());
			facultiesName.add(faculties.get(i).getName()+"-"+faculties.get(i).getFacultyId());
					}
		return facultiesName;


		
		
	}

	public Faculty getFacultyDetailsById(String facultyId) {
		Faculty faculty = FacultyDao.getFacultyDetailsById(facultyId);
		
		return faculty;
	}

	public void updateStudentEnrollmentbyFaculty(List<StudentEnrollment> studentCourseRegistrations) {

		CourseDao.updateStudentEnrollmentbyFaculty(studentCourseRegistrations);
		
	}

	}
