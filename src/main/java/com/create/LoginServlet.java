package com.create;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)throws IOException , ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
        //String type=req.getParameter("type");
		String user=req.getParameter("username");	
		String password=req.getParameter("password");
//		HttpSession session=req.getSession();
//		session.setAttribute("name",user);
		
		try{
			int flag=0;
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");  
		
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select username,password from emp");  
			
			
			
			         while(rs.next()){
				         if(user.equals(rs.getString(1))&& password.equals(rs.getString(2))){
					     //out.println("welcome ");
				        	 Statement stmts=con.createStatement();  
//				        	 PreparedStatement p=con.prepareStatement("select * from holidays");	 
				 			 ResultSet r=stmts.executeQuery("select * from holidays");  
				 			
				 			out.print("<html><body><table border='1'><tr><td>S No.</td><td>Date</td><td>Day</td><td>Holiday</td></tr>");
				 			
				 			
				 			while(r.next()) {
				 				out.println("<tr><td>"+r.getString(1)+"</td><td>"+r.getString(2)+"</td><td>"+r.getString(3)+"</td><td>"+r.getString(4)+"</td></tr>");
				 			}
				 			
				 			out.println("</table></body></html>");
					 
					     RequestDispatcher dispatcher=req.getRequestDispatcher("Details.html");//next.java
					     dispatcher.include(req,res);
					     flag=1;
					     break;
						 }
					 }
			
				
			  
			
				
				if(flag==0){
					JOptionPane.showMessageDialog(null,"invalid username or password","Alert Message",JOptionPane.WARNING_MESSAGE);
					RequestDispatcher dispatcher=req.getRequestDispatcher("index.html");
					dispatcher.include(req,res);
				
				
				}
			
		}
					
					
		
		catch(Exception e){
			System.out.println(e);
		}
			
}
	}

