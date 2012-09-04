package org.realty.dao;


import org.realty.entity.District;
import org.realty.entity.Street;

import java.sql.SQLException;

public class StreetJdbcDAO extends AbstractDAO<Street> {

    private static final String SQL_ADD_STREET = "INSERT INTO Street VALUES(?,?)";
    private static final String SQL_UPDATE_STREET = "UPDATE Street SET streetName=? WHERE streetId=?";
    private static final String SQL_DELETE_STREET = "DELETE FROM Street WHERE streetId=?";
    private static final String SQL_ALL = "SELECT * FROM Street";
    private static final String SQL_DOMAIN_BY_ID = "SELECT * FROM Street WHERE streetId=?";
    private static final String SQL_STREET_FOR_DIST ="SELECT streetId from city_distr_str WHERE cityDistrId=?";


    public StreetJdbcDAO(){

    }


    @Override
    protected void addStep(Street street) throws SQLException {

        ptmt.setString(1, null);
        ptmt.setString(2, street.getStreetName());
    }

    @Override
    protected void updateStep(Street street, Long id) throws SQLException {

        ptmt.setString(1, street.getStreetName());
        ptmt.setLong(2, id);

    }

    @Override
    protected Street findAllStep() throws SQLException {
        Street street = new Street();
        street.setStreetId(rs.getLong(1));
        street.setStreetName(rs.getString(2));
        return street;
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
        ptmt.setLong(1, id);
    }

    @Override
    protected Long findAllFCStep() throws SQLException {
        Long id = rs.getLong(1);

        return id;
    }

    @Override
    protected Street getDomainStep(Long id) throws SQLException {

        StreetJdbcDAO sd = new StreetJdbcDAO();
        Street street = sd.getDomainById(id);

        return street;

    }

    @Override
    protected void deleteStep(Long streetId) throws SQLException {

        ptmt.setLong(1, streetId);
    }

    @Override
    protected String getAddSQL() throws SQLException {
        return SQL_ADD_STREET;
    }

    @Override
    protected String getUpdateSQL() throws SQLException {
        return SQL_UPDATE_STREET;
    }

    @Override
    protected String getDeleteSQL() throws SQLException {
        return SQL_DELETE_STREET;
    }

    @Override
    protected String getCDId() throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected String getDistrIdForCitySQL() throws SQLException {
        return SQL_STREET_FOR_DIST;
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
