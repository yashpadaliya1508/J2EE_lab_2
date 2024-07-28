import java.sql.*;

class pro6 
{
    public static void main(String[] args) 
    {
        Connection conn = null;
        CallableStatement cst = null;
        String url = "jdbc:mysql://localhost:3306/employee";
        try
        {
            conn = DriverManager.getConnection(url,"root","tnrao");
            System.out.println("Connection established successfully.");
            
            cst = conn.prepareCall("{call p_insert()}");
            System.out.println("Calling stored procedure...");
            cst.execute();
            System.out.println("Record added successfully.");
            
            cst.close();
            conn.close();
            System.out.println("Connection closed.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();    
        }
    }
}