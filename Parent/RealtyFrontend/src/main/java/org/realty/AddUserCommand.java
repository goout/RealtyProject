package org.realty;

import org.realty.org.realty.dao.UserJdbcDAO;
import org.realty.org.realty.entity.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserJdbcDAO ad = new UserJdbcDAO();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");
        Boolean isadmin = false;
        String admin = request.getParameter("isAdmin");

        System.out.printf("nuuuu: %s", admin);


        if (admin.equalsIgnoreCase("1")){
            isadmin = true;
        }else isadmin = false;

		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
        user.setAdmin(isadmin);
		ad.add(user);

		return CommandFactory.getCommand("allUser").execute(request, response);

	}

}