package org.realty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.org.realty.dao.AdvertJdbcDAO;
import org.realty.org.realty.dto.AdvertUserDTO;
import org.realty.org.realty.entity.Advert;

import javax.servlet.http.HttpSession;


public class AllAdvertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");


		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		List<Advert> alladverts = ad.findAll();

        List<AdvertUserDTO> alladvertsusers = createDTO(alladverts,iuser);

		request.setAttribute("alladvertsusers", alladvertsusers);
    Long parameter = (Long)session.getAttribute("id");
    for (Advert advert : alladverts) {
      if (advert.getAdvertId().equals(parameter)) {
        session.setAttribute("rootAdvert", advert);
        break;
      }
    }


    return "Advert.jsp";

	}

    public List<AdvertUserDTO> createDTO (List<Advert> adverts, UsrInfo user)  {

        List<AdvertUserDTO> laud = new ArrayList<AdvertUserDTO>();
        int i =0;
        for (Advert o : adverts) {
            AdvertUserDTO aud = new AdvertUserDTO();
            aud.setAddedDate(o.getAddedDate());
            aud.setCategory(o.getCategory());
            aud.setAdressId(o.getAdressId());
            aud.setCoast(o.getCoast());
            aud.setDescription(o.getDescription());
            aud.setAdvertId(o.getAdvertId());
            aud.setAdvertUserId(o.getUserId());
            aud.setRooms(o.getRooms());


            laud.add(i,aud);
            i++;
        }


            AdvertUserDTO aud = new AdvertUserDTO();
            aud.setUserId(user.getUserId());
            aud.setName(user.getUserName());

            laud.add(i,aud);



        return laud;

    }

}