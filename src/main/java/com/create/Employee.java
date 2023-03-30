package com.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Employee
 */
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");  
		
			PreparedStatement ps=con.prepareStatement("select * from holidays");	 
			ResultSet rs=ps.executeQuery();  
			
			out.print("<html><body><table border='1'><tr><td>S No.</td><td>Date</td><td>Day</td><td>Holiday</td></tr>");
			
			
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4));
			}
			
			out.println("</table></body></html>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
