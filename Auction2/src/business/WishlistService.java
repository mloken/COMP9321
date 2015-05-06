package business;

import java.util.ArrayList;

import beans.AuctionItemBean;
import beans.WishlistItemBean;

public interface WishlistService {

	ArrayList<WishlistItemBean> getWishlistFromUserId(int userId);
	
	WishlistItemBean addToWishlist(WishlistItemBean item);
	
	WishlistItemBean deleteWishlistItemById(int id);
	
}
