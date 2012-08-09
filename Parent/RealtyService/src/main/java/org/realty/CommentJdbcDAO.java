package org.realty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentJdbcDAO extends AbstractDAO<Comment> {

	private static final String SQL_ADD_COMMENT = "INSERT INTO Comment VALUES(?,?,?,?)";
	private static final String SQL_UPDATE_COMMENT = "UPDATE Comment SET text=? WHERE comment_id=?";
	private static final String SQL_DELETE_COMMENT = "DELETE FROM Comment WHERE comment_id=?";
	private static final String SQL_ALL = "SELECT * FROM Comment";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public CommentJdbcDAO() {

	}
	
	
	@Override
	protected void addStep(Comment comment) throws SQLException {
		ptmt = con.prepareStatement(SQL_ADD_COMMENT);
		ptmt.setString(1, null);
		ptmt.setString(2, comment.getText());
		ptmt.setInt(3, comment.getUserId());
		ptmt.setInt(4, comment.getAdvertId());
	}
	
	
	
	@Override
	public void updateStep(Comment comment, Long id) throws SQLException {

			ptmt = con.prepareStatement(SQL_UPDATE_COMMENT);
			ptmt.setString(1, comment.getText());
			ptmt.setLong(2, id);
			
	}

	public void delete(int commentId) {

		try {

			con = createConnection();
			ptmt = con.prepareStatement(SQL_DELETE_COMMENT);
			ptmt.setInt(1, commentId);
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

	public List<Comment> findAll() {
		List<Comment> users = new ArrayList<Comment>();
		Comment comment = null;
		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_ALL);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				comment = new Comment();
				comment.setCommentId(rs.getInt(1));
				comment.setText(rs.getString(2));
				comment.setUserId(rs.getInt(3));
				comment.setAdvertId(rs.getInt(4));

				users.add(comment);
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
