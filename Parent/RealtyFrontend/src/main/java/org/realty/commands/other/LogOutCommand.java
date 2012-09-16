package org.realty.commands.other;

import org.realty.UsrInfo;
import org.realty.commands.Command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		   HttpSession session = request.getSession();  
		   UsrInfo User = (UsrInfo) session.getAttribute("userInfo");
		   User.Logout();
		   session.setAttribute("userInfo", User);
		   
		return "RealtyServlet?command=indexGuest";

	}

}