package dao.support;

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
		// TODO Auto-generated method stub
		return null;
	}

}
