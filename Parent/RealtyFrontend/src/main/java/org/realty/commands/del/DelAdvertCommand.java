package org.realty.commands.del;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.entity.Advert;
import org.realty.hibernate.AdvertHibDAO;

public class DelAdvertCommand implements Command {
    private AdvertHibDAO advH;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

	//	AdvertJdbcDAO ad = new AdvertJdbcDAO();
      //  AdvertHibDAO advH =new AdvertHibDAO();

		String delAdvertId = request.getParameter("delAdvertId");

        Advert del = advH.read(Advert.class, Long.parseLong(delAdvertId));
        advH.delete(del);

	//	ad.delete(Long.parseLong(delAdvertId));

		//return CommandFactory.getCommand("allAdvert").execute(request, response);
        return "RealtyServlet?command=allAdvert";

	}

}
