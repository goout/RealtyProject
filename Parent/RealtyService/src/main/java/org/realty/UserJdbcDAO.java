package org.realty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcDAO {

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public UserJdbcDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(User user) {

		try {
			String querystring = "INSERT INTO User VALUES(?,?,?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setString(1, String.valueOf(System.currentTimeMillis())); // ?
			ptmt.setString(2, user.getname());
			ptmt.setString(3, user.getpassword());
			ptmt.setString(4, user.getphoneNumber());
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

}
