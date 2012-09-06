package org.realty;


import org.realty.dao.*;
import org.realty.dto.AdvertUserDTO;
import org.realty.entity.*;
import org.realty.hibernate.UserHibDAO;

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


        CityJdbcDAO cd = new CityJdbcDAO();
        List<City> cL = cd.findAll();

        	for (City o : cL) {

                out.printf("%d %s \n", o.getCityId(), o.getCityName());

               List<District> ds = o.getDistricts();
               for (District d :ds){
                   out.printf("%s \n",d.getDistrictName());
               }



        }



        DistrictJdbcDAO dd = new DistrictJdbcDAO();
        List<District> dL = dd.findAll();

        for (District o : dL) {

            out.printf("%d %s \n", o.getDistrictId(), o.getDistrictName());

            List<Street> sl = o.getStreets();
            for (Street d :sl){
                out.printf("%s \n",d.getStreetName());
            }



        }

        UserHibDAO test = new UserHibDAO();

        User testHib = new User();
        testHib.setName("testHib");
        testHib.setPassword("12345");
        testHib.setPhoneNumber("258456");
        testHib.setAdmin(false);

        test.create(testHib);



/*        AdvertJdbcDAO ad = new AdvertJdbcDAO();
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
        }*/


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
