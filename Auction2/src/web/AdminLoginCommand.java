package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import business.AdminService;
import business.UserLoginFailedException;
import business.support.AdminServiceImpl;
import business.support.UserServiceImpl;

public class AdminLoginCommand implements Command {

	private static AdminService adminService;

	/** Creates a new instance of LoginCommand */
	public AdminLoginCommand() {
		adminService = new AdminServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = adminService.login(request.getParameter("username"),
					request.getParameter("password"));
			if (user == null) {
				System.out.println("user = null, i.e. not admin");
				return "/adminLogin.jsp";
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			return "/adminMenu.jsp";
		} catch (UserLoginFailedException e) {
			e.printStackTrace();
			return "/loginfailed.jsp";
		}
	}
}
