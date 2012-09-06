package org.realty.commands.other;



import org.realty.commands.Command;

import org.realty.dao.CityJdbcDAO;

import org.realty.dao.DistrictJdbcDAO;
import org.realty.dto.AdressDTO;
import org.realty.entity.City;
import org.realty.entity.District;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

public class AdressCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        CityJdbcDAO cityDao = new CityJdbcDAO();
        City city = cityDao.getDomainById(1L);

        DistrictJdbcDAO districtDao = new DistrictJdbcDAO();
        District district = districtDao.getDomainById(5L);

        AdressDTO adressDto = new AdressDTO();
        adressDto.setCityName(city.getCityName());
        adressDto.setDistrictName(district.getDistrictName());
        adressDto.setStreets(district.getStreets());


        request.setAttribute("adressDto", adressDto);

        return "AddAdressPage.jsp";


    }



}
