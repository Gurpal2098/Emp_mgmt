package com.adm;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)   
	          throws ServletException, IOException {  
	        res.setContentType("text/html");  
	        PrintWriter out=res.getWriter();  
//	        	String sid=req.getParameter("id");  
//	       int id=Integer.parseInt(sid);  
	        String empid = req.getParameter("empid");
			String ename= req.getParameter("ename");
			String Gender = req.getParameter("gender");
			String Designation = req.getParameter("post");
			String Salary = req.getParameter("salary");
			String Age = req.getParameter("age");
			String Phone = req.getParameter("number");
			String Pass = req.getParameter("password"); 
	          
	        Emp e=new Emp();  
	        e.setEid(empid);  
            e.setEname(ename);  
            e.setGender(Gender);  
            e.setDesignation(Designation);  
            e.setSalary(Salary);
            e.setAge(Age);
            e.setPhone(Phone);
            e.setPassword(Pass); 
            int status=EmpDao.update(e);  
            if(status>0){  
                res.sendRedirect("ViewServlet");  
            }else{  
                out.println("Sorry! unable to update record");  
            }  
              
            out.close();  
	}
}
