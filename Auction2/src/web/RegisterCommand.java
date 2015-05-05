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
		String message = "";
		UserBean newuser = new UserBean();
		UserDAO userDao = new UserDAOImpl();
		
		/*
		 * Input Validation Here.
		 * Add each error message to the 'message' ArrayList to be shown in registration.jsp
		 */
		
		if (request.getParameter("NewUserName")!=null){
			String firstname = request.getParameter("NewFirstName");
			String lastname = request.getParameter("NewLastName");
			String username = request.getParameter("NewUserName");
			String email = request.getParameter("NewEmail");
			String password = request.getParameter("NewPassword");
			String number = request.getParameter("NewNumber");
			boolean valid = true;
			
			if(!userService.isUsernameAvailable(username)){
				message+="Username has been taken. Create new username</br>";
				username="";
				valid = false;
			} else if (!username.matches("^[^\\d][a-zA-Z0-9._-]{6,25}")){
                message+= "Your username must be between 6-25 characters!\n";
                username="";
                valid = false;
			} else {
				valid = valid&&true;
			}
			
			if(firstname==""){
                message+="Please fill your first name<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(lastname==""){
                message+="Please fill your last name<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(password==""){
                message+="Your password can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(email==""){
                message+="Your email can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(!email.matches(".+@.+\\.[a-z]{2,6}+")){
                message+="Your email is not valid!<br>";
                email="";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if (!number.matches("[0-9]{6,15}+")){
                message+= "Your contact number is not valid!\n";
                username="";
                valid = false;
	        } else {
	        valid = valid&&true;
	        }
			
			if (valid){
				//newuser.setUid(Integer.parseInt(UUID.randomUUID().toString()));
				newuser.setFirstName(firstname);
				newuser.setLastName(lastname);
				newuser.setUsername(username);
				newuser.setEmail(email);
				newuser.setPassword(password);
				newuser.setContactNumber(number);
				newuser.setAccessLevel(2);
				userService.register(newuser);
				message+="Congratulation! You have been successfully registered";
				request.setAttribute("valid", true);
				
			}
			else {
				message = "You have not been registered, there are some errors in your inputs <br>"+message;
				request.setAttribute("valid", false);
			}
		}
		
		request.setAttribute("from", "registration");
		request.setAttribute("newuser", newuser);
		request.setAttribute("message", message);
		return "/registration.jsp";
	}
}
