package org.realty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO {

	public static final String driverClassName = "com.mysql.jdbc.Driver";
	public static final String connectionUrl = "jdbc:mysql://localhost:3306/REALTY";
	public static final String dbUser = "root";
	public static final String dbPwd = "goout";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	final public <T> void add(T arg) {

		try {
			con = createConnection();
			addStep(arg);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	final public <T> void update(T arg, Long id) {

		try {
			con = createConnection();
			updateStep(arg, id);
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	protected <T> void updateStep(T arg, Long id) {	}

	protected <T> void addStep(T arg) {}
	

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
