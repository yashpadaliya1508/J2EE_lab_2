import java.sql.*;

class pro7 
{
    public static void main(String[] args) 
    {
        Connection conn = null;
        CallableStatement cst = null;
        String url = "jdbc:mysql://localhost:3306/employee";
        try 
        {
            conn = DriverManager.getConnection(url, "root", "tnrao");
            System.out.println("Connection established successfully.");
            
            cst = conn.prepareCall("{call p_addrec(?, ?, ? ,?)}");
            
            cst.setInt(1, 6);
            cst.setString(2, "Yash");
            cst.setString(3, "Patel");
            cst.setString(4, "mgr");
            
            cst.execute();
            System.out.println("Record added successfully.");
            
            cst.close();
            conn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}