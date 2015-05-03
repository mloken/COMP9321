package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import business.UserLoginFailedException;
import business.support.UserServiceImpl;

public class LoginCommand implements Command {

	private static UserServiceImpl userDao;

	/** Creates a new instance of LoginCommand */
	public LoginCommand() {
		userDao = new UserServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = userDao.login(request.getParameter("username"),
					request.getParameter("password"));
			if (user == null) {
				return "/login.jsp";
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			return "/homepage.jsp";
		} catch (UserLoginFailedException e) {
			e.printStackTrace();
			return "/loginfailed.jsp";
		}
	}
}
