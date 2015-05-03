package business.support;

import dao.DataAccessException;
import dao.UserDAO;
import dao.support.UserDAOImpl;
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
	
}
