package business;

import java.util.ArrayList;

import beans.WishlistItemBean;

public interface WishlistService {

	ArrayList<WishlistItemBean> getWishlistFromUserId(int userId);
	
}
