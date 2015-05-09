package business.support;

import java.util.ArrayList;

import dao.AuctionItemDAO;
import dao.DataAccessException;
import dao.UserDAO;
import dao.WishlistDAO;
import dao.support.AuctionItemDAOImpl;
import dao.support.UserDAOImpl;
import beans.AuctionItemBean;
import beans.UserBean;
import beans.WishlistItemBean;
import business.AdminService;
import business.UserLoginFailedException;

public class AdminServiceImpl implements AdminService {

	private UserDAO userDao;
	private AuctionItemDAO auctionItemDao;
	private WishlistDAO wishlistDao;

	public AdminServiceImpl() {
		userDao = new UserDAOImpl();
		auctionItemDao = new AuctionItemDAOImpl();
	}

	@Override
	public UserBean login(String username, String password)
			throws UserLoginFailedException {
		UserBean user = null;

		try {
			user = userDao.findByLoginDetails(username, password);
			if (user != null && user.getAccessLevel() == 1) {
				return user;
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			throw new UserLoginFailedException("Unable to find user", e);
		}
	}

	@Override
	public boolean haltAuctionById(String id) {
		boolean success = auctionItemDao.haltAuctionItemById(id);
		return success;
	}
	
	@Override
	public boolean unhaltAuctionById(String id) {
		boolean success = auctionItemDao.unhaltAuctionItemById(id);
		return success;
	}

	@Override
	public AuctionItemBean deleteItemById(String id) {
		AuctionItemBean deletedAuction = auctionItemDao.deleteAuctionItemById(id);
		return deletedAuction;
	}

	@Override
	public boolean banUserById(int uid) {
		boolean success = userDao.banUserById(uid);
		return success;
	}

	@Override
	public boolean unbanUserById(int uid) {
		boolean success = userDao.unbanUserById(uid);
		return success;
	}
	
	@Override
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> allUsers = userDao.getAllUsers();
		return allUsers;
	}

	@Override
	public ArrayList<WishlistItemBean> getAllWishlists() {
		ArrayList<WishlistItemBean> allWishlists = wishlistDao.getAllWishlists();
		return allWishlists;
	}
	
	@Override
	public ArrayList<UserBean> getAllRegularUsers() {
		ArrayList<UserBean> allUsers = userDao.getAllUsers();
		ArrayList<UserBean> regUsers = new ArrayList<UserBean>();
		UserBean user;
//		for(int i = 0; i < allUsers.size(); i++){
//			int accessLvl = allUsers.get(i).getAccessLevel();
//			if(accessLvl == 2 || accessLvl == 4)
//				regUsers.add(allUsers.get(i));
//		}
		
		for(UserBean element: allUsers){
			if(element.getAccessLevel()==2 || element.getAccessLevel()==4){
				regUsers.add(element);
			}
		}
		return regUsers;
	}
}
