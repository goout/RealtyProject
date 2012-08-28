package org.realty.org.realty.dao;


import org.realty.org.realty.entity.Adress;
import org.realty.org.realty.entity.User;

import java.sql.SQLException;

public class AdressJdbcDAO extends AbstractDAO<Adress> {

    private static final String SQL_ADD_USER = "INSERT INTO User VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_USER = "UPDATE User SET name=?,passwordt=?,"
            + "phone_number=?, admin=? WHERE user_id=?";
    private static final String SQL_DELETE_USER = "DELETE FROM User WHERE user_id=?";
    private static final String SQL_ALL = "SELECT * FROM User";
    private static final String SQL_NAME_PASS = "SELECT name,passwordt FROM User";


   public AdressJdbcDAO(){

   }



    @Override
    protected void addStep(Adress adress) throws SQLException {

        ptmt.setString(1, null);
        ptmt.setLong(2, adress.getCityId());
        ptmt.setLong(3, adress.getDistrictId());
        ptmt.setLong(4, adress.getStreetId());
        ptmt.setInt(5, adress.getHouseNum());
        ptmt.setInt(6, adress.getApartmentNum());

    }

    @Override
    protected void updateStep(Adress adress, Long id) throws SQLException {

        ptmt.setLong(1, adress.getCityId());
        ptmt.setLong(2, adress.getDistrictId());
        ptmt.setLong(3, adress.getStreetId());
        ptmt.setInt(4, adress.getHouseNum());
        ptmt.setInt(5, adress.getApartmentNum());
        ptmt.setLong(6, id);

    }


    @Override
    protected Adress findAllStep() throws SQLException {
        Adress adress = new Adress();
        adress.setAdressId(rs.getLong(1));
        adress.setCityId(rs.getLong(2));
        adress.setDistrictId(rs.getLong(3));
        adress.setStreetId(rs.getLong(4));
        adress.setHouseNum(rs.getInt(5));
        adress.setApartmentNum(rs.getInt(6));
        return adress;
    }

    @Override
    protected void deleteStep(Long adressId) throws SQLException {

        ptmt.setLong(1, adressId);
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
