package org.realty.commands.add;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

		UserJdbcDAO ad = new UserJdbcDAO();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phoneNumber");

        HttpSession session = request.getSession();

       // Boolean isadmin = false;
        //String admin = request.getParameter("isAdmin");

        //if (admin.equalsIgnoreCase("1")){
          //  isadmin = true;
        //}else isadmin = false;

		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
        //user.setAdmin(isadmin);
		ad.add(user);

        User sesUsr = ad.getDomainByName(userName);

        UsrInfo ui = new UsrInfo();
        ui.Login(sesUsr.getName());
        ui.setUserId(sesUsr.getUserId());
        session.setAttribute("userInfo", ui);
		//return CommandFactory.getCommand("allUser").execute(request, response);



        return ui.IsAdmin() ? "RealtyServlet?command=allUser"
                : "RealtyServlet?command=userPage";

	}

}