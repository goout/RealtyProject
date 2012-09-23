package org.realty.commands.del;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.entity.Adress;
import org.realty.entity.Advert;
import org.realty.hibernate.AdressHibDAO;
import org.realty.hibernate.AdvertHibDAO;

public class DelAdvertCommand implements Command {
    private AdvertHibDAO advH;
    private AdressHibDAO adrH;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

	//	AdvertJdbcDAO ad = new AdvertJdbcDAO();
      //  AdvertHibDAO advH =new AdvertHibDAO();

		String delAdvertId = request.getParameter("delAdvertId");

       /* Adress del = adrH.read(Adress.class, Long.parseLong(delAdvertId));
        adrH.delete(del);*/
        Advert del = advH.read(Advert.class, Long.parseLong(delAdvertId));
       advH.delete(del);

	//	ad.delete(Long.parseLong(delAdvertId));

		//return CommandFactory.getCommand("allAdvert").execute(request, response);
        return "RealtyServlet?command=allAdvert";

	}

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }

    public void setAdrH(AdressHibDAO adrH) {
        this.adrH = adrH;
    }
}
