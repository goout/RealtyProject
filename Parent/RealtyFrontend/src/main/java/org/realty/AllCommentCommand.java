package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.Advert;
import org.realty.Comment;
import org.realty.User;

public class AllCommentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommentJdbcDAO ad = new CommentJdbcDAO();
		List<Comment> allcomments = ad.findAll();

		request.setAttribute("allcomments", allcomments);
		
		UserJdbcDAO ad2 = new UserJdbcDAO();
		List<User> allusers = ad2.findAll();
		
		request.setAttribute("allusers", allusers);
		
		AdvertJdbcDAO ad3 = new AdvertJdbcDAO();
		List<Advert> alladverts = ad3.findAll();
				
		request.setAttribute("alladverts", alladverts);
		
		

		return "Comment.jsp";

	}

}