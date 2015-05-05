package business.support;

import dao.DataAccessException;
import dao.UserDAO;
import dao.support.UserDAOImpl;
import beans.AuctionItemBean;
import beans.UserBean;
import business.UserLoginFailedException;
import business.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO userDao;
	
	public UserServiceImpl() {
		userDao= new UserDAOImpl();
	}
	
	@Override
	public UserBean login(String username, String password)
			throws UserLoginFailedException {
		UserBean user = null;
		
		try {
			user = userDao.findByLoginDetails(username, password);
			//System.out.println("User created correctly in UserServiceImpl: + " + user.getFirstName());
			return user;
		} catch (DataAccessException e) {
			throw new UserLoginFailedException("Unable to find user", e);
		}
	}
	
	public UserBean register(UserBean user){
		
		UserBean newUser = userDao.addNewUser(user);
		return newUser;
		
		/*try {
			user = userDao.findByLoginDetails(username, password);
			//System.out.println("User created correctly in UserServiceImpl: + " + user.getFirstName());
			return user;
		} catch (DataAccessException e) {
			throw new UserLoginFailedException("Unable to find user", e);
		}*/
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		boolean isAvailable = userDao.isUsernameAvailable(username);
		return isAvailable;
	}
	
}
