package org.realty.dao;


import org.realty.dao.AbstractDAO;
import org.realty.entity.User;

import java.sql.SQLException;

public class UserJdbcDAO extends AbstractDAO<User> {

	private static final String SQL_ADD_USER = "INSERT INTO User VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE_USER = "UPDATE User SET name=?,passwordt=?,"
			+ "phone_number=?, admin=? WHERE user_id=?";
	private static final String SQL_DELETE_USER = "DELETE FROM User WHERE user_id=?";
	private static final String SQL_ALL = "SELECT * FROM User";
	private static final String SQL_NAME_PASS = "SELECT name,passwordt FROM User";
	

	public UserJdbcDAO() {

	}



	@Override
	protected void addStep(User user) throws SQLException {

		ptmt.setString(1, null);
		ptmt.setString(2, user.getName());
		ptmt.setString(3, user.getPassword());
		ptmt.setString(4, user.getPhoneNumber());
        ptmt.setBoolean(5, user.getAdmin());

	}

	@Override
	protected void updateStep(User user, Long id) throws SQLException {

		ptmt.setString(1, user.getName());
		ptmt.setString(2, user.getPassword());
		ptmt.setString(3, user.getPhoneNumber());
        ptmt.setBoolean(4, user.getAdmin());
		ptmt.setLong(5, id);

	}

	
	@Override
	protected User findAllStep() throws SQLException {
		User user = new User();
		user.setUserId(rs.getLong(1));
		user.setName(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setPhoneNumber(rs.getString(4));
        user.setAdmin(rs.getBoolean(5));
		return user;
	}
	
	@Override
	protected void deleteStep(Long userId) throws SQLException {

		ptmt.setLong(1, userId);
	}

	@Override
	protected String getAddSQL() throws SQLException {
		return SQL_ADD_USER;
	}

	@Override
	protected String getUpdateSQL() throws SQLException {
		return SQL_UPDATE_USER;
	}

	@Override
	protected String getDeleteSQL() throws SQLException {
		return SQL_DELETE_USER;
	}
	
	@Override
	protected String getFindAllSQL() throws SQLException {
		return SQL_ALL;
	}

	@Override
	protected String getRequestSQL() throws SQLException {
		// TODO Auto-generated method stub
		return SQL_NAME_PASS;
	}
	

}
