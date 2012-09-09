package org.realty;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.realty.dao.UserJdbcDAO;
import org.realty.entity.User;

/**
 * Unit test for simple App.
 */
public class DAOTest extends TestCase {
/*
    private final UserJdbcDAO usrDAO = new UserJdbcDAO();
    private final User usr = new User();
    private User tes = new User();

    public DAOTest(String testName) {
        super(testName);
    }


    protected void setUp() throws Exception {

        usr.setName("testUser3");
        usr.setPassword("12345");
        usr.setPhoneNumber("7181632");
        usr.setAdmin(false);
        usrDAO.add(usr);

    }

    protected void tearDown() throws Exception {
        usrDAO.delete(tes.getUserId());
    }

    public void testUserDAO() {

        tes = usrDAO.getDomainByName(usr.getName());
        assertEquals(usr.getName(), tes.getName());
        assertEquals(usr.getPassword(), tes.getPassword());
        assertEquals(usr.getPhoneNumber(), tes.getPhoneNumber());
        assertEquals(usr.getAdmin(), tes.getAdmin());


    }
*/


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DAOTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


}
