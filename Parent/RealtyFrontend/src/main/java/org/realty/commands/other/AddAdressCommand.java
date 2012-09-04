package org.realty.commands.other;



import org.realty.commands.Command;

import org.realty.dao.CityJdbcDAO;

import org.realty.entity.City;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.List;

public class AddAdressCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        CityJdbcDAO cd = new CityJdbcDAO();
        List<City> allCity = cd.findAll();

        request.setAttribute("allCity", allCity);

        return "AddAdressPage.jsp";


    }



}
