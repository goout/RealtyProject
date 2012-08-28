package org.realty.commands.del;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.CommentJdbcDAO;

public class DelCommentCommand implements Command {

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CommentJdbcDAO ad = new CommentJdbcDAO();
		String delCommentId = request.getParameter("delCommentId");
		ad.delete(Long.parseLong(delCommentId));

		return CommandFactory.getCommand("allComment").execute(request, response);

	}

}