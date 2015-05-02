package dao;

import beans.UserBean;

public interface UserDAO {

	UserBean findByLoginDetails(String username, String password) throws DataAccessException;
}
