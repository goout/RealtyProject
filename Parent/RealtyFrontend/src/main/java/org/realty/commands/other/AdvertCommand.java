package org.realty.commands.other;


import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dto.AdvertTestDTO;
import org.realty.dto.CommentTestDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdvertCommand implements Command {
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");


        Long adressId = (Long) session.getAttribute("adressId");

        AdvertTestDTO advDTO = new AdvertTestDTO();

        advDTO.setUserId(iuser.getUserId());

        advDTO.setAdressId(adressId);


        request.setAttribute("advDTO", advDTO);

        session.setAttribute("advertId", null);          ////mot i ne nado; prover'


        return "AddAdvertPage.jsp";


    }

}
