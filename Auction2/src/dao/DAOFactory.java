package dao;

import java.util.HashMap;
import java.util.Map;

import dao.support.AuctionDAOImpl;
import dao.support.UserDAOImpl;

public class DAOFactory {

private static final String USER_DAO = "userDAO";
	
	private static final String AUCTION_DAO = "contactDAO";
	
	private Map daos;
	
	private static DAOFactory instance = new DAOFactory();
	
	/** Creates a new instance of DAOFactory */
	private DAOFactory() {
		daos = new HashMap();
		daos.put(USER_DAO, new UserDAOImpl());
		daos.put(AUCTION_DAO, new AuctionDAOImpl());
	}
	
	/**
	 * Finds the user dao
	 * @return
	 */
	public UserDAO getUserDAO() {
		return (UserDAO) daos.get(USER_DAO);
	}

	/**
	 * Retrieves the contacts dao
	 * @return
	 */
	public AuctionDAO getContactDAO() {
		return (AuctionDAO) daos.get(AUCTION_DAO);
	}
	
	public static DAOFactory getInstance() {
		return instance;
	}
	
}
