package com.amdocs.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static String url = "jdbc:mysql://localhost:3306/amdocs";
	private static String user = "root";
	private static String password = "pankaj";
	private static Connection conn = null;

	private DbUtil() {
	}

	public static Connection getConnection() {
		if (conn == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
