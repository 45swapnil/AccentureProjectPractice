package JDBC;
import java.util.*;
import java.sql.*;
public class ClassProject {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
		PreparedStatement ps=null;
		
//		Statement st=con.createStatement();
//		String sql="Create table Employee(emp_id int, emp_Name varchar2(20), emp_salary varchar2(20),emp_Dept varchar2(20))";
//		int query=st.executeUpdate(sql);
//		if(query>0)
//		{
//			System.out.println("Succesfull ");
//		}
		System.out.println("\t\t-------------------------");	
		System.out.println("\t \tWELLCOME TO BAJAJ PORTAL");
		System.out.println("\t\t--------------------------");
		
		for(int i=0;i<=4;i++)
		{
			System.out.println("\n\t\t********************");
			System.out.println("\t\t1.Add Employee \n\t\t2.View Employee \n\t\t3.Update Employee \n\t\t4.Delete Employee\n\t\t5.Serch Employee \n\t\t6.exit");
			System.out.print("\t\t********************");
			int ch=sc.nextInt();
			if(ch==6)
			{
				System.out.println("\n\t\tThanks For Visiting ::::");
				break;
			}
			
			switch (ch)
			{
				case 1:
					ps=con.prepareStatement("Insert into Employee values(?,?,?,?)");
					System.out.println("Enter the Employee ID :");
					int eid1=sc.nextInt();
					System.out.println("Enter the Employee Name : ");
					String name1=sc.next();
					System.out.println("Enter the Employee Salary : ");
					int sal1=sc.nextInt();
					System.out.println("Enter the Employee Department");
					String dept1=sc.next();
					
					ps.setInt(1, eid1);
					ps.setString(2, name1);
					ps.setInt(3, sal1);
					ps.setString(4, dept1);
					
					int res1=ps.executeUpdate();
					if(res1>0)
					{
						System.out.println(" New Employee Added Succesfull");
						System.out.println(" Emp_ID \t Emp_Name \t Emp_Salary \t Emp_Dept");
						System.out.println(" "+eid1+" \t \t "+name1+" \t \t"+sal1+" \t\t "+dept1);
						
					}
					con.close();
					break;
					
				case 2:
					ps=con.prepareStatement("Select *from Employee");
				
					
					ResultSet rs=ps.executeQuery();
					System.out.println("*******!..EMPLOYEE INFORMATION BAJAJ COMPANY..!*******\n");
					System.out.print("EMP_Id\t\tEMP_Name\tEMP_Salary\tEMP_Dept");
					while(rs.next())
					{
						
						System.out.print("\n"+rs.getInt("Emp_Id"));
						System.out.print("\t\t"+rs.getString("Emp_Name"));
						System.out.print("\t\t"+rs.getInt("Emp_salary"));
						System.out.print("\t\t"+rs.getString("Emp_Dept"));
					}
					System.out.println("\n\n*********************************************************");
					
					ps.close();
					break;
					
				case 3:
					System.out.println("\t\tEnter the Id you wont to Update");
					int main_id=sc.nextInt();
					for(int j=0;j<=4;j++)
					{
						System.out.println("1.ID \n2. Name \n3.Salary \n4.Dept \n5.Exit");
						int choice=sc.nextInt();
						if(choice==5)
						{
							break;
						}
						switch (choice)
						{
							case 1:
								ps=con.prepareStatement("\t\tUpdate Employee set emp_id=? where emp_id=?");
								System.out.println("\t\tEnter the New ID");
								int eid2_1=sc.nextInt();
								
								ps.setInt(1, eid2_1);
								ps.setInt(2, main_id);
								int res2_1=ps.executeUpdate();
								if(res2_1>0)
								{
									System.out.println("\t\tEmployee ID Updated Succesfull");
																		
								}
								ps.close();
								break;
								
							case 2:
								ps=con.prepareStatement("\t\tUpdate Employee set emp_Name=? where emp_id=?");
								System.out.println("\t\tEnter the New Name");
								String Name2_2=sc.next();
								
								ps.setString(1, Name2_2);
								ps.setInt(2, main_id);
								int res2_2=ps.executeUpdate();
								if(res2_2>0)
								{
									System.out.println("\t\tEmployee Name Updated Succesfull");
																		
								}
								ps.close();
								break;
								
							case 3:
								ps=con.prepareStatement("\t\tUpdate Employee set emp_salary=? where emp_id=?");
								System.out.println("\t\tEnter the New Salary");
								int sal2_3=sc.nextInt();
								
								ps.setInt(1, sal2_3);
								ps.setInt(2, main_id);
								int res2_3=ps.executeUpdate();
								if(res2_3>0)
								{
									System.out.println("\t\tEmployee Salary Updated Succesfull");
																		
								}
								ps.close();
								break;
								
							case 4:
								ps=con.prepareStatement("\t\tUpdate Employee set emp_Dept=? where emp_id=?");
								System.out.println("\t\tEnter the New Departement");
								int dept2_4=sc.nextInt();
								
								ps.setInt(1, dept2_4);
								ps.setInt(2, main_id);
								int res2_4=ps.executeUpdate();
								if(res2_4>0)
								{
									System.out.println("\t\tEmployee Departement Updated Succesfull");
																		
								}
							
								ps.close();
								break;


						}
					}
					break;
					
				case 4:
					ps=con.prepareStatement("Delete From Employee where Emp_id=?");
					
					System.out.println("Enter the Employee Id You Wont to Delete");
					int eid4=sc.nextInt();
					
					ps.setInt(1, eid4);
					
					int res4=ps.executeUpdate();
					if(res4>0)
					{
						System.out.println("Succefully Deleted Employee");
					}
					else
					{
						System.out.println("Employee Not Present in Database");
					}
						
					ps.close();
					break;
					
				case 5:
					ps=con.prepareStatement("select from Employee where id=?");
					
					ResultSet rs1=ps.executeQuery();
					
					System.out.println(rs1.getInt("Emp_Id"));
					break;
					
					
					
			}
			
			
		}
		
		
		
	}

}
