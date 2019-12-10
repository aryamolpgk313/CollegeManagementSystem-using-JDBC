package project;

import java.sql.SQLException;
import java.util.Scanner;
public class Collegemanagement {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Collegemanagement cm=new Collegemanagement();
		cm.login();
	}
		public void login()throws SQLException, ClassNotFoundException{
			int n;
			Scanner s=new Scanner(System.in);
		
		do
		{
			System.out.println("1)Admin Login\n2)Staff Login\n3)Student login\n4)Exit");
			System.out.println("enter the choice");
			n=s.nextInt();	
		switch(n)
		{
		case 1:
			Admin admin=new Admin();
			admin.adminData();
			break;
		case 2:
			Staff staff=new Staff();
			staff.staffData();
			break;
		case 3:
			Student student=new Student();
			student.studentData();
			break;
			
		case 4:
			System.out.println("Thank you");
			System.exit(0);
		}
		}while(n!=0);
	}
}
