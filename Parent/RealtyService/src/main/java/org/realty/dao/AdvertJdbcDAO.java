package org.realty.dao;

import org.realty.entity.Advert;


import java.sql.Date;
import java.sql.SQLException;


public class AdvertJdbcDAO extends AbstractDAO<Advert> {

    private static final String SQL_ADD_ADVERT = "INSERT INTO Advert VALUES(?,NOW(),?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ADVERT = "UPDATE Advert SET added_date=?,category=?,"
            + "coast=?, description=? WHERE advert_id=?";
    private static final String SQL_DELETE_ADVERT = "DELETE FROM Advert WHERE advert_id=?";
    private static final String SQL_ALL = "SELECT * FROM Advert";
    private static final String SQL_DOMAIN_BY_ID = "SELECT * FROM Advert WHERE advert_id=?";

    public AdvertJdbcDAO() {

    }

    @Override
    protected void addStep(Advert advert) throws SQLException {


        ptmt.setString(1, null);
        ptmt.setString(2, advert.getCategory());
        ptmt.setInt(3, advert.getRooms());
       // ptmt.setLong(4, advert.getAdressId());
        ptmt.setInt(5, advert.getCoast());
        ptmt.setString(6, advert.getDescription());
        //ptmt.setLong(7, advert.getUserId());
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
        advert.setAddedDate(rs.getString(2));
        advert.setCategory(rs.getString(3));
      //  advert.setAdressId(rs.getLong(4));
        advert.setRooms(rs.getInt(5));
        advert.setCoast(rs.getInt(6));
        advert.setDescription(rs.getString(7));
        //advert.setUserId(rs.getLong(8));
        return advert;
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
    protected Advert getDomainStep(Long id) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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


}
