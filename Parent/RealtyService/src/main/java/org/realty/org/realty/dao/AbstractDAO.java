package org.realty.org.realty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<DOMAIN extends Object> {

	public static final String driverClassName = "com.mysql.jdbc.Driver";
	public static final String connectionUrl = "jdbc:mysql://localhost:3306/REALTY";
	public static final String dbUser = "root";
	public static final String dbPwd = "goout";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	

	final public void add(DOMAIN arg) {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getAddSQL());
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

	final public void update(DOMAIN arg, Long id) {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getUpdateSQL());
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

	final public void delete(Long id) {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getDeleteSQL());
			deleteStep(id);

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

	public  List<DOMAIN> request() {
		List<DOMAIN> domains = new ArrayList<DOMAIN>();
		try {
			connectionStep();
			ptmt = con.prepareStatement(getRequestSQL());
			rs = ptmt.executeQuery();
          
	
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
		return domains;
	}

	
	public List<DOMAIN> findAll() {
		List<DOMAIN> domains = new ArrayList<DOMAIN>();

		try {
			connectionStep();
			ptmt = con.prepareStatement(getFindAllSQL());
			rs = ptmt.executeQuery();

			while (rs.next()) {

				domains.add(findAllStep());
			}

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
		return domains;
	}
	
	
	
	protected void connectionStep() {
		con = createConnection();
	}

	abstract protected String getRequestSQL() throws SQLException;
	
	abstract protected String getFindAllSQL() throws SQLException;

	abstract protected String getDeleteSQL() throws SQLException;

	abstract protected String getUpdateSQL() throws SQLException;

	abstract protected String getAddSQL() throws SQLException;

	abstract protected void updateStep(DOMAIN arg, Long id) throws SQLException;

	abstract protected void addStep(DOMAIN arg) throws SQLException;

	abstract protected void deleteStep(Long id) throws SQLException;

	abstract protected DOMAIN findAllStep() throws SQLException;

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
