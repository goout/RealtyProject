package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.realty.Advert;
import org.realty.Comment;
import org.realty.User;

public class AllCommentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

		CommentJdbcDAO ad = new CommentJdbcDAO();
		List<Comment> allcomments = ad.findAll();

        AdvertJdbcDAO ad3 = new AdvertJdbcDAO();
        List<Advert> alladverts = ad3.findAll();


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
            cuad.setCommentUserId(c.getUserId());
            cuad.setCommentAdvertId(c.getAdvertId());

            lcuad.add(i, cuad);
            i++;
        }

        CommentUserAdvertDTO cuad = new CommentUserAdvertDTO();
        cuad.setUserId(user.getUserId());
        cuad.setName(user.getUserName());

        lcuad.add(i, cuad);



        return lcuad;

    }


}