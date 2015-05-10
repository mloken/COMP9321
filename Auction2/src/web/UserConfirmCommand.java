package web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AddressBean;
import beans.AuctionItemBean;
import beans.UserBean;
import dao.UserDAO;
import dao.support.UserDAOImpl;
import business.UserLoginFailedException;
import business.support.UserServiceImpl;

public class UserConfirmCommand implements Command {

	private static UserServiceImpl userService;

	/** Creates a new instance of LoginCommand */
	public UserConfirmCommand() {
		userService = new UserServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String confirmCode=(String) request.getAttribute("confirmCode");
		try {
			UserBean user = userService.login(request.getParameter("username"),
					request.getParameter("password"));
			if (user == null) {
				message += "Wrong username and/or password <br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/userConfirm.jsp";
			} else if (user.getAccessLevel() == 3 &&user.getConfirmCode()==confirmCode){
				userService.confirmUserById(user.getUid());
				message += "Authorized! Login and shop!<br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", true);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				return "/userConfirm.jsp";
			}else if (user.getAccessLevel() == 3 &&user.getConfirmCode()!=confirmCode){
				message += "Wrong confirmCode!Please check the url in your email again.";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/userConfirm.jsp";
			} 
			else if (user.getAccessLevel() <=2){
				message += "This account has already been authorized.<br>";
				request.setAttribute("message", message);
				request.setAttribute("valid", false);
				return "/userConfirm.jsp";
			} else {
				message += "Confirm error. Please try again.<br>";
				request.setAttribute("valid", false);
				request.setAttribute("message", message);
								
				//user.sendemail("");
	
				return "/userConfirm.jsp";
			}
		} catch (UserLoginFailedException e) {
			message += "Can't open database <br>";
			return "/confirm user failed.jsp";
		}
	}
		
}
