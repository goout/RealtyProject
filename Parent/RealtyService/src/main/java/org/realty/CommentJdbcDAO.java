package org.realty;

import java.sql.SQLException;

public class CommentJdbcDAO extends AbstractDAO<Comment> {

	private static final String SQL_ADD_COMMENT = "INSERT INTO Comment VALUES(?,?,?,?)";
	private static final String SQL_UPDATE_COMMENT = "UPDATE Comment SET text=? WHERE comment_id=?";
	private static final String SQL_DELETE_COMMENT = "DELETE FROM Comment WHERE comment_id=?";
	private static final String SQL_ALL = "SELECT * FROM Comment";

	public CommentJdbcDAO() {

	}

	@Override
	protected void addStep(Comment comment) throws SQLException {
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

	@Override
	protected void deleteStep(Long commentId) throws SQLException {

		ptmt.setLong(1, commentId);
	}

	@Override
	protected String getAddSQL() throws SQLException {
		return SQL_ADD_COMMENT;
	}

	protected String getUpdateSQL() throws SQLException {
		return SQL_UPDATE_COMMENT;
	}

	@Override
	protected String getDeleteSQL() throws SQLException {
		return SQL_DELETE_COMMENT;
	}

	@Override
	protected String getFindAllSQL() throws SQLException {
		return SQL_ALL;
	}

	@Override
	protected Comment findAllStep() throws SQLException {
		Comment comment = new Comment();
		comment.setCommentId(rs.getInt(1));
		comment.setText(rs.getString(2));
		comment.setUserId(rs.getInt(3));
		comment.setAdvertId(rs.getInt(4));
		return comment;
	}

}
