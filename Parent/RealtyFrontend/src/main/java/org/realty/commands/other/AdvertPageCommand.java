package org.realty.commands.other;

import org.realty.commands.Command;
import org.realty.dao.*;
import org.realty.dto.AdvertUserAdressDTO;
import org.realty.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class AdvertPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        AdvertJdbcDAO ad = new AdvertJdbcDAO();
        String advertId = request.getParameter("advertId");
        Advert advert = ad.getDomainById((Long) Long.parseLong(advertId));

        AdvertUserAdressDTO allAdvertsUsrAdrDto = createDTO(advert);

        request.setAttribute("allAdvertsUsrAdrDto", allAdvertsUsrAdrDto);


        return "AdvertPage.jsp";

    }

    public AdvertUserAdressDTO createDTO(Advert advert) {


        AdvertUserAdressDTO aUADto = new AdvertUserAdressDTO();

        aUADto.setAdvertId(advert.getAdvertId());
        aUADto.setAddedDate(advert.getAddedDate());
        aUADto.setCategory(advert.getCategory());
        aUADto.setAdvertUserId(advert.getUserId());
        aUADto.setCoast(advert.getCoast());
        aUADto.setDescription(advert.getDescription());
        aUADto.setAdvertAdressId(advert.getAdressId());
        aUADto.setRooms(advert.getRooms());

        UserJdbcDAO ad = new UserJdbcDAO();
        User user = ad.getDomainById(advert.getUserId());

        aUADto.setName(user.getName());
        aUADto.setPhoneNumber(user.getPhoneNumber());

        AdressJdbcDAO adD = new AdressJdbcDAO();
        Adress adr = adD.getDomainById(advert.getAdressId());

        aUADto.setHouseNum(adr.getHouseNum());
        aUADto.setApartmentNum(adr.getApartmentNum());

        CityJdbcDAO citD = new CityJdbcDAO();
        City cit = citD.getDomainById(adr.getCityId());

        aUADto.setCityName(cit.getCityName());

        DistrictJdbcDAO diD = new DistrictJdbcDAO();
        District dis = diD.getDomainById(adr.getDistrictId());

        aUADto.setDistrictName(dis.getDistrictName());

        StreetJdbcDAO strD = new StreetJdbcDAO();
        Street str = strD.getDomainById(adr.getStreetId());

        aUADto.setStreetName(str.getStreetName());

        CommentJdbcDAO cmD = new CommentJdbcDAO();
        List<Comment> commL = cmD.findAll();
        List<Comment> resComL = new ArrayList<Comment>();

        List<User> usrL = new ArrayList<User>();


        for (Comment c : commL) {
            if (c.getAdvertId() == advert.getAdvertId()) {
                resComL.add(c);

            }
        }

        aUADto.setComments(resComL);

        for (Comment c : resComL) {
        User u = new User();
        usrL.add(ad.getDomainById(c.getUserId()));
        }

        aUADto.setUsers(usrL);
        out.printf("test");
        out.printf("test");

        return aUADto;

    }


}
