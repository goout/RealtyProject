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

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class AdressCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

     /* CityJdbcDAO cityDao = new CityJdbcDAO();
      City city = cityDao.getDomainById(1L);

        DistrictJdbcDAO districtDao = new DistrictJdbcDAO();
        District district = districtDao.getDomainById(5L);

        AdressDTO adressDto = new AdressDTO();
        adressDto.setCityName(city.getCityName());
        adressDto.setDistrictName(district.getDistrictName());
        adressDto.setStreets(district.getStreets());


        request.setAttribute("adressDto", adressDto);

        return "AddAdressPage.jsp";*/


        CityJdbcDAO cityDao = new CityJdbcDAO();
        List<City> cityList = cityDao.findAll();
        request.setAttribute("cityList", cityList);

        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        request.setAttribute("list1", list1);



        List<String> list2 = new ArrayList<String>();
        list2.add("A1");
        list2.add("A2");
        list2.add("A3");
        request.setAttribute("list2", list2);


            for (String d :list1){
                out.printf("%s \n",d);
            }

        List<String> list3 = new ArrayList<String>();
        list3.add("B1");
        list3.add("B2");
        list3.add("B3");
        request.setAttribute("list3", list3);

        return "AddAdressPage.jsp";

    }



}
