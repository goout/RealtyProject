package org.realty.commands.all;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.CommentJdbcDAO;
import org.realty.dto.CommentUserAdvertDTO;
import org.realty.entity.Advert;
import org.realty.entity.Comment;
import org.realty.entity.User;
import org.realty.hibernate.AdvertHibDAO;
import org.realty.hibernate.CommentHibDAO;

public class AllCommentCommand implements Command {
    private CommentHibDAO cmntH;
    private AdvertHibDAO advH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

	//	CommentJdbcDAO ad = new CommentJdbcDAO();
       /// CommentHibDAO cmntH = new CommentHibDAO();
		List<Comment> allcomments = cmntH.getAllComments();

      //  AdvertJdbcDAO ad3 = new AdvertJdbcDAO();
      //  AdvertHibDAO advH =new AdvertHibDAO();
        List<Advert> alladverts = advH.getAllAdverts();


        List<CommentUserAdvertDTO> allCommentsUserAdverts = createDTO(alladverts,iuser,allcomments);


        request.setAttribute("allCommentsUserAdverts", allCommentsUserAdverts);
		
		

		return "Comment.jsp";

	}


    public List<CommentUserAdvertDTO> createDTO (List<Advert> adverts, UsrInfo user, List<Comment> comments)  {

        List<CommentUserAdvertDTO> lcuad = new ArrayList<CommentUserAdvertDTO>();
        int i =0;
        for (Advert o : adverts) {
            CommentUserAdvertDTO cuad = new CommentUserAdvertDTO();

            cuad.setAdvertId(o.getAdvertId());
            cuad.setDescription(o.getDescription());

            lcuad.add(i, cuad);
            i++;
        }

        for (Comment c : comments) {
            CommentUserAdvertDTO cuad = new CommentUserAdvertDTO();

           cuad.setCommentId(c.getCommentId());
            cuad.setText(c.getText());
            User user2 = c.getUser();
            Advert adver2 = c.getAdvert();
            cuad.setCommentUserId(user2.getUserId());
            cuad.setCommentAdvertId(adver2.getAdvertId());

            lcuad.add(i, cuad);
            i++;
        }

        CommentUserAdvertDTO cuad = new CommentUserAdvertDTO();
        cuad.setUserId(user.getUserId());
        cuad.setName(user.getUserName());

        lcuad.add(i, cuad);



        return lcuad;

    }


    public void setCmntH(CommentHibDAO cmntH) {
        this.cmntH = cmntH;
    }

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }
}