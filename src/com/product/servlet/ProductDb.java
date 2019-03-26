package com.product.servlet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ProductDb {
	public boolean checkProductDetails(int pid) {
		
		Connection con=null;
		boolean i=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/shruthidb","shruthi","abc");
			PreparedStatement ps=con.prepareStatement("select pid from product where pid=?");
			ps.setInt(1,pid);
			ResultSet rs=ps.executeQuery();
			
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
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return i;
	}		
}
