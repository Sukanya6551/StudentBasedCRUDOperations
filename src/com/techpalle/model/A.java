package com.techpalle.model;

import java.sql.*;

public class A 
{
  Connection con = null;
  Statement s = null;
  PreparedStatement ps = null;
  
  public static String url = "jdbc:mysql://localhost:3306/jdbc1";
  public static String username = "root";
  public static String password = "sqlserver@123";
  
  public void creating()
  {
	  try
	  {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con= DriverManager.getConnection(url, username, password);
         s= con.createStatement();
         s.executeUpdate("create table emp1(eid int primary key auto_increment, "
         		+ "ename varchar(40) not null, esal int, email varchar(80) unique)");
	  } 
	  catch (ClassNotFoundException e) 
	  {
		e.printStackTrace();
	  }
	  catch (SQLException e)
	  {
		e.printStackTrace();
	  }
	  finally
	  {
		  try
		  {
			  if(s != null)
			  {
			     s.close();
			  }
		  } 
		  catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		  try 
		  {
			  if(con != null)
			  {
			     con.close();
			  }
		  } 
		 catch (SQLException e)
		  {
			e.printStackTrace();
		  }
	  }
  }
  public void inserting(String name, int sal, String mail) throws ClassNotFoundException, SQLException
  {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 con = DriverManager.getConnection(url, username, password);
	 
	 ps = con.prepareStatement("insert into emp1(ename, esal, email) values (?,?,?)");
	 
	 ps.setString(1, name);
	 ps.setInt(2, sal);
	 ps.setString(3, mail);
	 
	 ps.executeUpdate();
	 ps.close();
	 con.close();
  }
  public void updating(int id, String name, int sal, String mail) throws ClassNotFoundException, SQLException
  {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection(url, username, password);
	 ps =  con.prepareStatement("update emp set ename = ?, esal=?, email=?, where eid = ?");
	 
	 ps.setString(1, name);
	 ps.setInt(2, sal);
	 ps.setString(3, mail);
	 ps.setInt(4, id);
	 
	 ps.executeUpdate();
	 ps.close();
	 con.close();
  }
  public void deleting(int id, String name, int sal, String mail) throws ClassNotFoundException, SQLException
  {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection(url, username, password);
	 ps =  con.prepareStatement("delete from emp1 where eid = ?");
	 
	 
	 ps.setInt(1, id);
	 
	 ps.executeUpdate();
	 ps.close();
	 con.close();
  }
  
}
