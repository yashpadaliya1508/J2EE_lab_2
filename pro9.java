import java.sql.*;
import java.util.Scanner;

class pro9
{
    public static void main(String[] args) 
    {
        Connection conn = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/employee";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee designation : ");
        String des = scanner.nextLine();
        try 
        {
            conn = DriverManager.getConnection(url, "root", "tnrao");
            System.out.println("Connection established successfully.");

            cst = conn.prepareCall("{call p_dis(?)}");
            cst.setString(1, des);

            boolean hasResults = cst.execute();

            if (hasResults) 
            {
                rs = cst.getResultSet();
                if (rs.next()) 
                {
                    int eno = rs.getInt("empno");
                    System.out.println("empno : " + eno);
                    String fnm = rs.getString("firstname");
                    System.out.println("Firstname : " + fnm);
                    String lnm = rs.getString("lastname");
                    System.out.println("Lastname : " + lnm);
                } 
                else 
                {
                    System.out.println("No employee found with this designation : " + des);
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