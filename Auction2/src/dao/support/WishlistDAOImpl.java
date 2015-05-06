package dao.support;

import java.util.ArrayList;

import beans.WishlistItemBean;
import common.DBConnectionFactory;
import dao.GenericDAO;
import dao.WishlistDAO;

public class WishlistDAOImpl extends GenericDAO implements WishlistDAO{

	public WishlistDAOImpl() {
		super();
	}

	public WishlistDAOImpl(DBConnectionFactory services) {
		super(services);
	}
	
	public ArrayList<WishlistItemBean> getWishlistFromUserId(int userId){
		return null;
	}
}
