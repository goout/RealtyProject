package org.realty.commands.data;


import org.realty.commands.Command;
import org.realty.dao.*;
import org.realty.dto.AdvertUserAdressDTO;
import org.realty.dto.CommentsInfo;
import org.realty.entity.*;
import org.realty.hibernate.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class AdvertPageCommand implements Command {
    private AdvertHibDAO advH;
    private UserHibDAO usrH;
    private AdressHibDAO adrH;
    private CityHibDAO cityH;
    private DistrictHibDAO distrH;
    private StreetHibDAO strH;
    private CommentHibDAO cmntH;

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //AdvertJdbcDAO ad = new AdvertJdbcDAO();
       // AdvertHibDAO advH =new AdvertHibDAO();
        Long aid = null;


  /*      if (session.getAttribute("advertId") == null) {
            Long advertId = Long.parseLong(request.getParameter("advertId"));
            session.setAttribute("advertId", advertId);
        }*/


        if(request.getParameter("advertId")==null){
        aid = (Long)session.getAttribute("advertId");
        }  else   aid = Long.parseLong(request.getParameter("advertId"));
        session.setAttribute("advertId", aid);


       // Advert advert = ad.getDomainById(aid);
        Advert advert = advH.read(Advert.class,aid);
        AdvertUserAdressDTO allAdvertsUsrAdrDto = createDTO(advert);

        request.setAttribute("allAdvertsUsrAdrDto", allAdvertsUsrAdrDto);



        return "AdvertPage.jsp";

    }

    public AdvertUserAdressDTO createDTO(Advert advert) {


        AdvertUserAdressDTO aUADto = new AdvertUserAdressDTO();

        aUADto.setAdvertId(advert.getAdvertId());
        aUADto.setAddedDate(advert.getAddedDate());
        aUADto.setCategory(advert.getCategory());
        aUADto.setAdvertUserId(advert.getUserId());
        aUADto.setCoast(advert.getCoast());
        aUADto.setDescription(advert.getDescription());
        aUADto.setAdvertAdressId(advert.getAdressId());
        aUADto.setRooms(advert.getRooms());

        //UserJdbcDAO ad = new UserJdbcDAO();
        //  UserHibDAO usrH = new UserHibDAO();
        User user = usrH.read(User.class,advert.getUserId());
        //User user = ad.getDomainById(advert.getUserId());

        aUADto.setName(user.getName());
        aUADto.setPhoneNumber(user.getPhoneNumber());

        //AdressHibDAO adrH = new AdressHibDAO();
        Adress a =advert.getAdress();
        Adress adr = adrH.read(Adress.class,a.getAdressId());
        //AdressJdbcDAO adD = new AdressJdbcDAO();
        //Adress adr = adD.getDomainById(advert.getAdressId());

        aUADto.setHouseNum(adr.getHouseNum());
        aUADto.setApartmentNum(adr.getApartmentNum());

        City cit2 =adr.getCity();

        City cit = cityH.read(City.class,cit2.getCityId());
        //CityJdbcDAO citD = new CityJdbcDAO();
        //City cit = citD.getDomainById(adr.getCityId());

        aUADto.setCityName(cit.getCityName());

        District dis2 = adr.getDistrict();
        District dis = distrH.read(District.class,dis2.getDistrictId());
       // DistrictJdbcDAO diD = new DistrictJdbcDAO();
        //District dis = diD.getDomainById(adr.getDistrictId());

        aUADto.setDistrictName(dis.getDistrictName());

        Street str2 = adr.getStreet();
        Street str = strH.read(Street.class,str2.getStreetId());
        //StreetJdbcDAO strD = new StreetJdbcDAO();
       // Street str = strD.getDomainById(adr.getStreetId());

        aUADto.setStreetName(str.getStreetName());

        //CommentJdbcDAO cmD = new CommentJdbcDAO();

        List<Comment> commL = cmntH.getAllComments();
        List<Comment> resComL = new ArrayList<Comment>();

        List<User> usrL = new ArrayList<User>();


        for (Comment c : commL) {
            if (c.getAdvertId() == advert.getAdvertId()) {
                resComL.add(c);

            }
        }

        aUADto.setComments(resComL);

        for (Comment c : resComL) {
            User u = new User();
            usrL.add(usrH.read(User.class,c.getUserId()));
        }

        aUADto.setUsers(usrL);


        List<CommentsInfo> cmntI = new ArrayList<CommentsInfo>();

        int i;
        for(i=0; i<usrL.size(); i++){
            CommentsInfo ci = new CommentsInfo();
            ci.setName(usrL.get(i).getName());
            ci.setAddedDate(resComL.get(i).getAddedDate());
            ci.setText(resComL.get(i).getText());
            cmntI.add(ci);

        }

        aUADto.setComnInfo(cmntI);

        return aUADto;

    }


    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
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

    public void setCmntH(CommentHibDAO cmntH) {
        this.cmntH = cmntH;
    }
}
