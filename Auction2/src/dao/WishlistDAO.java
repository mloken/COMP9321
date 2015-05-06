package dao;

import java.util.ArrayList;

import javax.swing.Spring;

import beans.AuctionItemBean;
import beans.WishlistItemBean;

public interface WishlistDAO {

	ArrayList<WishlistItemBean> getWishlistFromUserId(int userId);

	String addToWishlist(String itemId,int userId);
	
	WishlistItemBean deleteWishlistItemById(int id);
	
	WishlistItemBean deleteWishlistItemByItemAndUser(String itemId,int userId);
}
