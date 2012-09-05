package org.realty.commands.other;


import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdressJdbcDAO;

import org.realty.entity.Adress;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAdrCom implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    AdressJdbcDAO adrDao = new AdressJdbcDAO();




    String city = request.getParameter("city");

    String district = request.getParameter("district");

    String street = request.getParameter("street");

    String homeNum = request.getParameter("homeNum");
    String apartmentNum = request.getParameter("apartmentNum");

        Adress adress = new Adress();
        adress.setCityId(Long.parseLong(city));
        adress.setDistrictId(Long.parseLong(district));
        adress.setStreetId(Long.parseLong(street));
        adress.setHouseNum(Integer.parseInt(homeNum));
        adress.setApartmentNum(Integer.parseInt(apartmentNum));


    adrDao.add(adress);


    return CommandFactory.getCommand("allAdvert")
            .execute(request, response);

    }
}
