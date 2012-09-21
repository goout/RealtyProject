package org.realty.commands.del;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;
import org.realty.hibernate.UserHibDAO;

public class DelUserCommand implements Command {
    private UserHibDAO usrH;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {


		//UserJdbcDAO ad = new UserJdbcDAO();
		String delUserId = request.getParameter("delUserId");
		//ad.delete((Long)Long.parseLong(delUserId));                  //(Long)?
        User del = usrH.read(User.class,Long.parseLong(delUserId));
        usrH.delete(del);

		//return CommandFactory.getCommand("allUser").execute(request, response);
        return "RealtyServlet?command=allUser";

	}

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}
