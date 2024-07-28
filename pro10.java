import java.sql.*;
import java.util.Scanner;
public class pro10 
{
 
	public static void main(String[] args) throws Exception  
    {
		String  url="jdbc:mysql://localhost:3306/employee";
		String username="root";
		String password="tnrao";
		Connection con =DriverManager.getConnection(url,username,password);
 
		Statement stmt =con.createStatement();
		ResultSet rs;
		PreparedStatement st;
 
		String qry="";
		int empno,choice;
		String firstname,lastname,desig;
 
		Scanner in = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
 
		while(true)
		{
			System.out.println("CRUD Operation");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. View All Record");
			System.out.println("5. Exit");
			System.out.print("Enter a choice: ");
			choice = in.nextInt();
            System.out.println(" ");
			System.out.println("-----------------------------------------");
			switch(choice){
			case 1:
				System.out.println("1. Insert New Data");
 
				System.out.println("Enter Firstname : ");
				firstname=str.nextLine();
				System.out.println("Enter Lastname : ");
				lastname=str.nextLine();
				System.out.println("Enter Designation : ");
				desig=str.nextLine();
 
				qry="insert into emp1 (firstname,lastname,desig) values(?,?,?)";
				st= con.prepareStatement(qry);
				st.setString(1, firstname);
				st.setString(2, lastname);
				st.setString(3, desig);
 
				st.executeUpdate();
				System.out.println("Data Insert Success");
 
				break;
			case 2:
				System.out.println("2. Updating a Data");
 
				System.out.println("Enter empno : ");
				empno=in.nextInt();
				System.out.println("Enter Firstname : ");
				firstname=str.nextLine();
				System.out.println("Enter Lastname : ");
				lastname=str.nextLine();
				System.out.println("Enter Designation : ");
				desig=str.nextLine();
 
				qry="update emp1 set firstname=?,lastname=?,desig=? where empno=?";
				st= con.prepareStatement(qry);
 
				st.setString(1, firstname);
				st.setString(2, lastname);
				st.setString(3, desig);
				st.setInt(4, empno);
				st.executeUpdate();
				System.out.println("Data Update Success");
 
				break;
			case 3:
				System.out.println("3. Deleting a Data");
				System.out.println("Enter empno : ");
				empno=in.nextInt();
 
				qry="delete from emp1 where empno=?";
				st= con.prepareStatement(qry);
				st.setInt(1, empno);
 
				st.executeUpdate();
				System.out.println("Data Deleted Success");
 
				break;
			case 4:
				System.out.println("4. Print all Records");
				qry="SELECT * from emp1";
				rs=stmt.executeQuery(qry);
				while(rs.next())
				{
					empno=rs.getInt("empno");
					firstname=rs.getString("firstname");
					lastname=rs.getString("lastname");
					desig=rs.getString("desig");
 
					System.out.print(empno+" ");
					System.out.print(firstname+" ");
					System.out.print(lastname+" ");
					System.out.println(desig+" ");
 
				}
				break;
			case 5:
				System.out.println("Thank You");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
			System.out.println("-----------------------------------------");
            System.out.println(" ");
		}
	}
}