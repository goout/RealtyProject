package org.realty.commands.add;


import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdressJdbcDAO;

import org.realty.entity.Adress;
import org.realty.hibernate.AdressHibDAO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


public class AddAdressCommand implements Command {
      private AdressHibDAO adrH;
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException, ParseException {

    //AdressJdbcDAO adrDao = new AdressJdbcDAO();
   // AdressHibDAO adrH = new AdressHibDAO();

    HttpSession session = request.getSession();
    String city = request.getParameter("city");
    String district = request.getParameter("district");
    String street = request.getParameter("street");
    String homeNum = request.getParameter("homeNum");
    String apartmentNum = request.getParameter("apartmentNum");

        Adress adress = new Adress();
        adress.setCityId(Long.parseLong(city));
        adress.setDistrictId(Long.parseLong(district));
        adress.setStreetId(Long.parseLong(street));
        adress.setHouseNum(Integer.parseInt(homeNum));
        adress.setApartmentNum(Integer.parseInt(apartmentNum));

    //adrDao.add(adress);
      adrH.create(adress);

        List<Adress> adressList = adrH.getAllAdress();
        Adress lastAdr = adressList.get(adressList.size()-1);
        Long adressId = lastAdr.getAdressId();
        System.out.printf("%d",adressId);


        session.setAttribute("adressId", adressId);



  //  return CommandFactory.getCommand("advert").execute(request, response);
     // return "AddAdvertPage.jsp";
        return "RealtyServlet?command=advert";
    }

    public void setAdrH(AdressHibDAO adrH) {
        this.adrH = adrH;
    }
}
