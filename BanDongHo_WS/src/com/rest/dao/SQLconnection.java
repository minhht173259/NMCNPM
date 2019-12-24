package com.rest.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SQLconnection {
	private final String dbClass = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://localhost:3306/bandongdo";
	private final String userName = "root";
	private final String password = "123456789";
	private Connection conn = null;

	public Connection getConnectionDB() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(this.dbClass);
			conn = (Connection) DriverManager.getConnection(this.dbUrl, this.userName, this.password);
		} catch (SQLException e) {
			throw e;
		}
		return conn;
	}

}