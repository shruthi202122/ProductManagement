package com.product;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductDb {
	public boolean checkProductDetails(int pid) {
		
		Connection connection=null;
		boolean i=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/shruthidb","shruthi","abc");
			PreparedStatement preparedStatement=connection.prepareStatement("select pid from product where pid=?");
			preparedStatement.setInt(1,pid);
			ResultSet rs=preparedStatement.executeQuery();
			
			if(rs.next()) { 
				System.out.println("Product already existed in db");
			    i=true;
			}
			else {
				System.out.println("new product"); 
				 i=false;
				 return i;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		finally{ 
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return i;
	}	
	public boolean insertProductDetails(int pid,String name,double price) {
		Connection connection=null;
		boolean insertion=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost/shruthidb", "shruthi", "abc");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into product values(?,?,?)");
			preparedStatement.setInt(1,pid);
			preparedStatement.setString(2,name);
			preparedStatement.setDouble(3,price);
			
			int i = preparedStatement.executeUpdate();
			if(i>0) {
				System.out.println("inserted successfully"); 
				insertion=true;
			}
			else {
				System.out.println("not inserted");
				insertion = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertion; 
	}	
}
