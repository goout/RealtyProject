package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.Advert;
import org.realty.User;

public class AllAdvertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {






		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		List<Advert> alladverts = ad.findAll();

        UserJdbcDAO ad2 = new UserJdbcDAO();
        List<User> allusers = ad2.findAll();

         List<AdvertUserDTO> alladvertsusers = createDTO(alladverts,allusers);

				
		request.setAttribute("alladvertsusers", alladvertsusers);
		


		
		return "Advert.jsp";

	}

    public List<AdvertUserDTO> createDTO (List<Advert> adverts, List<User> users)  {
        AdvertUserDTO aud = new AdvertUserDTO();
        List<AdvertUserDTO> laud = new ArrayList<AdvertUserDTO>();

        for (Advert o : adverts) {

            aud.setAddedDate(o.getAddedDate());
            aud.setCategory(o.getCategory());
            aud.setDistrict(o.getDistrict());
            aud.setAdress(o.getAdress());
            aud.setCoast(o.getCoast());
            aud.setDescription(o.getDescription());
            aud.setAdvertId(o.getAdvertId());
            aud.setAdvertUserId(o.getUserId());
            aud.setCity(o.getCity());

            laud.add(aud);
        }

        for (User u : users){

            aud.setUserId(u.getUserId());
            aud.setName(u.getName());
            aud.setPassword(u.getPassword());
            aud.setPhoneNumber(u.getPhoneNumber());
            aud.setAdmin(u.getAdmin());

            laud.add(aud);
        }

        return laud;

    }

}