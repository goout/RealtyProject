package org.realty.commands.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.entity.Advert;

public class AddAdvertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		String category = request.getParameter("category");
        String adressId = request.getParameter("adressId");
		String coast = request.getParameter("coast");
		String description = request.getParameter("description");
		String userId = request.getParameter("userId");
        String rooms = request.getParameter("rooms");

		Advert advert = new Advert();
		advert.setCategory(category);
        advert.setAdressId(Long.parseLong(adressId));
        advert.setCoast(Integer.parseInt(coast));
        advert.setDescription(description);
        advert.setUserId(Long.parseLong(userId));
        advert.setRooms(Integer.parseInt(rooms));
		ad.add(advert);

		return CommandFactory.getCommand("allAdvert")
				.execute(request, response);

	}

}