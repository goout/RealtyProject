package org.realty;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.org.realty.dao.AdvertJdbcDAO;
import org.realty.org.realty.entity.Advert;


public class IndexGuestCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		List<Advert> alladverts = ad.findAll();
				
		request.setAttribute("alladverts", alladverts);
			
		
		return "index.jsp";

	}

}