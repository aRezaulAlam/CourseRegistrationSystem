package com.agroho.service;

import java.util.List;
import java.util.StringTokenizer;

import com.agroho.dao.CourseDao;
import com.agroho.model.Course;
import com.agroho.model.CourseRegistrationData;
import com.agroho.model.StudentEnrollment;

public class CourseService {

	public static void SaveCourse(String course, String faculty, String description, String timetable,
			String classroom, String admin) {

		System.out.println("Cousre: "+course);
		System.out.println("Faculty: "+faculty);
		System.out.println("Time: "+timetable);
		System.out.println("Description: "+description);
		System.out.println("classroom: "+classroom);
		System.out.println("admin: "+admin);
		String courseCode = "";
		StringTokenizer st2 = new StringTokenizer(course, "-");
		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
			courseCode = (String) st2.nextElement();
			System.out.println("code:"+courseCode);
		}
		
		String facultyCode = "";
		StringTokenizer str2 = new StringTokenizer(faculty, "-");
		while (str2.hasMoreElements()) {
			System.out.println(str2.nextElement());
			facultyCode = (String) str2.nextElement();
			System.out.println("code:"+facultyCode);
		}
		
		CourseDao.saveCourse(courseCode,facultyCode,description,timetable,classroom, admin);
		
	}

	public static List<CourseRegistrationData> getDataForStudentCourseRegistration() {
		
		List<CourseRegistrationData> data = CourseDao.getRegisteredCourses();
		
		
		for (int i = 0; i < data.size(); i++) {
			System.out.println("Service: "+data.get(i).getFacultyName());
		}
		
		return data;
	}

	public static List<StudentEnrollment> getStudentEnrollInfoById(String userId) {
		
		List<StudentEnrollment> studentEnrollments = CourseDao.getStudentEnrollmentDetailsById(userId);
		//SELECT scr.`registered_course_id`, rc.course_id, fc.facultyname , rc.classroom, rc.timetable , scr.`permitted` FROM `student_course_registration` scr JOIN registered_course rc ON (scr.`registered_course_id` = rc.id) JOIN faculty fc ON (rc.faculty_id=fc.facultyid) WHERE scr.studentid='12201051' 
		return studentEnrollments;
	}

}
