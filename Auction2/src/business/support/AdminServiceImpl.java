package business.support;

import java.util.ArrayList;

import dao.UserDAO;
import dao.support.UserDAOImpl;
import beans.AuctionItemBean;
import beans.UserBean;
import business.AdminService;

public class AdminServiceImpl implements AdminService{

	private UserDAO userDao;
	
	public AdminServiceImpl(){
		userDao = new UserDAOImpl();
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
