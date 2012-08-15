package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.Comment;

public class AddCommentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommentJdbcDAO ad = new CommentJdbcDAO();
		String text = request.getParameter("text");
		String advertId = request.getParameter("advertId"); //?
		String userId = request.getParameter("userId"); //?

		Comment comment = new Comment();
		comment.setText(text);
		comment.setUserId(Long.parseLong(userId));
		comment.setAdvertId(Long.parseLong(advertId));

		ad.add(comment);

		return CommandFactory.getCommand("allComment").execute(request, response);

	}

}