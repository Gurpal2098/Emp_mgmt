
package com.adm;
import java.sql.*;
import java.util.*;
public class EmpDao 
{
	public static Connection getConnection(){  
        Connection con=null;  
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");
        	
            //Class.forName("oracle.jdbc.driver.OracleDriver");  
            //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into empadd(eid,ename,gender,designation,salary,age,phone,password) values (?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getEid());  
            ps.setString(2,e.getEname());  
            ps.setString(3,e.getGender());  
            ps.setString(4,e.getDesignation());  
            ps.setString(5, e.getSalary());
            ps.setString(6, e.getAge());
            ps.setString(7,e.getPhone());
            ps.setString(8,e.getPassword());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update add set eid=?,ename=?,gender=?,designation=?,salary=?,age=?,phone=?,password=? where eid=?");  
            ps.setString(1,e.getEid());  
            ps.setString(2,e.getEname());  
            ps.setString(3,e.getGender());  
            ps.setString(4, e.getDesignation());  
            ps.setString(5,e.getSalary());  
            ps.setString(6, e.getAge());
            ps.setString(7,e.getPhone());
            ps.setString(8,e.getPassword());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from empadd where eid=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from empadd where eid=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setEid(rs.getString(1));  
                e.setEname(rs.getString(2));  
                e.setGender(rs.getString(3));  
                e.setDesignation(rs.getString(4));  
                e.setSalary(rs.getString(5)); 
                e.setAge(rs.getString(6)); 
                e.setPhone(rs.getString(7)); 
                e.setPassword(rs.getString(8)); 
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from empadd");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setEid(rs.getString(1));  
                e.setEname(rs.getString(2));  
                e.setGender(rs.getString(3));  
                e.setDesignation(rs.getString(4));  
                e.setSalary(rs.getString(5)); 
                e.setAge(rs.getString(6)); 
                e.setPhone(rs.getString(7)); 
                e.setPassword(rs.getString(8));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
