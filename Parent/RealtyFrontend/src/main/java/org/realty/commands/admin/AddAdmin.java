package org.realty.commands.admin;

import org.realty.commands.Command;
import org.realty.entity.User;
import org.realty.hibernate.UserHibDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;


public class AddAdmin implements Command {

    private UserHibDAO usrH;

    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException, ParseException {



        String UserId = request.getParameter("UserId");

        User addAdmin = usrH.read(User.class,(Long)Long.parseLong(UserId));
        addAdmin.setAdmin(true);
        usrH.update(addAdmin);

       return "RealtyServlet?command=allUser";

    }

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }



}
