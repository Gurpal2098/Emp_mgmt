package com.create;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddEmployee")

public class AddEmployee extends HttpServlet {
    
    Connection con;
    PreparedStatement pst;
    int row;
    
    public void doPost(HttpServletRequest req,HttpServletResponse rsp ) throws IOException,ServletException
    {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");
     
        	rsp.setContentType("text/html");
            PrintWriter out = rsp.getWriter();
            String empid = req.getParameter("empid");
            String empname = req.getParameter("empname");
            String gender= req.getParameter("gender");
            String title = req.getParameter("designation");
            String email = req.getParameter("email");
            String salary = req.getParameter("salary");
            String age= req.getParameter("empage");
            String mno = req.getParameter("contactno");
            String pass = req.getParameter("emppass");
            
      
            pst = con.prepareStatement("insert into addemployee(empid,empname,gender,designation,email,salary,age,contactno,password) values(?,?,?,?,?,?,?,?,?) ");
            pst.setString(1, empid);
            pst.setString(2, empname);
            pst.setString(3, gender);
            pst.setString(4, title);
            pst.setString(5, email);
            pst.setString(6, salary);
            pst.setString(7, age);
            pst.setString(8, mno);
            pst.setString(9, pass);
            
            out.println("<font color='green'>  Record Addedddd   </font>");
            RequestDispatcher dispatcher=req.getRequestDispatcher(".html");
            dispatcher.include(req,rsp);
            out.println("successfully add"+row);;
 
            
        }  catch (SQLException ex) {
           
             out.println("<font color='red'>  Record Failed   </font>");
        } 
    }
  
}