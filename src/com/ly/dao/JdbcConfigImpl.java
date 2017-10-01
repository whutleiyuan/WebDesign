package com.ly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfigImpl implements JdbcConfig{
	public static Connection getConnection() {
		Connection conn = null;
		try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return conn;
		}
}
