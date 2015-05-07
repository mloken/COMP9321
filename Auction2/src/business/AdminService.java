package business;

import java.util.ArrayList;

import beans.AuctionItemBean;
import beans.UserBean;

public interface AdminService {
	
	UserBean login(String username, String password) throws UserLoginFailedException;
	
	AuctionItemBean haltAuctionById(String id);
	
	AuctionItemBean deleteItemById(String id);
	
	boolean banUserById(int uid);

	boolean unbanUserById(int userId);
	
	ArrayList<UserBean> getAllUsers();

	ArrayList<UserBean> getAllRegularUsers();

}
