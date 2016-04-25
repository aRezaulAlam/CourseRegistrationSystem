package com.agroho.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class CustomDataSource {
	
	private static Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?"
	              + "user=root&password=");
	}
	
	public static void closeConnection() throws SQLException{
		connect.close();
	}

}
