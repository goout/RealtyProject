package org.realty.commands.other;

import static java.lang.System.out;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;
import org.realty.hibernate.UserHibDAO;

public class AuthenticationCommand implements Command {
    private UserHibDAO usrH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//UserJdbcDAO ad = new UserJdbcDAO();
		//List<User> registeredUsers = ad.findAll();
        List<User> registeredUsers = usrH.getAllUsers();
		Boolean fl = false;

		try {

			for (User user : registeredUsers) {

				if (user.getName().equalsIgnoreCase(
						request.getParameter("name"))
						&& user.getPassword().equalsIgnoreCase(
								request.getParameter("password"))) {
					out.println("User Authenticated");
					fl = true;
					UsrInfo ui = new UsrInfo();
					ui.Login(request.getParameter("name"));
                    ui.setUserId(user.getUserId());

                    if(user.getAdmin()){
                        ui.Admin();
                        Boolean admin = true;
                        session.setAttribute("admin", admin);
                    }
					session.setAttribute("userInfo", ui);


					break;
				} else {
					out.println("You are not an authentic person");
					fl = false;
				}
			}

		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}

		return fl ? "RealtyServlet?command=userPage"
				: "RealtyServlet?command=indexGuest";
	}

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}
