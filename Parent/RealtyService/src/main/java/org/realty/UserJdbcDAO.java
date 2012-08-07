package org.realty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO {

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;

	public UserJdbcDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(User user) {

		try {
			String querystring = "INSERT INTO User VALUES(?,?,?,?)";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setString(1, null);
			ptmt.setString(2, user.getname());
			ptmt.setString(3, user.getpassword());
			ptmt.setString(4, user.getphoneNumber());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void update(User user) {

		try {
			String querystring = "UPDATE User SET name=?,passwordt=?,phone_number=? WHERE user_id=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setString(1, user.getname());
			ptmt.setString(2, user.getpassword());
			ptmt.setString(3, user.getphoneNumber());
			ptmt.setInt(4, user.getuserId());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void delete(int userId) {

		try {
			String querystring = "DELETE FROM User WHERE user_id=?";
			con = getConnection();
			ptmt = con.prepareStatement(querystring);
			ptmt.setInt(1, userId);
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ptmt != null)
					ptmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	
	 public List<User> findAll()
	  {
	   List<User> users=new ArrayList<User>();
	   User user=null;
	   try
	   {
	    String querystring="SELECT * FROM User";
	    con=getConnection();
	    ptmt=con.prepareStatement(querystring);
	    rs=ptmt.executeQuery();
	    while(rs.next())
	    {
	     user=new User();
	     user.setuserId(rs.getInt(1));
	     user.setname(rs.getString(2));
	     user.setpassword(rs.getString(3));
	     user.setphoneNumber(rs.getString(4));
	     
	     users.add(user);
	    }
	   }
	   catch(SQLException e)
	   {
	    e.printStackTrace();
	   }
	   finally
	   {
	    try
	    {
	    if(rs!=null)
	        rs.close();
	    if(ptmt!=null)
	       ptmt.close();
	    if(con!=null)
	       con.close();
	    }
	    catch(SQLException e)
	    {
	     e.printStackTrace();
	    }
	    catch(Exception e)
	    {
	     e.printStackTrace();
	    }
	    
	   }
	   return users;
	  }
}
