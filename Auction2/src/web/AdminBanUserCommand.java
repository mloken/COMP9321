package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import business.AdminService;
import business.support.AdminServiceImpl;

public class AdminBanUserCommand implements Command {

	private static AdminService adminService;

	/** Creates a new instance of LoginCommand */
	public AdminBanUserCommand() {
		adminService = new AdminServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<UserBean> allUsers = adminService.getAllUsers();
		HttpSession session = request.getSession();
		session.setAttribute("allUsers", allUsers);
		
		return "/adminBanUser.jsp";
	}

}
