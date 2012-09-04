package org.realty.dao;


import org.realty.entity.District;
import org.realty.entity.Street;

import java.sql.SQLException;
import java.util.ArrayList;

public class DistrictJdbcDAO extends AbstractDAO<District> {


    private static final String SQL_ADD_DISTRICT = "INSERT INTO District VALUES(?,?)";
    private static final String SQL_UPDATE_DISTRICT = "UPDATE District SET districtName=? WHERE districtId=?";
    private static final String SQL_DELETE_DISTRICT = "DELETE FROM District WHERE districtId=?";
    private static final String SQL_ALL = "SELECT * FROM District";
    private static final String SQL_DOMAIN_BY_ID = "SELECT * FROM District WHERE districtId=?";
    private static final String SQL_DISTR_FOR_CITY ="SELECT districtId FROM city_district WHERE cityId=?";
    private static final String SQL_CD_ID ="SELECT cityDistrId FROM city_district WHERE districtId=?";


    public DistrictJdbcDAO(){

    }


    @Override
    protected void addStep(District district) throws SQLException {

        ptmt.setString(1, null);
        ptmt.setString(2, district.getDistrictName());
    }

    @Override
    protected void updateStep(District district, Long id) throws SQLException {

        ptmt.setString(1, district.getDistrictName());
        ptmt.setLong(2, id);

    }

    @Override
    protected District findAllStep() throws SQLException {
        District district = new District();
        district.setDistrictId(rs.getLong(1));
        district.setDistrictName(rs.getString(2));

        DistrictJdbcDAO dd = new DistrictJdbcDAO();
        Long cDId = dd.getCDId(rs.getLong(1));

        if(cDId != null){
        StreetJdbcDAO sd =new StreetJdbcDAO();
        district.setStreets(sd.findAllForCity(cDId));
        } else district.setStreets(new ArrayList<Street>());


        return district;
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
    protected District getDomainStep(Long id) throws SQLException {
        DistrictJdbcDAO dd = new DistrictJdbcDAO();
        District district = dd.getDomainById(id);

        return district;
    }

    @Override
    protected void deleteStep(Long districtId) throws SQLException {

        ptmt.setLong(1, districtId);
    }

    @Override
    protected String getAddSQL() throws SQLException {
        return SQL_ADD_DISTRICT;
    }

    @Override
    protected String getUpdateSQL() throws SQLException {
        return SQL_UPDATE_DISTRICT;
    }

    @Override
    protected String getDeleteSQL() throws SQLException {
        return SQL_DELETE_DISTRICT;
    }

    @Override
    protected String getDistrIdForCitySQL() throws SQLException {
        return SQL_DISTR_FOR_CITY;
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
    protected String getCDId() throws SQLException {
        return SQL_CD_ID;
    }







}
