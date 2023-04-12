package it.develhope;
import java.sql.*;
public class Start {
    public static void main(String[] args)
    {
        Connection collection=null;
        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";
            collection = DriverManager.getConnection(url, user, password);
            Statement statement = collection.createStatement();
            String query = ("ALTER TABLE student ADD COLUMN country VARCHAR(30)");
            statement.executeUpdate(query);
            statement.executeUpdate("UPDATE student SET country = 'Italy' where student_id = 1;");
            statement.executeUpdate("UPDATE student SET country = 'Italy' where student_id = 2;");
            statement.executeUpdate("UPDATE student SET country = 'Germany' where student_id = 3;");
            statement.executeUpdate("UPDATE student SET country = 'Germany' where student_id = 10;");
        }
        catch(SQLException e)
        {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(collection != null)
                    collection.close();
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
