package org.realty.commands.del;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.UserJdbcDAO;

public class DelUserCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

		UserJdbcDAO ad = new UserJdbcDAO();
		String delUserId = request.getParameter("delUserId");
		ad.delete((Long)Long.parseLong(delUserId));

		return CommandFactory.getCommand("allUser").execute(request, response);

	}

}
