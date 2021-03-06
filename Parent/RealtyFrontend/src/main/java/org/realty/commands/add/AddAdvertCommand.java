package org.realty.commands.add;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.entity.Adress;
import org.realty.entity.Advert;
import org.realty.entity.User;
import org.realty.hibernate.AdressHibDAO;
import org.realty.hibernate.AdvertHibDAO;
import org.realty.hibernate.UserHibDAO;
import org.springframework.beans.factory.BeanFactory;

public class AddAdvertCommand implements Command {
        private AdvertHibDAO advH;
        private AdressHibDAO adrH;
         private UserHibDAO usrH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {



	//	AdvertJdbcDAO ad = new AdvertJdbcDAO();
       // AdvertHibDAO advH = new AdvertHibDAO();
		String category = request.getParameter("category");
        String adressId = request.getParameter("adressId");
		String coast = request.getParameter("coast");
		String description = request.getParameter("description");
		String userId = request.getParameter("userId");
        String rooms = request.getParameter("rooms");

             DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
             Date date = new Date();
        //  dateFormat.format(date);


        Advert advert = new Advert();
		advert.setCategory(category);
        advert.setAddedDate(dateFormat.format(date));

      //  AdressHibDAO adrH = new AdressHibDAO();

        Adress adr = adrH.read(Adress.class,Long.parseLong(adressId));

      //  advert.setAdressId(Long.parseLong(adressId));
        advert.setAdress(adr);

        advert.setCoast(Integer.parseInt(coast));
        advert.setDescription(description);

        User user2 = usrH.read(User.class,Long.parseLong(userId))   ;

        advert.setUser(user2);
        //  advert.set         ???

        advert.setRooms(Integer.parseInt(rooms));
	//	ad.add(advert);
        advH.create(advert);

		//return CommandFactory.getCommand("userPage")
			//	.execute(request, response);
        return "RealtyServlet?command=userPage";

	}

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }

    public void setAdrH(AdressHibDAO adrH) {
        this.adrH = adrH;
    }

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}