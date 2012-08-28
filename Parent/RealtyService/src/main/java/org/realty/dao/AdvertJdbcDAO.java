package org.realty.dao;

import org.realty.entity.Advert;

import java.sql.Date;
import java.sql.SQLException;

public class AdvertJdbcDAO extends AbstractDAO<Advert> {

	private static final String SQL_ADD_ADVERT = "INSERT INTO Advert VALUES(?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE_ADVERT = "UPDATE Advert SET added_date=?,category=?,"
			+ "coast=?, description=? WHERE advert_id=?";
	private static final String SQL_DELETE_ADVERT = "DELETE FROM Advert WHERE advert_id=?";
	private static final String SQL_ALL = "SELECT * FROM Advert";

	public AdvertJdbcDAO() {

	}

	@Override
	protected void addStep(Advert advert) throws SQLException {
		ptmt.setString(1, null);
		ptmt.setDate(2, new Date(System.currentTimeMillis()));
		ptmt.setString(3, advert.getCategory());
		ptmt.setInt(4, advert.getRooms());
		ptmt.setLong(5, advert.getAdressId());
		ptmt.setInt(6, advert.getCoast());
		ptmt.setString(7, advert.getDescription());
		ptmt.setLong(8, advert.getUserId());
	}

	@Override
	protected void updateStep(Advert advert, Long id) throws SQLException {

		ptmt.setDate(1, new Date(System.currentTimeMillis()));
		ptmt.setString(2, advert.getCategory());
		ptmt.setInt(3, advert.getCoast());
		ptmt.setString(4, advert.getDescription());
		ptmt.setLong(5, id);

	}

	@Override
	protected Advert findAllStep() throws SQLException {
		Advert advert = new Advert();
		advert.setAdvertId(rs.getLong(1));
		advert.setAddedDate(rs.getDate(2));
		advert.setCategory(rs.getString(3));
        advert.setAdvertId(rs.getLong(4));
        advert.setRooms(rs.getInt(5));
		advert.setCoast(rs.getInt(6));
		advert.setDescription(rs.getString(7));
		advert.setUserId(rs.getLong(8));
		return advert;
	}

	@Override
	protected void deleteStep(Long advertId) throws SQLException {
		ptmt.setLong(1, advertId);
	}

	@Override
	protected String getAddSQL() throws SQLException {
		return SQL_ADD_ADVERT;
	}

	@Override
	protected String getUpdateSQL() throws SQLException {
		return SQL_UPDATE_ADVERT;
	}

	@Override
	protected String getDeleteSQL() throws SQLException {
		return SQL_DELETE_ADVERT;
	}

	@Override
	protected String getFindAllSQL() throws SQLException {
		return SQL_ALL;
	}

	@Override
	protected String getRequestSQL() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
