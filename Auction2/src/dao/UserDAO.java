package dao;

import java.util.ArrayList;

import beans.AuctionItemBean;
import beans.UserBean;

public interface UserDAO {

	UserBean findByLoginDetails(String username, String password) throws DataAccessException;
	
	ArrayList<UserBean> getAllUsers();
	
	UserBean addNewUser(UserBean user);
	
	boolean banUserById(int uid);
	
	boolean isUsernameAvailable(String username);

	boolean unbanUserById(int uid);

	UserBean editUser(UserBean user);
}
