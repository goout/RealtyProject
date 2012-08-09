package org.realty;


import java.sql.SQLException;



//import static java.lang.System.out;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        	       
        
        User test1 = new User();
        test1.setName("ivander2");
        test1.setPassword("12345678");
        test1.setPhoneNumber("5123449");
   
        UserJdbcDAO addtest1 = new UserJdbcDAO();
        
        addtest1.add(test1);
               
        

        
                
    }
}
