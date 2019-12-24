package com.rest.bean;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SQLconnection {
    private String dbClass = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://127.0.0.1:3306/bandongho";
    private String userName = "root";
    private String password = "";
    private Connection conn = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(this.dbClass);
            conn = (Connection) DriverManager.getConnection(this.dbUrl, this.userName, this.password);
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }

}