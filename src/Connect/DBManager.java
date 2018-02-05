/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Michal
 */
public class DBManager {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

    public DBManager() {
        try {

            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprava_cien_project?sprava_cien_project?useSSL=false", "root", "tominok");
            System.out.println("Connected database successfully...");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            System.out.println("Error with connection");
        }
    }
    
    public ResultSet querySQL(String query) {
        try {
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            //stmt.setMaxRows(300); //strankovanie po 300 rows
            //stmt.setFetchDirection(); toutou metodou sa asi bude robit seek
            return stmt.executeQuery(query);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            System.out.println("EROROR HERE");
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
             System.out.println("EROROR HERE2");
        }
        return null;
    }
    
     public boolean insertSql(String query) {
        boolean result = true;
        try {
            //STEP 4: Execute a query
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            //return stmt.executeQuery(query);
        } catch (SQLException se) {
            result = false;
            se.printStackTrace();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

     public boolean updateSql(String query) {
        boolean result = true;
        try {
            //STEP 4: Execute a query
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();

            //return stmt.executeQuery(query);
        } catch (SQLException se) {
            result = false;
            se.printStackTrace();
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
   
     
}
