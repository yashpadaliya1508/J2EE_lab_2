import java.sql.*;
import java.util.Scanner;

class pro8 
{
    public static void main(String[] args) 
    {
        Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/employee";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee number: ");
        int empno = scanner.nextInt();
        try 
        {
            conn = DriverManager.getConnection(url, "root", "tnrao");
            System.out.println("Connection established successfully.");

            cst = conn.prepareCall("{call p_selnm(?)}");
            cst.setInt(1, empno);

            boolean hasResults = cst.execute();

            if (hasResults) 
            {
                rs = cst.getResultSet();
                if (rs.next()) 
                {
                    String desig = rs.getString("desig");
                    System.out.println("Employee's designation is: " + desig);
                } 
                else 
                {
                    System.out.println("No employee found with number: " + empno);
                }
            }
            rs.close();
            cst.close();
            conn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        scanner.close();
    }
}