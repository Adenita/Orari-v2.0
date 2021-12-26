package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection {
    
    public static Connection createConnection() {
       

        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:database/OrariDatabase.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            return conn;
            
        } catch (SQLException e) {
            
        } 

        return null;
    }

    public static ResultSet Read(String query) {
        Connection conn = createConnection();
        try {
        Statement statment = conn.createStatement();
        ResultSet result = statment.executeQuery(query);

        return result;

        } catch(Exception e) {

        }

        return null;
        
    }
}
