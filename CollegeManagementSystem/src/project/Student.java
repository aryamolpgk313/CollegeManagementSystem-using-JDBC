package project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	         Connectionmanager3 con=new Connectionmanager3();
	         Scanner s=new Scanner(System.in);
	         int ch;
	public void studentData() throws ClassNotFoundException,SQLException
	{
		do {
		System.out.println("1)Student Login\n2)Logout");
		System.out.println("Enter the choice");
		  ch=s.nextInt();
		  
		switch(ch)
		{
		case 1:		
		Statement s1=con.getConnection().createStatement();
		System.out.println("Enter the username");
		String user=s.next();
		System.out.println("Enter the password");
	    String pass=s.next();
	    ResultSet r=s1.executeQuery("select * from studentlogin");
	    while(r.next())
	    {
	    String name1=r.getString(1);
	    String pw1=r.getString(2);
	   
	    if(name1.equals(user)&&pw1.equals(pass))
	    {
	    
	    	System.out.println("Student Verified");
	    	Statement s2=con.getConnection().createStatement();
	    	ResultSet rs=s2.executeQuery("select * from studentdetails");
	    	while(rs.next())
	    	{
	    	System.out.println("Student Details");
	    	System.out.println("###########*******###########");
    		System.out.println("Student ID ->"+rs.getInt(1));//print value
    		System.out.println("Student Name ->"+rs.getString(2));
    		System.out.println("Department ->"+rs.getString(3));
    		System.out.println("Paper1 ->"+rs.getInt(4));
    		System.out.println("Paper2 ->"+rs.getInt(5));
    		System.out.println("Paper3 ->"+rs.getInt(6));
    		System.out.println("Paper4 ->"+rs.getInt(7));
    		System.out.println("Paper5 ->"+rs.getInt(8));
    		System.out.println("Attendance ->"+rs.getInt(9));
    		System.out.println("###########*******###########");
	       }
	    
	    }
	    else
	    {
	    	System.out.println("Login failed");
	    }
	    }
	    break;
		case 2:
		System.out.println("Student logout");
		Collegemanagement cm=new Collegemanagement();
		cm.login();	
		con.getConnection().close();	
		break;
		
		}
		}while(ch!=0);
		
		
			
	}
}
	    
	


