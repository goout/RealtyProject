package org.realty.commands.all;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dto.AdvertUserAdressDTO;
import org.realty.entity.Adress;
import org.realty.entity.Advert;
import org.realty.entity.User;
import org.realty.hibernate.AdressHibDAO;
import org.realty.hibernate.AdvertHibDAO;

import javax.servlet.http.HttpSession;


public class AllAdvertCommand implements Command {
    private AdvertHibDAO advH;
    private AdressHibDAO adrH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");


		//AdvertJdbcDAO ad = new AdvertJdbcDAO();
        //AdvertHibDAO advH = new AdvertHibDAO();
        List<Advert> alladverts = advH.getAllAdverts();

        List<AdvertUserAdressDTO> alladvertsusers = createDTO(alladverts,iuser);

		request.setAttribute("alladvertsusers", alladvertsusers);


        ///
    Long parameter = (Long)session.getAttribute("id");
    for (Advert advert : alladverts) {
      if (advert.getAdvertId().equals(parameter)) {
        session.setAttribute("rootAdvert", advert);
        break;
      }
    }
     ///

    return "Advert.jsp";

	}

    public List<AdvertUserAdressDTO> createDTO (List<Advert> adverts, UsrInfo user)  {

        List<AdvertUserAdressDTO> laud = new ArrayList<AdvertUserAdressDTO>();
        int i =0;
        for (Advert o : adverts) {
            AdvertUserAdressDTO aud = new AdvertUserAdressDTO();
            aud.setAddedDate(o.getAddedDate());
            aud.setCategory(o.getCategory());
            Adress adress = o.getAdress();
            aud.setAdvertAdressId(adress.getAdressId());
            aud.setCoast(o.getCoast());
            aud.setDescription(o.getDescription());
            aud.setAdvertId(o.getAdvertId());

            User user2 = o.getUser();

            aud.setAdvertUserId(user2.getUserId());

            aud.setRooms(o.getRooms());


            laud.add(i,aud);
            i++;
        }


            AdvertUserAdressDTO aud = new AdvertUserAdressDTO();
            aud.setUserId(user.getUserId());
            aud.setName(user.getUserName());

            laud.add(i,aud);



        return laud;

    }

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }

    public void setAdrH(AdressHibDAO adrH) {
        this.adrH = adrH;
    }
}