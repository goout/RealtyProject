package org.realty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.AdvertJdbcDAO;
import org.realty.UserJdbcDAO;

public class DelAdvertCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		String delAdvertId = request.getParameter("delAdvertId");
		ad.delete(Long.parseLong(delAdvertId));

		return CommandFactory.getCommand("allAdvert").execute(request, response);

	}

}
