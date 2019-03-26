package com.product.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.ProductDb;
public class ProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String pid1=request.getParameter("pid");
		int pid=Integer.parseInt(pid1);
		System.out.println("pid= "+pid);
		
		String name=request.getParameter("name");
		System.out.println("name= "+name);
		
		String price1=request.getParameter("price");
		double price=Double.parseDouble(price1);
		System.out.println("price= "+price);
		
		if(pid1!=null && price1.trim()!="" && name.trim()!=""){
			ProductDb db=new ProductDb();
			boolean b =db.checkProductDetails(pid);
			if(!b) {
				Connection con=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
				    con = DriverManager.getConnection("jdbc:mysql://localhost/shruthidb", "shruthi", "abc");
					PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
					ps.setInt(1,pid);
					ps.setString(2,name);
					ps.setDouble(3,price);
					
					int i = ps.executeUpdate();
					if(i>0) {
						System.out.println("inserted successfully"); 
						request.setAttribute("pid",pid);
						request.setAttribute("name",name);
						request.setAttribute("price",price);
						request.getRequestDispatcher("successmsg.jsp").include(request,response);
					}
					else {
						System.out.println("not inserted");
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					if (con != null) {
						try {
							con.close();
						} 
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				
			}
			else {
				out.println("Trying to duplicate insertion");
				request.getRequestDispatcher("index.jsp").include(request,response);
			}
		}
		}

	}

