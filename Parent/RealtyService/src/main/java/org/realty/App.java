package org.realty;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! test" );
        
        User test1 = new User();
        test1.setname("ivan");
        test1.setpassword("12345678");
        test1.setphoneNumber("5123449");
   
        UserJdbcDAO addtest1 = new UserJdbcDAO();
       // addtest1.add(test1);
        
/*        Advert test2 = new Advert();
        test2.setaddedDate(new Date(System.currentTimeMillis()));
        test2.setcategory("Sale");
        test2.setdistrict("Oktjabr'skij");
        test2.setadress("testadress 14");
        test2.setcoast(1000);
        test2.setdescription("good flat for everybody");
        test2.setuserId(24);
        test2.setadvertId(2);
       
              
        AdvertJdbcDAO addadverttest1 = new AdvertJdbcDAO();
      //  addadverttest1.add(test2);
        
       
        test2.setadress("poi poi poi");
        addadverttest1.update(test2,2);*/
        
    /*    addtest1.delete(25);
        
        AdvertJdbcDAO addadverttest1 = new AdvertJdbcDAO();
        addadverttest1.delete(2);*/
        
        AdvertJdbcDAO addadverttest1 = new AdvertJdbcDAO();
        
        List<Advert> adverts = new ArrayList<Advert>();
        
        adverts = addadverttest1.findAll();
        
    	for (Advert o : adverts) {
			out.printf("%10s %9s %12d %15d\n", o.getdistrict(), o.getadress(), o.getcoast(),
					o.getadvertId());
		}
        
        
    }
}
