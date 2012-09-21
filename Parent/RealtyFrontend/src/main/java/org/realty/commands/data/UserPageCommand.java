package org.realty.commands.data;


import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.UserJdbcDAO;
import org.realty.dto.AdvertUserDTO;
import org.realty.entity.Advert;
import org.realty.entity.User;
import org.realty.hibernate.AdvertHibDAO;
import org.realty.hibernate.UserHibDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPageCommand implements Command {
    private AdvertHibDAO advH;
    private UserHibDAO usrH;

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        //AdvertJdbcDAO ad = new AdvertJdbcDAO();
        //List<Advert> alladverts = ad.findAll();
      //  String city = request.getParameter("city");
        String category = request.getParameter("categoryf");

        List<Advert> alladverts = advH.getAllAdverts();

        //if (category.equals("All")||category==null){
            if ("All".equals(category)||category==null){
        alladverts = advH.getAllAdverts();}

        if ("Rent".equals(category)){
            alladverts = advH.getRentAdverts();}

        if ("Sale".equals(category)){
            alladverts = advH.getSaleAdverts();}

        if ("Purchase".equals(category)){
            alladverts = advH.getPurchaseAdverts();}


        List<AdvertUserDTO> allAdvertsUsrDto = createDTO(alladverts);

        request.setAttribute("allAdvertsUsrDto", allAdvertsUsrDto);

        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

        Boolean testb = (Boolean)session.getAttribute("admin");

        session.setAttribute("admin", iuser.IsAdmin());

        return "UserPage.jsp";

    }

    public List<AdvertUserDTO> createDTO (List<Advert> adverts)  {

        List<AdvertUserDTO> audto = new ArrayList<AdvertUserDTO>();
        int i =0;
        for (Advert o : adverts) {
            AdvertUserDTO aUDto = new AdvertUserDTO();

            aUDto.setAdvertId(o.getAdvertId());
            aUDto.setAddedDate(o.getAddedDate());
            aUDto.setCategory(o.getCategory());
            aUDto.setAdvertUserId(o.getUserId());
            aUDto.setCoast(o.getCoast());
            aUDto.setDescription(o.getDescription());

           // UserJdbcDAO ad = new UserJdbcDAO();
           // User user = ad.getDomainById(o.getUserId());
            User user = usrH.read(User.class,o.getUserId());
            aUDto.setUserName(user.getName());


            audto.add(i,aUDto);
            i++;
        }


        return audto;

    }

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }
}
