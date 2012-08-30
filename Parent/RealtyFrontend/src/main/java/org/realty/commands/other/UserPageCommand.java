package org.realty.commands.other;


import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.UserJdbcDAO;
import org.realty.dto.AdvertUserDTO;
import org.realty.entity.Advert;
import org.realty.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPageCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {




        AdvertJdbcDAO ad = new AdvertJdbcDAO();
        List<Advert> alladverts = ad.findAll();

        List<AdvertUserDTO> allAdvertsUsrDto = createDTO(alladverts);

        request.setAttribute("allAdvertsUsrDto", allAdvertsUsrDto);


        return "UserPage.jsp";

    }

    public List<AdvertUserDTO> createDTO (List<Advert> adverts)  {

        List<AdvertUserDTO> audto = new ArrayList<AdvertUserDTO>();
        int i =0;
        for (Advert o : adverts) {
            AdvertUserDTO aUDto = new AdvertUserDTO();

            aUDto.setAdvertId(o.getAdvertId());
            aUDto.setAddedDate(o.getAddedDate());
            aUDto.setCategory(o.getCategory());
            aUDto.setAdvertUserId(o.getUserId());
            aUDto.setCoast(o.getCoast());
            aUDto.setDescription(o.getDescription());

            UserJdbcDAO ad = new UserJdbcDAO();
            User user = ad.getDomainById(o.getUserId());
            aUDto.setUserName(user.getName());


            audto.add(i,aUDto);
            i++;
        }


        return audto;

    }

}