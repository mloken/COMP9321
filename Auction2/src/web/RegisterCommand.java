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
import business.UserLoginFailedException;
import business.support.UserServiceImpl;

public class RegisterCommand implements Command {

	private static UserServiceImpl userService;

	/** Creates a new instance of LoginCommand */
	public RegisterCommand() {
		userService = new UserServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		boolean success = true; //change the default to false after implementing input validation
		ArrayList<String> message = new ArrayList<String>();
		
		UserBean newuser = new UserBean();
		newuser.setUid(Integer.parseInt(UUID.randomUUID().toString()));
		newuser.setFirstName(request.getParameter("NewFirstName"));
		newuser.setLastName(request.getParameter("NewLastName"));
		newuser.setUsername(request.getParameter("NewUserName"));
		newuser.setEmail(request.getParameter("NewEmail"));
		newuser.setPassword(request.getParameter("NewEmail"));
		newuser.setContactNumber(request.getParameter("NewNumber"));
		newuser.setAccessLevel(2);
		
		/*
		 * Input Validation Here.
		 * Add each error message to the 'message' ArrayList to be shown in registration.jsp
		 */
		
		if (success){
			message.add("Congratulation! You have been successfully registered");
		}
		
		userService.register(newuser);
		request.setAttribute("newuser", newuser);
		request.setAttribute("message", message);
		return "/registration.jsp";
	}
}
