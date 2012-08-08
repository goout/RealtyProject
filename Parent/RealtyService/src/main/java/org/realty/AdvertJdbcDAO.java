package org.realty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertJdbcDAO extends AbstractDAO {

	private static final String SQL_ADD_ADVERT = "INSERT INTO Advert VALUES(?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE_ADVERT = "UPDATE Advert SET added_date=?,category=?,district=?,"
			+ "adress=?, coast=?, description=? WHERE advert_id=?";
	private static final String SQL_DELETE_ADVERT = "DELETE FROM Advert WHERE advert_id=?";
	private static final String SQL_ALL = "SELECT * FROM Advert";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public AdvertJdbcDAO() {

	}

	public void add(Advert advert) {

		try {

			con = createConnection();
			ptmt = con.prepareStatement(SQL_ADD_ADVERT);
			ptmt.setString(1, null);
			ptmt.setDate(2, advert.getAddedDate());
			ptmt.setString(3, advert.getCategory());
			ptmt.setString(4, advert.getDistrict());
			ptmt.setString(5, advert.getAdress());
			ptmt.setInt(6, advert.getCoast());
			ptmt.setString(7, advert.getDescription());
			ptmt.setLong(8, advert.getUserId());
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

	public void update(Advert advert, int id) {

		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_UPDATE_ADVERT);
			ptmt.setDate(1, advert.getAddedDate());
			ptmt.setString(2, advert.getCategory());
			ptmt.setString(3, advert.getDistrict());
			ptmt.setString(4, advert.getAdress());
			ptmt.setInt(5, advert.getCoast());
			ptmt.setString(6, advert.getDescription());
			ptmt.setInt(7, id);
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

	public void delete(int advertId) {

		try {
			con = createConnection();
			ptmt = con.prepareStatement(SQL_DELETE_ADVERT);
			ptmt.setInt(1, advertId);
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

	public List<Advert> findAll() {
		List<Advert> adverts = new ArrayList<Advert>();
		Advert advert = null;
		try {

			con = createConnection();
			ptmt = con.prepareStatement(SQL_ALL);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				advert = new Advert();
				advert.setAdvertId(rs.getLong(1));
				advert.setAddedDate(rs.getDate(2));
				advert.setCategory(rs.getString(3));
				advert.setDistrict(rs.getString(4));
				advert.setAdress(rs.getString(5));
				advert.setCoast(rs.getInt(6));
				advert.setDescription(rs.getString(7));
				advert.setUserId(rs.getLong(8));

				adverts.add(advert);
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
		return adverts;
	}

}
