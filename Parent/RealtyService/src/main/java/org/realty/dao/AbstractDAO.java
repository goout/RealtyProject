package org.realty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<DOMAIN extends Object> {

	public static final String driverClassName = "com.mysql.jdbc.Driver";
	public static final String connectionUrl = "jdbc:mysql://localhost:3306/realty";
	public static final String dbUser = "root";
	public static final String dbPwd = "1234";

	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	

	final public void add(DOMAIN arg) throws ParseException {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getAddSQL());
			addStep(arg);

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

	final public void update(DOMAIN arg, Long id) {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getUpdateSQL());
			updateStep(arg, id);

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

	final public void delete(Long id) {

		try {
			connectionStep();
			ptmt = con.prepareStatement(getDeleteSQL());
			deleteStep(id);

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




    final public DOMAIN getDomainById(Long id) {
     DOMAIN dom = null;
        try {
            connectionStep();
            ptmt = con.prepareStatement(getDomainByIdSQL());
            getDomainByIdStep(id);
            rs = ptmt.executeQuery();
            while (rs.next()) {

                dom=findAllStep();
            }

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
           return dom;
    }


    final public DOMAIN getDomainByName(String name) {
        DOMAIN dom = null;
        try {
            connectionStep();
            ptmt = con.prepareStatement(getDomainByNameSQL());
            getDomainByNameStep(name);
            rs = ptmt.executeQuery();
            while (rs.next()) {

                dom=findAllStep();
            }

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
        return dom;
    }

	
	public List<DOMAIN> findAll() {
		List<DOMAIN> domains = new ArrayList<DOMAIN>();

		try {
			connectionStep();
			ptmt = con.prepareStatement(getFindAllSQL());
			rs = ptmt.executeQuery();

			while (rs.next()) {

				domains.add(findAllStep());
			}

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
		return domains;
	}



    public List<DOMAIN> findAllForCity(Long id) {
        List<DOMAIN> domains = new ArrayList<DOMAIN>();

        try {
            connectionStep();
            ptmt = con.prepareStatement(getDistrIdForCitySQL());
            getDistrictsForCityStep(id);
            rs = ptmt.executeQuery();

            while (rs.next()) {

                domains.add(getDomainStep(findAllFCStep()));
                           }

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
        return domains;
    }



    final public Long getCDId(Long id) {
          Long rl = null;
        try {
            connectionStep();
            ptmt = con.prepareStatement(getCDId());
            getDistrictsForCityStep(id);
            rs = ptmt.executeQuery();
            while (rs.next()) {

                rl=findAllFCStep();

            }

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
        return rl;
    }

	
	
	protected void connectionStep() {
		con = createConnection();
	}


    abstract protected String getCDId() throws SQLException;

    abstract protected String getDistrIdForCitySQL() throws SQLException;

    abstract protected String getDomainByNameSQL() throws SQLException;

    abstract protected String getDomainByIdSQL() throws SQLException;

	abstract protected String getFindAllSQL() throws SQLException;

	abstract protected String getDeleteSQL() throws SQLException;

	abstract protected String getUpdateSQL() throws SQLException;

	abstract protected String getAddSQL() throws SQLException;

	abstract protected void updateStep(DOMAIN arg, Long id) throws SQLException;

	abstract protected void addStep(DOMAIN arg) throws SQLException, ParseException;

	abstract protected void deleteStep(Long id) throws SQLException;

	abstract protected DOMAIN findAllStep() throws SQLException;

    abstract protected void getDomainByIdStep(Long id) throws SQLException;

    abstract protected void getDomainByNameStep(String name) throws SQLException;

    abstract protected void getDistrictsForCityStep(Long id) throws SQLException;

    abstract protected Long findAllFCStep() throws SQLException;

    abstract protected DOMAIN getDomainStep(Long id) throws SQLException;

	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}


}
