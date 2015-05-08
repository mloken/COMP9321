package business;

import beans.UserBean;

public interface UserService {
	UserBean login(String username, String password) throws UserLoginFailedException;
	
	boolean isUsernameAvailable(String username);
}