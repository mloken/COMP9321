package business.support;

import java.util.ArrayList;

import dao.DataAccessException;
import dao.UserDAO;
import dao.support.UserDAOImpl;
import beans.AuctionItemBean;
import beans.UserBean;
import business.AdminService;
import business.UserLoginFailedException;

public class AdminServiceImpl implements AdminService {

	private UserDAO userDao;

	public AdminServiceImpl() {
		userDao = new UserDAOImpl();
	}

	@Override
	public UserBean login(String username, String password)
			throws UserLoginFailedException {
		UserBean user = null;

		try {
			user = userDao.findByLoginDetails(username, password);
			if (user.getAccessLevel() == 1) {
				return user;
			} else {
				return null;
			}
		} catch (DataAccessException e) {
			throw new UserLoginFailedException("Unable to find user", e);
		}
	}

	@Override
	public AuctionItemBean haltAuctionById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuctionItemBean deleteItemById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean banUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> allUsers = userDao.getAllUsers();
		return allUsers;
	}

}
