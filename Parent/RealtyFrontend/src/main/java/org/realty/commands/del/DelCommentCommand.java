package org.realty.commands.del;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.CommentJdbcDAO;
import org.realty.entity.Comment;
import org.realty.hibernate.CommentHibDAO;

public class DelCommentCommand implements Command {
    private CommentHibDAO cmntH;

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {


       // CommentHibDAO cmntH = new CommentHibDAO();

		//CommentJdbcDAO ad = new CommentJdbcDAO();
		String delCommentId = request.getParameter("delCommentId");
		Comment del = cmntH.read(Comment.class,Long.parseLong(delCommentId));
        cmntH.delete(del);
        //ad.delete(Long.parseLong(delCommentId));

		//return CommandFactory.getCommand("allComment").execute(request, response);
        return "RealtyServlet?command=allComment";
	}

    public void setCmntH(CommentHibDAO cmntH) {
        this.cmntH = cmntH;
    }
}