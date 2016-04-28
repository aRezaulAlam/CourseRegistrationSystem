package com.agroho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DummyRegistration {

	private static Connection connect;
	private Statement statement = null;
	  private static PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				
		connect = CustomDataSource.getConnection();
		 preparedStatement = connect
		          .prepareStatement("insert into  student(studentid,name,password,course,mobile,test) values ( ?, ?, ?, ? , ?, ?)");
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1
		      preparedStatement.setLong(1, 12201051);
		      preparedStatement.setString(2, "Name");
		      preparedStatement.setString(3, "Password");
		      preparedStatement.setString(4,"Course");
		      preparedStatement.setLong(5, 1515667948);
		      preparedStatement.setLong(6, 5234523);
		      int rows = preparedStatement.executeUpdate();
		      
		      System.out.println(rows+ "are effected");
		CustomDataSource.closeConnection();
	}

}
