package dao;

import java.util.ArrayList;

import beans.WishlistItemBean;

public interface WishlistDAO {

	ArrayList<WishlistItemBean> getWishlistFromUserId(int userId);
	
}
