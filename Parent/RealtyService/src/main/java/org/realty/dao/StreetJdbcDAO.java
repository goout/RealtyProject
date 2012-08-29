package org.realty.dao;


import org.realty.entity.Street;

import java.sql.SQLException;

public class StreetJdbcDAO extends AbstractDAO<Street> {

    private static final String SQL_ADD_STREET = "INSERT INTO Street VALUES(?,?)";
    private static final String SQL_UPDATE_STREET = "UPDATE Street SET streetName=? WHERE streetId=?";
    private static final String SQL_DELETE_STREET = "DELETE FROM Street WHERE streetId=?";
    private static final String SQL_ALL = "SELECT * FROM Street";
    private static final String SQL_DOMAIN_BY_ID = "SELECT * FROM Street WHERE streetId=?";


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
    protected String getDomainByIdSQL() throws SQLException {
        return SQL_DOMAIN_BY_ID;
    }

    @Override
    protected String getFindAllSQL() throws SQLException {
        return SQL_ALL;
    }


}
