package com.agroho.service;

import java.util.List;
import java.util.StringTokenizer;

import com.agroho.dao.CourseDao;
import com.agroho.model.Course;
import com.agroho.model.CourseRegistrationData;

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

}
