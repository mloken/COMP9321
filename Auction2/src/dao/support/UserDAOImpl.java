package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionFactory;
import common.ServiceLocatorException;
import beans.AddressBean;
import beans.AuctionItemBean;
import beans.UserBean;
import dao.DataAccessException;
import dao.GenericDAO;
import dao.UserDAO;

public class UserDAOImpl extends GenericDAO implements UserDAO{

	/**
	 * The service locator to retrieve database connections from
	 */
	
	public UserDAOImpl(){
		super();
	}
	
	public UserDAOImpl(DBConnectionFactory services) {
		super(services);
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
				System.out.println("FOUND USER");
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

	private UserBean createUserBean(ResultSet rs) throws SQLException {
		UserBean user = new UserBean();
		System.out.println("Created user bean");
		user.setUid(rs.getInt("uid"));
		System.out.println("retrieved: uid");
		user.setFirstName(rs.getString("firstname"));
		System.out.println("retrieved: firstname");
		user.setLastName(rs.getString("lastname"));
		System.out.println("retrieved: lastname");
		user.setAccessLevel(rs.getInt("access_level"));
		System.out.println("retrieved: access_level");
		user.setUsername(rs.getString("username"));
		System.out.println("retrieved: username");
		user.setPassword(rs.getString("password"));
		System.out.println("retrieved: password");
		user.setEmail(rs.getString("email"));
		System.out.println("retrieved: email");
		user.setContactNumber(rs.getString("contact_number"));
		System.out.println("retrieved: contact_number");
		return user;
	}	
}
