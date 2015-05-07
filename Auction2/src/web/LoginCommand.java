package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import business.UserLoginFailedException;
import business.UserService;
import business.support.UserServiceImpl;

public class LoginCommand implements Command {

	private static UserService userService;

	/** Creates a new instance of LoginCommand */
	public LoginCommand() {
		userService = new UserServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		try {
			UserBean user = userService.login(request.getParameter("username"),
					request.getParameter("password"));
			if (user == null) {
				message += "Wrong username and/or password <br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/login.jsp";
			} else if (user.getAccessLevel() == 3){
				message += "You have not authorized your user yet <br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/login.jsp";
			} else if (user.getAccessLevel() == 4){
				message += "Your user has been banned <br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/login.jsp";
			} else {				
				request.setAttribute("valid", true);
				request.setAttribute("message", message);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				return "homepage";
			}
		} catch (UserLoginFailedException e) {
			message += "Can't open database <br>";
			return "/loginfailed.jsp";
		}
	}
}
