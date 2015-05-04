package dao;

import beans.AuctionItemBean;
import beans.UserBean;

public interface UserDAO {

	UserBean findByLoginDetails(String username, String password) throws DataAccessException;
	
	UserBean addNewUser(UserBean user);
}
