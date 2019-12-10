package project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {
	Connectionmanager3 con=new Connectionmanager3();
	
	public void adminData()throws SQLException, ClassNotFoundException 
	{
		Scanner s=new Scanner(System.in);
		int n,c,t=0;
		System.out.println("Enter the username");
		String user1=s.next();
		System.out.println("Enter the password");
		String pwd1=s.next();
		Statement s1=(Statement) con.getConnection().createStatement();
		ResultSet rs=s1.executeQuery("select * from adminlogin");
		while(rs.next())
		{
		if(rs.getString(1).equals(user1)&&rs.getString(2).equals(pwd1))
		{
		System.out.println("Welcome to admin login");
		do
		{
		System.out.println("1)Insert staff\n2)View\n3)Update staff\n4)Delete staff\n5)Logout");
		System.out.println("enter the choice");
		n=s.nextInt();
		switch(n)
		{
		case 1:
		System.out.println("Enter the staff id");
		int sid=s.nextInt();
		System.out.println("Enter the staff name");
		String sname=s.next();
		System.out.println("Enter the department");
		String sdep=s.next();
		System.out.println("Enter the salary");
		int salary=s.nextInt();
		System.out.println("Enter the attendance");
		int num=s.nextInt();
		PreparedStatement ps=con.getConnection().prepareStatement("insert into staffdetails(Staffid,name,department,Salary,attendance)values(?,?,?,?,?)");
		ps.setInt(1,sid);
		ps.setString(2,sname);
		ps.setString(3,sdep);
		ps.setInt(4,salary);
		ps.setInt(5,num);
		ps.executeUpdate();
		System.out.println("Staff details added successfully");
		con.getConnection().close();
		break;
		case 2: 
		System.out.println("1)View staff\n2)View student\n3)exit");
		System.out.println("enter the choice");
		c=s.nextInt();
		if(c==1)
		{
		Statement st1=(Statement) con.getConnection().createStatement();
		ResultSet rs1=st1.executeQuery("Select * from staffdetails");
		while(rs1.next())
		{
		System.out.println("Staff id:"+rs1.getInt(1));
		System.out.println("Staff name:"+rs1.getString(2));
		System.out.println("Department:"+rs1.getString(3));
		System.out.println("Salary:"+rs1.getInt(4));
		System.out.println("Attendance:"+rs1.getInt(5)); 
		System.out.print("*****************************");
		System.out.println();
		}
		}
		else if(c==2)
		{
		Statement st2=(Statement) con.getConnection().createStatement();
		ResultSet rs2=st2.executeQuery("Select * from studentdetails");
		while(rs2.next())
		{
		System.out.println("Sudent id:"+rs2.getInt(1));
		System.out.println("Student name name:"+rs2.getString(2));
		System.out.println("Department:"+rs2.getString(3));
		System.out.println("paper 1"+rs2.getInt(4));
		System.out.println("paper 1"+rs2.getInt(5));
		System.out.println("paper 1"+rs2.getInt(6));
		System.out.println("paper 1"+rs2.getInt(7));
		System.out.println("paper 1"+rs2.getInt(8));
		System.out.println("Attendance"+rs2.getInt(9));
		System.out.print("*****************************");
		System.out.println();
		}
		}
		else if(c==3)
		{
		System.out.println("exit");
        System.exit(0);
		}
		else
		{
		System.out.println("Invalid choice");
		}
        con.getConnection().close();
        break;
		case 3:
		System.out.println("Enter the staff id");
		int nid=s.nextInt();
		Statement stam=(Statement) con.getConnection().createStatement();
		  ResultSet rr=stam.executeQuery("select * from staffdetails");
		  int f=0;
		  while(rr.next())
		  {
			  if(rr.getInt(1)==nid)
			  {
				f=1;  
			  }  
		  }
		 if(f==1)
		 {
		System.out.println("Enter the attendance this month");
		int mat=s.nextInt();
		Statement st3=(Statement) con.getConnection().createStatement();
		int basicsalary=1000;
		ResultSet rs3=st3.executeQuery("select *from staffdetails where Staffid="+nid);
		   while(rs3.next())
		   {
		    int d=rs3.getInt(1);
		    t=mat*basicsalary;
		   }
		   
		   PreparedStatement pst1=con.getConnection().prepareStatement("update staffdetails set salary=?,Attendance=? where staffid=?");
		pst1.setInt(1,t);
		pst1.setInt(2,mat);
		pst1.setInt(3,nid);
		pst1.executeUpdate();
		System.out.println("Updated successfully");
		 con.getConnection().close();
		 }
		 else
		 {
			System.out.println("Invalid staff id"); 
		 }
		break;
		case 4:
			int fl=0;
			Statement strr=(Statement) con.getConnection().createStatement();
   		    ResultSet rstr=strr.executeQuery("select * from staffdetails ");
   		    System.out.println("########## List of Staffs #########");
   		     while(rstr.next())
	    		{
	    			System.out.println("Staff ID ->"+rstr.getInt(1));//print value
		    		System.out.println("Department ->"+rstr.getString(3));
		    		System.out.println("*********************************");
	    		}
   		 System.out.println("Enter the id to be deleted");
   		 int idd=s.nextInt();
   		 ResultSet rstr1=strr.executeQuery("select * from staffdetails ");
   		 
   		 while(rstr1.next())
   		  {
   			  if(rstr1.getInt(1)==idd)
   			  {  
   		       fl=1;
   			  }
   			  
   		  }
   		ResultSet rstr2=strr.executeQuery("select * from staffdetails ");
   		if(fl==1)
   		{
   			while(rstr2.next())
   			{
   		 PreparedStatement pst=(PreparedStatement)con.getConnection().prepareStatement("delete from staffdetails where staffid = ?");//delete statement  
	     pst.setInt(1,idd);
		 pst.executeUpdate(); 
		 con.getConnection().close();
   			}
   		 System.out.println("deleted successfully");
   		}
   			
   		 break;
		case 5:
			Collegemanagement cm=new Collegemanagement();
			cm.login();
		     break;
		default:
			System.out.println("Invalid choice");
		 }
		}while(n!=0);
		}
		else
		System.out.println("Invalid username or password");
		}
		}
		}