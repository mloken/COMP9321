package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionFactory;
import common.ServiceLocatorException;
import beans.UserBean;
import dao.DataAccessException;
import dao.UserDAO;

public class UserDAOImpl implements UserDAO{

	/**
	 * The service locator to retrieve database connections from
	 */
	private DBConnectionFactory services;
	
	public UserDAOImpl(){
		try {
			services = new DBConnectionFactory();
		} catch (ServiceLocatorException e) {
			e.printStackTrace();
		}
	}
	
	public UserDAOImpl(DBConnectionFactory services) {
		this.services = services;
	}
	
	@Override
	public UserBean findByLoginDetails(String username, String password)
			throws DataAccessException {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("select * from tbl_users where username = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				UserBean user = createUserBean(rs);
				stmt.close(); 
				return user;
			}
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; " + e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; " + e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	private UserBean createUserBean(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
