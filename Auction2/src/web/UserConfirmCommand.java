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
		HttpSession session = request.getSession();
		boolean success = true; //change the default to false after implementing input validation
		String message = "";
//		UserBean newuser = new UserBean();
		UserDAO userDao = new UserDAOImpl();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		
		/*
		 * Input Validation Here.
		 * Add each error message to the 'message' ArrayList to be shown in registration.jsp
		 */
		
		if (currentUser.getUsername()!=null){
			String firstname = request.getParameter("NewFirstName");
			String lastname = request.getParameter("NewLastName");
			String nickname = request.getParameter("NewNickname");
			String email = request.getParameter("NewEmail");
			String password = request.getParameter("NewPassword");
			String number = request.getParameter("NewNumber");
			String yearOfBirth = request.getParameter("NewYearOfBirth");
			String creditCard = request.getParameter("NewCreditCard");
			String streetAddress = request.getParameter("NewStreetAddress");
			String city = request.getParameter("NewCity");
			String state = request.getParameter("NewState");
			String country = request.getParameter("NewCountry");
			String postalCode = request.getParameter("NewPostalCode");
			boolean valid = true;
			
			
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
			
			if(nickname==""){
                message+="Please fill in your nickname<br>";
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
                number="";
                valid = false;
	        } else {
	        valid = valid&&true;
	        }
			
			if(yearOfBirth==""){
                message+="Your year of birth can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(creditCard==""){
                message+="Your credit card can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(streetAddress==""){
                message+="Your street address can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(city==""){
                message+="Your city can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(state==""){
                message+="Your state can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(country==""){
                message+="Your country can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if(postalCode==""){
                message+="Your postal code can not be empty!<br>";
                valid = false;
	        } else {
	                valid = valid&&true;
	        }
			
			if (valid){
				//newuser.setUid(Integer.parseInt(UUID.randomUUID().toString()));
				currentUser.setFirstName(firstname);
				currentUser.setLastName(lastname);
				currentUser.setNickname(nickname);
				currentUser.setEmail(email);
				currentUser.setPassword(password);
				currentUser.setContactNumber(number);
				currentUser.setYearOfBirth(yearOfBirth);
				currentUser.setCreditCard(creditCard);
				AddressBean addr = new AddressBean();
				addr.setStreetAddress(streetAddress);
				addr.setCity(city);
				addr.setState(state);
				addr.setCountry(country);
				addr.setPostalCode(postalCode);
				currentUser.setAddress(addr);
				currentUser.setAccessLevel(2);
				userService.editProfile(currentUser);
				message+="Congratulation! You have successfully edited your profile";
				request.setAttribute("valid", true);
				
			}
			else {
				message = "Edited failed, there are some errors in your inputs <br>"+message;
				request.setAttribute("valid", false);
			}
		}
		
		request.setAttribute("from", "editProfile");
		request.setAttribute("currentUser", currentUser);
		request.setAttribute("message", message);
		return "/login.jsp";
	}
}
