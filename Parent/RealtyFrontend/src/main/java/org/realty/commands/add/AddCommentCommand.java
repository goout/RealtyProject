package org.realty.commands.add;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.CommentJdbcDAO;
import org.realty.entity.Comment;

public class AddCommentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

		CommentJdbcDAO ad = new CommentJdbcDAO();
		String text = request.getParameter("text");
		String advertId = request.getParameter("advertId"); //?
		String userId = request.getParameter("userId"); //?

		Comment comment = new Comment();
		comment.setText(text);
		comment.setUserId(Long.parseLong(userId));
		comment.setAdvertId(Long.parseLong(advertId));

		ad.add(comment);

        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

	//	return CommandFactory.getCommand("allComment").execute(request, response);
        return iuser.IsAdmin() ? "RealtyServlet?command=allComment"
                : "RealtyServlet?command=advertPage";
	}

}