package com.agroho.dao;

import java.util.ArrayList;
import java.util.List;

import com.agroho.model.Course;
import com.agroho.model.CourseRegistrationData;
import com.agroho.model.StudentRegistrationCourses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseDao {
	
		private static Connection connect;
	  private static PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private static Statement statement = null;


	public static List<Course> getCourseDetails() {
		try {
			connect = CustomDataSource.getConnection();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 try {
			statement = connect.createStatement();
			        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		     
		      
		      
		   ResultSet rs = null;
		try {
			rs = statement.executeQuery("select * from course");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		
		List<Course> courseList = new ArrayList<Course>();
			try {
				while(rs.next()){
					Course course = new Course();
					course.setCourseId(rs.getString("courseid"));
					course.setCourseName(rs.getString("coursename"));
					course.setCredit(rs.getLong("credit"));
					courseList.add(course);
					//System.out.println(rs.getString("coursename"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return courseList;
	
	
}


	public static void saveCourse(String course, String faculty, String description, String timetable, String classroom,
			String admin) {
		  
				try {
					connect = CustomDataSource.getConnection();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 try {
					preparedStatement = connect
					          .prepareStatement("INSERT INTO `registered_course`(`course_id`, `faculty_id`, `admin_id`, `classroom`, `timetable`, `description`) VALUES (?,?,?,?,?,?)");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
				      // Parameters start with 1

				      try {
						preparedStatement.setString(1, course);
						preparedStatement.setString(2, faculty);
					    preparedStatement.setString(3, admin);
					    preparedStatement.setString(4, classroom);
						preparedStatement.setString(5, timetable);
					    preparedStatement.setString(6, description);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      
				      
				      try {
					      int rows = preparedStatement.executeUpdate();
					      System.out.println(rows);
					     // System.out.println("DAO Name: "+faculty.getName());

					} catch (Exception e) {
						System.out.println("Error in DB "+e.getMessage());			
						}
				  
				     
				      
				   //   System.out.println(rows+ " rows are effected");
				try {
					CustomDataSource.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}


	public static List<CourseRegistrationData> getRegisteredCourses() {

		try {
			connect = CustomDataSource.getConnection();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 try {
			statement = connect.createStatement();
			        
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		     
		      
		      
		   ResultSet rs = null;
		try {
			rs = statement.executeQuery("SELECT rc.id as id, rc.course_id as course_id,c.coursename as coursename, c.credit as credit, f.facultyname facultyname, rc.faculty_id as faculty_id, rc.admin_id as admin_id, rc.classroom as classroom, rc.timetable as timetable, rc.description as description FROM registered_course rc JOIN course c ON (rc.course_id = c.courseid) JOIN faculty f ON (rc.faculty_id=f.facultyid)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		
		List<CourseRegistrationData> courseList = new ArrayList<CourseRegistrationData>();
			try {
				while(rs.next()){
					CourseRegistrationData courseData = new CourseRegistrationData();
					courseData.setId(rs.getString("id"));
					courseData.setCourseId(rs.getString("course_id"));
					courseData.setCourseName(rs.getString("coursename"));
					courseData.setFacultyId(rs.getString("faculty_id"));
					courseData.setFacultyName(rs.getString("facultyname"));
					courseData.setClassRoom(rs.getString("classroom"));
					courseData.setCourseTimetable(rs.getString("timetable"));
					courseData.setCourseDescription(rs.getString("description"));
					courseData.setCourseCredit(rs.getDouble("credit"));
					System.out.println(rs.getDouble("credit")+" "+rs.getString("facultyname"));
					
					courseList.add(courseData);
					//System.out.println(rs.getString("coursename"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return courseList;
		
	}


	public static void saveStudentCourseRegistration(List<StudentRegistrationCourses> studentCourseRegistrations) {

		try {
			connect = CustomDataSource.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < studentCourseRegistrations.size(); i++) {
			System.out.println(studentCourseRegistrations.get(i));
			 try {
					preparedStatement = connect
					          .prepareStatement("INSERT INTO `student_course_registration`(`registered_course_id`, `studentid`, `permitted`) VALUES ( ?, ?, ?)");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
				      // Parameters start with 1

				      try {
						preparedStatement.setInt(1, studentCourseRegistrations.get(i).getRegistered_course_id());
						preparedStatement.setString(2, studentCourseRegistrations.get(i).getStudentId());
						
						
							preparedStatement.setInt(3, 0);
						
					   
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      
				      
				      try {
					      int rows = preparedStatement.executeUpdate();
					      System.out.println(rows);
					      //System.out.println("DAO Name: "+faculty.getName());

					} catch (Exception e) {
						System.out.println("Error in DB "+e.getMessage());			
						}
		}
      
		      
		   //   System.out.println(rows+ " rows are effected");
		try {
			CustomDataSource.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
