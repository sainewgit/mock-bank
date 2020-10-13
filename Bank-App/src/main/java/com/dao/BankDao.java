package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankDao {

	public Connection getConnection() {
		Connection conn = null;
		String dbURL = "jdbc:mysql://localhost:3306/bms";
		String username = "root";
		String password = "Pwd@1234";
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				System.out.println("Connected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
