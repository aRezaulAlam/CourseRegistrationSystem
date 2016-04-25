package com.agroho.controller;

import java.util.ArrayList;
import java.util.List;

import com.agroho.dao.CourseDao;
import com.agroho.model.Course;
import com.agroho.service.CourseService;

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
}
