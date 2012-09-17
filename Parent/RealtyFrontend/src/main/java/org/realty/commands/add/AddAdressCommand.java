package org.realty.commands.add;


import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.AdressJdbcDAO;

import org.realty.entity.Adress;
import org.realty.entity.City;
import org.realty.entity.District;
import org.realty.entity.Street;
import org.realty.hibernate.AdressHibDAO;
import org.realty.hibernate.CityHibDAO;
import org.realty.hibernate.DistrictHibDAO;
import org.realty.hibernate.StreetHibDAO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


public class AddAdressCommand implements Command {
      private AdressHibDAO adrH;
      private CityHibDAO cityH;
      private DistrictHibDAO distrH;
      private StreetHibDAO strH;
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

       // CityHibDAO c = new CityHibDAO();
        City cit2 = cityH.read(City.class,Long.parseLong(city));

        //DistrictHibDAO d = new DistrictHibDAO();
        District dis2 = distrH.read(District.class,Long.parseLong(district));

       // StreetHibDAO s = new StreetHibDAO();
        Street str2 = strH.read(Street.class,Long.parseLong(street));

       // adress.setCityId(cit2.getCityId());
        adress.setCity(cit2);
        //adress.setDistrictId(Long.parseLong(district));
        adress.setDistrict(dis2);

        //adress.setStreetId(Long.parseLong(street));
        adress.setStreet(str2);

        adress.setHouseNum(Integer.parseInt(homeNum));
        adress.setApartmentNum(Integer.parseInt(apartmentNum));

    //adrDao.add(adress);

      adrH.create(adress);

        List<Adress> adressList = adrH.getAllAdress();
        Adress lastAdr = adressList.get(adressList.size()-1);
        Long adressId = lastAdr.getAdressId();

        session.setAttribute("adressId", adressId);



  //  return CommandFactory.getCommand("advert").execute(request, response);
     // return "AddAdvertPage.jsp";
        return "RealtyServlet?command=advert";
    }

    public void setAdrH(AdressHibDAO adrH) {
        this.adrH = adrH;
    }

    public void setCityH(CityHibDAO cityH) {
        this.cityH = cityH;
    }

    public void setDistrH(DistrictHibDAO distrH) {
        this.distrH = distrH;
    }

    public void setStrH(StreetHibDAO strH) {
        this.strH = strH;
    }
}
