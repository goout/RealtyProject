package org.realty.commands.other;


import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.CommentJdbcDAO;
import org.realty.dto.CommentTestDTO;
import org.realty.dto.CommentUserAdvertDTO;
import org.realty.entity.Advert;
import org.realty.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommentCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

        if (session.getAttribute("advertId") == null) {
            Long advertId = Long.parseLong(request.getParameter("advertId"));
            session.setAttribute("advertId", advertId);
        }

        Long aid = (Long)session.getAttribute("advertId");
        CommentTestDTO cmnT = new CommentTestDTO();
        cmnT.setUserId(iuser.getUserId());
        cmnT.setAdvertId(aid);

        request.setAttribute("cmnT", cmnT);



        return "AddCommentPage.jsp";

    }




}
