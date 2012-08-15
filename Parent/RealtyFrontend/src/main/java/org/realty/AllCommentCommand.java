package org.realty;

import static java.lang.System.out;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.Comment;

public class AllCommentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommentJdbcDAO ad = new CommentJdbcDAO();
		List<Comment> allcomments = ad.findAll();

		request.setAttribute("allcomments", allcomments);

		return "Comment.jsp";

	}

}