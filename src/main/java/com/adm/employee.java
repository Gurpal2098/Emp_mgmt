package com.adm;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import javax.swing.*;
import java.io.*;

public class employee extends HttpServlet
{
	Connection con;
    PreparedStatement pst;
    int row;
    public void doPost(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {
        
        rsp.setContentType("text/html");
        PrintWriter out = rsp.getWriter();
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");
        	
//        	Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			String empid = req.getParameter("empid");
			String ename= req.getParameter("ename");
			String Gender = req.getParameter("gender");
			String Designation = req.getParameter("post");
			String Salary = req.getParameter("salary");
			String Age = req.getParameter("age");
			String Phone = req.getParameter("number");
			String Pass = req.getParameter("empid");
			 pst = con.prepareStatement("insert into empadd(eid,ename,gender,designation,salary,age,phone,password)values(?,?,?,?,?,?,?,?)");
			 pst.setString(1, empid);
	            pst.setString(2, ename);
	            pst.setString(3, Gender);
	            pst.setString(4,Designation );
	            pst.setString(5, Salary);
	            pst.setString(6, Age);
	            pst.setString(7,Phone );
	            pst.setString(8,Pass );
	           row = pst.executeUpdate();
	           out.println("<font color='green'>  Record Addedddd   </font>");
        }
        catch(Exception e)
        {
        	 out.println("<font color='red'>  Record Failed   </font>");
        }
    }
}
