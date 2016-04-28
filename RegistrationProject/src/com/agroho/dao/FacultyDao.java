package com.agroho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agroho.model.Faculty;
import com.agroho.model.Student;

public class FacultyDao {
	
	private static Connection connect;
	  private static PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private static Statement statement = null;
	  
	public static void save(Faculty faculty){
		  
		try {
			connect = CustomDataSource.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			preparedStatement = connect
			          .prepareStatement("insert into  faculty(facultyid,facultyname,facultypassword) values ( ?, ?, ?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      try {
				preparedStatement.setString(1, faculty.getFacultyId());
				preparedStatement.setString(2, faculty.getName());
			    preparedStatement.setString(3, faculty.getFacultyPassword());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      
		      try {
			      int rows = preparedStatement.executeUpdate();
			      System.out.println(rows);
			      System.out.println("DAO Name: "+faculty.getName());

			} catch (Exception e) {
				System.out.println("Error in DB "+e.getMessage());			
				}
		  
		      List<String> skills = faculty.getSkills();
				System.out.println("And Skills are inserting to DB: ");
				for (int i = 0; i < skills.size(); i++) {
					System.out.println(skills.get(i));
					 try {
							preparedStatement = connect
							          .prepareStatement("insert into  faculty_skills(facultyid,courseid) values ( ?, ?)");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
						      // Parameters start with 1

						      try {
								preparedStatement.setString(1, faculty.getFacultyId());
								preparedStatement.setString(2, skills.get(i));
							   
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
	
	public static boolean getFacultyByIdAndPassword(String facultyId, String facultyPassword)  {
		int flag = 0;
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
			         // .prepareStatement("select studentid, password from student");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      
		      
		   ResultSet rs = null;
		try {
			rs = statement.executeQuery("select count(*), facultyid, facultypassword from faculty where facultyid="+facultyId+" and facultypassword="+facultyPassword);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		   //   System.out.println(rows+ " rows are effected");

		try {
			while(rs.next()){
				int rows = rs.getInt(1);
				String fid = rs.getString("facultyid");
				String fpassword = rs.getString("facultypassword");
				
				System.out.println("DB get: "+fid+" "+fpassword);
				System.out.println("User get: "+facultyId+" "+facultyPassword);
				System.out.println("ROws: t: "+ rows);
				
				if (rows<1) {
					try {
						CustomDataSource.closeConnection();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				}
				
				if (facultyId.equals(fid) && facultyPassword.equals(fpassword) ){
					flag = 1;
					System.out.println("Equal");
				} else {
					flag = 0;
					System.out.println("Not Equal");
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			CustomDataSource.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (flag==0) {
			return false;
		} else {
			return true;
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	public static List<Faculty> getFacultyByCourseCode(String courseCode) {
		
		List<Faculty> facultyList = new ArrayList<Faculty>();
		int flag = 0;
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
			         // .prepareStatement("select studentid, password from student");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      
		      
		   ResultSet rs = null;
		try {
			
			System.out.println("Course Code"+courseCode);
			if (courseCode.equals("CSE201")) {
				System.out.println("True");
			}
			
			rs = statement.executeQuery("SELECT facultyname as fname, facultyid as fid FROM faculty where facultyid IN (SELECT `facultyid` FROM `faculty_skills` WHERE `courseid`='"+courseCode+"')");
			System.out.println("Executing Query");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		   //   System.out.println(rows+ " rows are effected");

		try {
			while(rs.next()){
				Faculty faculty = new Faculty();
				faculty.setName(rs.getString("fname")); 
				faculty.setFacultyId(rs.getString("fid")); 
				System.out.println(rs.getString("fid"));
				facultyList.add(faculty);
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
			
		
		
		try {
			CustomDataSource.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return facultyList;
	}

	public static Faculty getFacultyDetailsById(String facultyId) {
		int flag = 0;
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
			         // .prepareStatement("select studentid, password from student");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      
		      
		   ResultSet rs = null;
		try {
			rs = statement.executeQuery("select * from faculty where facultyid='"+facultyId+"'");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		      
		   //   System.out.println(rows+ " rows are effected");
		   
			String facultyID = "";
			String password = "";
			String name = "";
			
		
		try {
			while(rs.next()){
				facultyID = rs.getString("facultyid");
				 password = rs.getString("facultypassword");
				 name = rs.getString("facultyname");
				 
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			CustomDataSource.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			CustomDataSource.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Faculty faculty = new Faculty();
		faculty.setFacultyId(facultyID);
		faculty.setFacultyPassword(password);
		faculty.setName(name);
		
		return faculty;
	}

	

}
