
//package dao;
//import java.sql.*;
//
//public class ConnectionProvider {
//    public static Connection getCon(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false", "root", "123456");
//            return con;
//        }
//        catch(Exception e){
//            return null;
//        }
//    }
//}


package dao; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static Connection con = null;

    public static Connection getCon() {
        try {
            if (con == null || con.isClosed()) {  
                Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure correct driver
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ems?useSSL=false&allowPublicKeyRetrieval=true", 
                    "root", 
                    "Root@123"
                );
                System.out.println("Database Connected Successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found! " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
        return con;
    }
}
