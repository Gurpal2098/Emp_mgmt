package com.adm;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet
{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException 
	 {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        	String id=request.getParameter("empid");  
	            String name=request.getParameter("ename");  
	            String Gender=request.getParameter("gender");  
	            String Designation=request.getParameter("post");  
	            String Salary=request.getParameter("salary");  
	            String Age=request.getParameter("age");  
	            String Phone=request.getParameter("number");  
	            String Password=request.getParameter("password");  
	            Emp e=new Emp();  
	            e.setEid(id);  
	            e.setEname(name);  
	            e.setGender(Gender);  
	            e.setDesignation(Designation);  
	            e.setSalary(Salary);
	            e.setAge(Age);
	            e.setPhone(Phone);
	            e.setPassword(Password); 
	              
	            int status=EmpDao.save(e);  
	            if(status>0){  
	                out.print("<p>Record saved successfully!</p>");  
	                request.getRequestDispatcher("index.html").include(request, response);  
	            }else{  
	                out.println("Sorry! unable to save record");  
	            }  
	        
	        
	 }
}
