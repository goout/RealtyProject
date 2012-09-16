package org.realty.commands.add;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;
import org.realty.hibernate.UserHibDAO;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddUserCommand implements Command {
    private UserHibDAO usrH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

		//UserJdbcDAO ad = new UserJdbcDAO();
        //UserHibDAO usrH =new UserHibDAO();
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
		usrH.create(user);

        //////??????
     /*   User sesUsr = ad.getDomainByName(userName);

        UsrInfo ui = new UsrInfo();
        ui.Login(sesUsr.getName());
        ui.setUserId(sesUsr.getUserId());
        session.setAttribute("userInfo", ui);*/
        ////???????
		//return CommandFactory.getCommand("allUser").execute(request, response);
        UsrInfo ui = (UsrInfo)session.getAttribute("userInfo");


        return ui.IsAdmin() ? "RealtyServlet?command=allUser"
                : "RealtyServlet?command=userPage";

	}

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}