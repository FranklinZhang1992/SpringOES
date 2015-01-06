package com.augmentum.oes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    public Connection getMysqlConnection() throws SQLException {

        Connection conn = null;

        //Load the database driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Define url=jdbc:mysql://host[:port]/database
        String jdcUrl = "jdbc:mysql://localhost:3306/online_exam_system?useUnicode=true&characterEncoding=UTF-8";
        //Get a connection to the database
        conn = DriverManager.getConnection(jdcUrl, "root", "123456");

        return conn;
    }
    public void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
