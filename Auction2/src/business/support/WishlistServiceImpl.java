package business.support;

import java.util.ArrayList;

import dao.WishlistDAO;
import dao.support.WishlistDAOImpl;
import beans.WishlistItemBean;
import business.WishlistService;

public class WishlistServiceImpl implements WishlistService{
	
	private WishlistDAO wishlistDao;
	
	public WishlistServiceImpl(){
		wishlistDao = new WishlistDAOImpl();
	}
	public ArrayList<WishlistItemBean> getWishlistFromUserId(int userId){
		ArrayList<WishlistItemBean> wishlist = wishlistDao.getWishlistFromUserId(userId);
		return wishlist;
	}
}
