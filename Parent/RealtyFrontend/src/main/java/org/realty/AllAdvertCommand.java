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
				
		request.setAttribute("alladverts", alladverts);
		
		UserJdbcDAO ad2 = new UserJdbcDAO();
		List<User> allusers = ad2.findAll();
		
		request.setAttribute("allusers", allusers);
		
		
		return "Advert.jsp";

	}

}