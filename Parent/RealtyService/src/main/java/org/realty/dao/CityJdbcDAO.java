package org.realty.dao;



import org.realty.entity.City;

import java.sql.SQLException;

public class CityJdbcDAO extends AbstractDAO<City> {


    private static final String SQL_ADD_USER = "INSERT INTO City VALUES(?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE City SET cityName=? WHERE cityId=?";
    private static final String SQL_DELETE_USER = "DELETE FROM City WHERE cityId=?";
    private static final String SQL_ALL = "SELECT * FROM City";


public CityJdbcDAO(){

}


    @Override
    protected void addStep(City city) throws SQLException {

        ptmt.setString(1, null);
        ptmt.setString(2, city.getCityName());
          }

    @Override
    protected void updateStep(City city, Long id) throws SQLException {

        ptmt.setString(1, city.getCityName());
        ptmt.setLong(2, id);

    }


    @Override
    protected City findAllStep() throws SQLException {
        City city = new City();
        city.setCityId(rs.getLong(1));
        city.setCityName(rs.getString(2));
        return city;
    }

    @Override
    protected void deleteStep(Long cityId) throws SQLException {

        ptmt.setLong(1, cityId);
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
        return null;
    }




}
