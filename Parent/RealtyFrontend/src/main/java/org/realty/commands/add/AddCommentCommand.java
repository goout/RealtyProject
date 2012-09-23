package org.realty.commands.add;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.realty.UsrInfo;
import org.realty.commands.Command;
import org.realty.commands.CommandFactory;
import org.realty.dao.CommentJdbcDAO;
import org.realty.entity.Advert;
import org.realty.entity.Comment;
import org.realty.entity.User;
import org.realty.hibernate.AdvertHibDAO;
import org.realty.hibernate.CommentHibDAO;
import org.realty.hibernate.UserHibDAO;

public class AddCommentCommand implements Command {
    private CommentHibDAO cmntH;
    private UserHibDAO usrH;
    private AdvertHibDAO advH;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {

		//CommentJdbcDAO ad = new CommentJdbcDAO();
       // CommentHibDAO cmntH = new CommentHibDAO();
		String text = request.getParameter("text");
		String advertId = request.getParameter("advertId"); //?
		String userId = request.getParameter("userId"); //?

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        //  dateFormat.format(date);

		Comment comment = new Comment();
		comment.setText(text);

        User user2 = usrH.read(User.class,Long.parseLong(userId));
        Advert advert2 = advH.read(Advert.class,Long.parseLong(advertId));

		comment.setUser(user2);
		comment.setAdvert(advert2);
        comment.setAddedDate(dateFormat.format(date));


        cmntH.create(comment);

        HttpSession session = request.getSession();
        UsrInfo iuser = (UsrInfo) session.getAttribute("userInfo");

	//	return CommandFactory.getCommand("allComment").execute(request, response);
        return iuser.IsAdmin() ? "RealtyServlet?command=allComment"
                : "RealtyServlet?command=advertPage";
	}

    public void setCmntH(CommentHibDAO cmntH) {
        this.cmntH = cmntH;
    }

    public void setUsrH(UserHibDAO usrH) {
        this.usrH = usrH;
    }

    public void setAdvH(AdvertHibDAO advH) {
        this.advH = advH;
    }
}