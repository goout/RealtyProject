package org.realty.commands.other;


import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.CityJdbcDAO;
import org.realty.dao.CommentJdbcDAO;
import org.realty.dao.UserJdbcDAO;
import org.realty.dto.CommentUserAdvertDTO;
import org.realty.entity.Advert;
import org.realty.entity.City;
import org.realty.entity.Comment;
import org.realty.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
