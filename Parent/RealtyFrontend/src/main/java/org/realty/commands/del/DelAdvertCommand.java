package org.realty.commands.del;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdvertJdbcDAO;

public class DelAdvertCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		AdvertJdbcDAO ad = new AdvertJdbcDAO();
		String delAdvertId = request.getParameter("delAdvertId");
		ad.delete(Long.parseLong(delAdvertId));

		return CommandFactory.getCommand("allAdvert").execute(request, response);

	}

}
