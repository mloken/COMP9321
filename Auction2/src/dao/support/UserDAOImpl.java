package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	@Override
	public ArrayList<UserBean> getAllUsers() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<UserBean> userList = new ArrayList<UserBean>() ;
		try {
			
			con = services.createConnection();
			stmt = con.prepareStatement("SELECT * FROM TBL_USERS");
			rs = stmt.executeQuery();
			while (rs.next())
				userList.add(createUserBean(rs));
			
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			
			if (con != null) {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return userList;
	}
	
	@Override
	public UserBean addNewUser(UserBean user) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("insert into tbl_users (firstname, lastname, nickname, access_level, username, password, email, contact_number, year_of_birth, credit_card, streetAddress, city, state, country, postalCode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getNickname());
			stmt.setInt(4, user.getAccessLevel());
			stmt.setString(5, user.getUsername());
			stmt.setString(6, user.getPassword());
			stmt.setString(7, user.getEmail());
			stmt.setString(8, user.getContactNumber());
			stmt.setString(9, user.getYearOfBirth());
			stmt.setString(10, user.getCreditCard());
			stmt.setString(11, user.getAddress().getStreetAddress());
			stmt.setString(12, user.getAddress().getCity());
			stmt.setString(13, user.getAddress().getState());
			stmt.setString(14, user.getAddress().getCountry());
			stmt.setString(15, user.getAddress().getPostalCode());

			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not insert user row into database");
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return user;
	}	

	@Override
	public boolean banUserById(int uid) {
		Connection con = null;
		boolean success = false;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("UPDATE TBL_USERS SET access_level = ? WHERE uid = ?");
			stmt.setInt(1, 4); //an access_level of 4 corresponds to banned user
			stmt.setInt(2, uid);
			
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not update user row into database");
			else
				success = true;
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return success;
	}
	
	@Override
	public boolean unbanUserById(int uid) {
		Connection con = null;
		boolean success = false;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("UPDATE TBL_USERS SET access_level = ? WHERE uid = ?");
			stmt.setInt(1, 2); //an access_level of 2 corresponds to regular user
			stmt.setInt(2, uid);
			
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not update user row into database");
			else
				success = true;
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return success;
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		Connection con = null;
		ResultSet rs = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM tbl_users WHERE username = ?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()){
				return false;
			}
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return true;
	}	
	
	private UserBean createUserBean(ResultSet rs) throws SQLException {
		UserBean user = new UserBean();
		user.setUid(rs.getInt("uid"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastname"));
		user.setAccessLevel(rs.getInt("access_level"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setContactNumber(rs.getString("contact_number"));
		user.setNickname(rs.getString("nickname"));
		user.setYearOfBirth(rs.getString("year_of_birth"));
		user.setCreditCard(rs.getString("credit_card"));
		AddressBean address = new AddressBean();
		address.setStreetAddress(rs.getString("streetAddress"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setCountry(rs.getString("country"));
		address.setPostalCode(rs.getString("postalCode"));
		user.setAddress(address);
		return user;
	}

	private UserBean getUserById(int uid) {
		Connection con = null;
		ResultSet rs = null;
		UserBean user = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("SELECT * FROM tbl_users WHERE uid = ?");
			stmt.setInt(1, uid);
			rs = stmt.executeQuery();
			 user = createUserBean(rs);
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return user;
	}


	
}
