package com.adm;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	          
	        Emp e=EmpDao.getEmployeeById(id);  
	        out.print("<form action='EditServlet2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='empid' value='"+e.getEid()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='ename' value='"+e.getEname()+"'/></td></tr>");  
	        out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/>   </td></tr>");  
	        out.print("<tr><td>Designation:</td><td><input type='text' name='post' value='"+e.getDesignation()+"'/></td></tr>");  
	        out.print("<tr><td>Salary:</td><td><input type='number' name='salary' value='"+e.getSalary()+"'/></td></tr>");  
	        out.print("<tr><td>Age:</td><td><input type='number' name='age' value='"+e.getAge()+"'/></td></tr>");  
	        out.print("<tr><td>Phone No:</td><td><input type='number' name='number' value='"+e.getPhone()+"'/>   </td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>"); 
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	        out.close();  
	           
	}
}
