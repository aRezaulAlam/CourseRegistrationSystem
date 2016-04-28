package com.agroho.controller;

import java.util.ArrayList;
import java.util.List;

import com.agroho.dao.CourseDao;
import com.agroho.model.Course;
import com.agroho.service.CourseService;
import com.agroho.model.CourseRegistrationData;
import com.agroho.model.StudentEnrollment;

public class CourseController {

public CourseController(){
		
	}

	public static List<Course> getCourseDetails() {
		
		List<Course> courseList = CourseDao.getCourseDetails();
		for (int i = 0; i < courseList.size(); i++) {
			System.out.println(courseList.get(i).getCourseName());
		}
		
		return courseList;
	}

	public static void registerCourse(String course, String faculty, String description, String timetable,
			String classroom, String admin) {
		CourseService.SaveCourse(course,faculty,description,timetable,classroom, admin);
		
	}

	public List<CourseRegistrationData> getDataForStudentRegistration() {


		List<CourseRegistrationData> dataList = CourseService.getDataForStudentCourseRegistration();
		
		for (int i = 0; i < dataList.size(); i++) {
			System.out.println("Controller: "+dataList.get(i).getFacultyName());
		}
		
		return dataList;
	}

	public void saveStudentCourseRegistration(List<StudentEnrollment> studentCourseRegistrations) {
		
		for (int i = 0; i < studentCourseRegistrations.size(); i++) {
			System.out.println("Controller Student Course registration Rezaul: "+studentCourseRegistrations.get(i).getPermitter());
			System.out.println("Controller Student Course registration Rezaul: "+studentCourseRegistrations.get(i).getRegistered_course_id());
		}
		
		CourseDao.saveStudentCourseRegistration(studentCourseRegistrations);
		
	}

	public List<StudentEnrollment> getStudentEnrollInfoById(String userId) {
		List<StudentEnrollment> enrollmentInfo = CourseService.getStudentEnrollInfoById(userId);
		return enrollmentInfo;
	}

	public List<StudentEnrollment> getStudentListForEnrollmentByFacultyId(String facultyId) {

		List<StudentEnrollment> enrollments = CourseDao.getStudentListForEnrollmentByFacultyId(facultyId);
			
		return enrollments;
	}
}
