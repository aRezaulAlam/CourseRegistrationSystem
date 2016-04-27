package com.agroho.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.agroho.model.Student;

public class StudentDao {
	
	private static Connection connect;
	  private static PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private static Statement statement = null;
	  
	public static void save(Student student) throws ClassNotFoundException, SQLException{
		  
		connect = CustomDataSource.getConnection();
		 preparedStatement = connect
		          .prepareStatement("insert into  student(studentid,name,password,major,mobile) values ( ?, ?, ?, ? , ?)");
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      preparedStatement.setString(1, student.getStudentId());
		      preparedStatement.setString(2, student.getName());
		      preparedStatement.setString(3, student.getPassword());
		      preparedStatement.setString(4,student.getMajor());
		      preparedStatement.setString(5, student.getMobile());
		      
		      try {
			      int rows = preparedStatement.executeUpdate();
			      System.out.println(rows);
			      System.out.println("DAO Password: "+student.getPassword());

			} catch (Exception e) {
				System.out.println("Error in DB "+e.getMessage());			}

		      
		   //   System.out.println(rows+ " rows are effected");
		CustomDataSource.closeConnection();
		
	}

	public static boolean getStudentByIdAndPassword(String studentId, String studentPassword) throws SQLException {
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

		      
		      
		   ResultSet rs = statement.executeQuery("select studentid, password from student where studentid='"+studentId+"' and password='"+studentPassword+"'");
		      
		   //   System.out.println(rows+ " rows are effected");
		
		while(rs.next()){
			String userid = rs.getString("studentid");
			String password = rs.getString("password");
			
			System.out.println("DB get: "+userid+" "+password);
			System.out.println("User get: "+studentId+" "+studentPassword);

			
			if (studentId.equals(userid) && studentPassword.equals(password) ){
				flag = 1;
				System.out.println("Equal");
			} else {
				flag = 0;
				System.out.println("Not Equal");
			}
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
		
		
		
		if (flag==0) {
			return false;
		} else {
			return true;
		}
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	public static Student getStudentDetailsByID(String userId) {
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
			rs = statement.executeQuery("select * from student where studentid='"+userId+"'");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		      
		   //   System.out.println(rows+ " rows are effected");
		   
			String studentId = "";
			String password = "";
			String name = "";
			String major = "";
			String mobile = "";
		
		try {
			while(rs.next()){
				 studentId = rs.getString("studentid");
				 password = rs.getString("password");
				 name = rs.getString("name");
				 major = rs.getString("major");
				 mobile = rs.getString("mobile");
				
				
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
		
		Student student = new Student();
		student.setStudentId(userId);
		student.setName(name);
		student.setMajor(major);
		student.setMobile(mobile);
		student.setPassword(password);
		
		
		return student;
	}

}
