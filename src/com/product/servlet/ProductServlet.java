package com.product.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.InsertProduct;
import com.product.ProductDb;
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			boolean isProductExists =db.checkProductDetails(pid);
			if(!isProductExists) {
				InsertProduct insertProduct=new InsertProduct();
				boolean insertion=insertProduct.insertProductDetails(pid,name,price);
				if(insertion) {
					request.setAttribute("pid",pid);
					request.setAttribute("name",name);
					request.setAttribute("price",price);
					request.getRequestDispatcher("/view/successmsg.jsp").include(request,response);
				}
				
			}
			else {
				request.setAttribute("errmsg","Trying to insert duplicate values");
				request.getRequestDispatcher("/index.jsp").include(request,response);
			}
		}
		}

	}

