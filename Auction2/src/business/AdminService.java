package business;

import beans.AuctionItemBean;
import beans.UserBean;

public interface AdminService {
	AuctionItemBean haltAuctionById(String id);
	AuctionItemBean deleteItemById(String id);
	UserBean banUserById(int id);
}
