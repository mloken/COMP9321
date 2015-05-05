package business;

import java.util.ArrayList;

import beans.AuctionItemBean;
import beans.UserBean;

public interface AdminService {
	
	UserBean login(String username, String password) throws UserLoginFailedException;
	
	AuctionItemBean haltAuctionById(String id);
	
	AuctionItemBean deleteItemById(String id);
	
	UserBean banUserById(int uid);
	
	ArrayList<UserBean> getAllUsers();

}
