package org.realty.commands.other;



import org.realty.commands.Command;

import org.realty.dao.CityJdbcDAO;

import org.realty.dao.DistrictJdbcDAO;
import org.realty.dto.AdressDTO;
import org.realty.entity.City;
import org.realty.entity.District;
import org.realty.hibernate.CityHibDAO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class AdressCommand implements Command {
    private CityHibDAO cityH;

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

       // CityJdbcDAO cityDao = new CityJdbcDAO();
        //CityHibDAO cityH = new CityHibDAO();

        List<City> cityList = cityH.getAllCitys();

        request.setAttribute("cityList", cityList);

        return "AddAdressPage.jsp";


    }



}
