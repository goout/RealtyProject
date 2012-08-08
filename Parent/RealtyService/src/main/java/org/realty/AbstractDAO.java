package org.realty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
	
	public static final String driverClassName = "com.mysql.jdbc.Driver";
	public static final String connectionUrl = "jdbc:mysql://localhost:3306/REALTY";
	public static final String dbUser = "root";
	public static final String dbPwd = "goout";

	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
