package org.realty.dao;


import org.realty.entity.Comment;

import java.sql.SQLException;


public class CommentJdbcDAO extends AbstractDAO<Comment> {

	private static final String SQL_ADD_COMMENT = "INSERT INTO Comment VALUES(?,NOW(),?,?,?)";
	private static final String SQL_UPDATE_COMMENT = "UPDATE Comment SET text=? WHERE comment_id=?";
	private static final String SQL_DELETE_COMMENT = "DELETE FROM Comment WHERE comment_id=?";
	private static final String SQL_ALL = "SELECT * FROM Comment";
    private static final String SQL_DOMAIN_BY_ID = "SELECT * FROM Comment WHERE comment_id=?";

	public CommentJdbcDAO() {

	}

	@Override
	protected void addStep(Comment comment) throws SQLException {




		ptmt.setString(1, null);

        //ptmt.setDate(2, new java.sql.Date(today.getTime()),cal);
		ptmt.setString(2, comment.getText());
		ptmt.setLong(3, comment.getUserId());
		ptmt.setLong(4, comment.getAdvertId());

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
    protected String getCDId() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String getDistrIdForCitySQL() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String getDomainByNameSQL() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String getDomainByIdSQL() throws SQLException {
        return SQL_DOMAIN_BY_ID;
    }

    @Override
	protected String getFindAllSQL() throws SQLException {
		return SQL_ALL;
	}

	@Override
	protected Comment findAllStep() throws SQLException {
		Comment comment = new Comment();
		comment.setCommentId(rs.getLong(1));
        comment.setAddedDate(rs.getString(2));
		comment.setText(rs.getString(3));
		comment.setUserId(rs.getLong(4));
		comment.setAdvertId(rs.getLong(5));
		return comment;
	}

    @Override
    protected void getDomainByIdStep(Long id) throws SQLException {
        ptmt.setLong(1, id);
    }

    @Override
    protected void getDomainByNameStep(String name) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void getDistrictsForCityStep(Long id) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Long findAllFCStep() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Comment getDomainStep(Long id) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


}
