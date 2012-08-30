package org.realty;


import org.realty.dao.AdvertJdbcDAO;
import org.realty.dao.CommentJdbcDAO;
import org.realty.dao.UserJdbcDAO;
import org.realty.dto.AdvertUserDTO;
import org.realty.entity.Advert;
import org.realty.entity.Comment;
import org.realty.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws SQLException {


        AdvertJdbcDAO ad = new AdvertJdbcDAO();
          Advert advert = ad.getDomainById(1l);

        CommentJdbcDAO cmD = new CommentJdbcDAO();
        List<Comment> commL = cmD.findAll();
        List<Comment> resComL = new ArrayList<Comment>();

        for (Comment c : commL) {
            Comment com = new Comment();
            if (c.getAdvertId()==advert.getAdvertId()){

                com.setCommentId(c.getCommentId());
                com.setText(c.getText());
                com.setAdvertId(c.getAdvertId());
                com.setUserId(c.getUserId());

                resComL.add(com);
                out.printf("%s",com.getText());

            }
        }


	//	UserJdbcDAO addtest1 = new UserJdbcDAO();
    //    User test = addtest1.getDomainById(24L)   ;
      //  out.printf("ooo:%s", test.getName());
	

	//	List<User> users = new ArrayList<User>();

	//	users = addtest1.findAll();

		
	//	for (User o : users) {

	//		out.printf("%10d %9s %12s %15s\n", o.getUserId(), o.getName(),
	//				o.getPassword(), o.getPhoneNumber());
		//}
		
		//addtest1.delete(24L);
		


	}
}
