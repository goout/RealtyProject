package org.realty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

import org.realty.Advert;

public class AddAdvertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		String category = request.getParameter("category");
        String city = request.getParameter("city");
		String district = request.getParameter("district");
		String adress = request.getParameter("adress");
		String coast = request.getParameter("coast");
		String description = request.getParameter("description");
		String userId = request.getParameter("userId");

		Advert advert = new Advert();
		advert.setCategory(category);
        advert.setCity(city);
        advert.setDistrict(district);
        advert.setAdress(adress);
        advert.setCoast(Integer.parseInt(coast));
        advert.setDescription(description);
        advert.setUserId(Long.parseLong(userId));
		ad.add(advert);

		return CommandFactory.getCommand("allAdvert")
				.execute(request, response);

	}

}