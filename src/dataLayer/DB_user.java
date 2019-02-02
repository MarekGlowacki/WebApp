package dataLayer;

import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_user {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/WebApp?useSSL=false&characterEncoding=utf8&useJDBCCompianttimezoneShift=true&useLegacyDatetimecode=false&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "coderslab";

    public boolean isValidUserLogin(String sUserName, String sUserPassword) {

        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;
        String sql = "";

        try {
            //Step 2: Register JDBC driver
            Class driver_class = Class.forName(JDBC_DRIVER);
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);

            //Step 3: Ppen a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //Step 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM WebApp.users WHERE user_name = \"" + sUserName + "\" AND user_password = \"" + sUserPassword + "\"";

            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            //Step 5: Extraxt data from result set
            if (rs.next()) {
                isValidUser = true;
            }

            //Step 6: Clean-up enviroment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle Errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle Errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        System.out.println("Closing DB Connection - Goodbye!");



        return isValidUser;
    }

}
