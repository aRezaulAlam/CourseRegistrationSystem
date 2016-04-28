package com.agroho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.agroho.model.Admin;

public class AdminDao {

	private static Connection connect;
	  private static PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	  private static Statement statement = null;
	
	public static void save(Admin admin) {
		
		try {
			connect = CustomDataSource.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			preparedStatement = connect
			          .prepareStatement("insert into  admin(adminid,adminname,adminpassword, adminrole) values ( ?, ?, ?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		      // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
		      // Parameters start with 1

		      try {
				preparedStatement.setString(1, admin.getAdminUserId());
				preparedStatement.setString(2, admin.getAdminName());
			    preparedStatement.setString(3, admin.getAdminPassword());
			    preparedStatement.setString(4, admin.getAdminRole());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      
		      try {
			      int rows = preparedStatement.executeUpdate();
			      System.out.println(rows);
			      System.out.println("DAO Name: "+admin.getAdminRole());

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

	public static boolean getAdminByIdAndPassword(String adminId, String adminPassword) {
		
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
			rs = statement.executeQuery("select count(*), adminid, adminpassword from admin where adminid='"+adminId+"' and adminpassword='"+adminPassword+"'");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		   //   System.out.println(rows+ " rows are effected");

		try {
			while(rs.next()){
				int rows = rs.getInt(1);
				String aid = rs.getString("adminid");
				String apassword = rs.getString("adminpassword");
				
				System.out.println("DB get: "+aid+" "+apassword);
				System.out.println("User get: "+adminId+" "+adminPassword);
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
				
				if (adminId.equals(aid) && adminPassword.equals(apassword) ){
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
		
		
		
	}

}
