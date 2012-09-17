package org.realty.commands.add;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.Adress;
import org.realty.entity.User;
import org.realty.hibernate.UserHibDAO;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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

        if(userName!=""&&password!=""&&phoneNumber!=""){
		User user = new User();
		user.setName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		usrH.create(user);
        }

        List<User> userList = usrH.getAllUsers();
        User lastUsr = userList.get(userList.size()-1);



        UsrInfo ui = new UsrInfo();

        if(userName!=""&&password!=""&&phoneNumber!=""){
        ui.Login(lastUsr.getName());
        ui.setUserId(lastUsr.getUserId());
        session.setAttribute("userInfo", ui);           }

       // UsrInfo ui = (UsrInfo)session.getAttribute("userInfo");


        return ui.IsLogin() ? "RealtyServlet?command=userPage":"RealtyServlet?command=indexGuest";

	}

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}