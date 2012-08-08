package org.realty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO extends AbstractDAO {

	private static final String SQL_ADD_USER = "INSERT INTO User VALUES(?,?,?,?)";
	private static final String SQL_UPDATE_USER = "UPDATE User SET name=?,passwordt=?,"
			+ "phone_number=? WHERE user_id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM User WHERE user_id=?";
	private static final String SQL_ALL = "SELECT * FROM User";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public UserJdbcDAO() {

	}

	public void add(User user) {

		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_ADD_USER);
			ptmt.setString(1, null);
			ptmt.setString(2, user.getName());
			ptmt.setString(3, user.getPassword());
			ptmt.setString(4, user.getPhoneNumber());
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

	public void update(User user, int id) {

		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_UPDATE_USER);
			ptmt.setString(1, user.getName());
			ptmt.setString(2, user.getPassword());
			ptmt.setString(3, user.getPhoneNumber());
			ptmt.setInt(4, id);
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

	public void delete(int userId) {

		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_DELETE_USER);
			ptmt.setInt(1, userId);
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

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = null;
		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_ALL);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhoneNumber(rs.getString(4));

				users.add(user);
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
		return users;
	}
}
