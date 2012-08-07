package org.realty;

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
        addtest1.add(test1);
        
           
        
    }
}
