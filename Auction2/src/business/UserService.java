package business;

import beans.UserBean;

public interface UserService {
	UserBean login(String username, String password) throws UserLoginFailedException;
	
	boolean isUsernameAvailable(String username);
	
	UserBean editProfile(UserBean user);

	UserBean confirm(String username, String password, String confirmCode)
			throws UserLoginFailedException;
}