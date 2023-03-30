package com.adm;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException
	
	{  
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href=''>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
        List<Emp> list=EmpDao.getAllEmployees();  
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Gender</th><th>Designation</th><th>Salary</th><th>Age</th><th>Phone No</th><th>Password</th>  <th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){  
         out.print("<tr><td>"+e.getEid()+"</td><td>"+e.getEname()+"</td><td>"+e.getGender()+"</td>  <td>"+e.getDesignation()+"</td><td>"+e.getSalary()+"</td><td>"+e.getAge()+"</td><td>"+e.getPhone()+"</td><td>"+e.getPassword()+ "</td><td><a href='EditServlet?id="+e.getEid()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getEid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>"); 
        out.close();  
          
}
}
