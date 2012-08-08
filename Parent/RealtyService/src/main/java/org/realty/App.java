package org.realty;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	System.out.println( "Hello World! test" );
    	
        System.out.println( "Hello World! test" );
        
        User test1 = new User();
        test1.setName("ivander");
        test1.setPassword("12345678");
        test1.setPhoneNumber("5123449");
   
        UserJdbcDAO addtest1 = new UserJdbcDAO();
        addtest1.add(test1);
               
        
/*        Advert test2 = new Advert();
        test2.setAddedDate(new Date(System.currentTimeMillis()));
        test2.setCategory("Stest");
        test2.setDistrict("Oktjabr'skij");
        test2.setAdress("test");
        test2.setCoast(1230);
        test2.setDescription("everybody");
        test2.setUserId(24l);
        test2.setAdvertId(2l);
        
        AdvertJdbcDAO addadverttest1 = new AdvertJdbcDAO();
        
        addadverttest1.add(test2);*/
        
/*       List<Advert> adverts = new ArrayList<Advert>();
        
       adverts = addadverttest1.findAll();
        
   	for (Advert o : adverts) {
			out.printf("%10s %9s %12d %15d\n", o.getDistrict(), o.getAdress(), o.getCoast(),
					o.getAdvertId());
		}*/
        
        
    }
}
