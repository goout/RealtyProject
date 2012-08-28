package org.realty.commands.all;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;

public class AllUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		UserJdbcDAO ad = new UserJdbcDAO();
		List<User> allusers = ad.findAll();
		
	  request.getSession().setAttribute("id", new Long(1L));
		request.setAttribute("allusers", allusers);
		
		return "User.jsp";

	}

}