package BankManagementSystem;
import java.sql.*;

public class Connect 
{
    Connection con;
    Statement stmt;
    public Connect() 
    {
        try
        {   
            //Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");   
            stmt=con.createStatement(); 
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
              
    }
}
/*import java.sql.*;  
class Connect
{  
    public static void main(String args[])
    {  
        try
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","1234");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from signup");  
            while(rs.next())  
            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }  
}  */
