package com.techpalle;

import java.sql.SQLException;

import com.techpalle.model.A;

public class MyProgram {

	public static void main(String[] args) {
           A a = new A();
          // a.creating();
            try
            {
		      a.inserting("Arun", 50000, "arun@gmail.com");
        	  a.inserting("Bala", 7000, "bala@gmail.com");
        	  a.updating(3, "Santu", 70000, "santosh@gmail.com");
        	  a.deleting(3, "santa", 70000, "santosh@gmail.com");
		    } 
            catch (ClassNotFoundException e)
           {
			e.printStackTrace();
		   }
          catch (SQLException e)
          {
			//e.printStackTrace();
		  }
	} 

}
