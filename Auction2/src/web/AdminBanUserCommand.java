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

		String userIdToBan = request.getParameter("userIdToBan");
		String userIdToUnban = request.getParameter("userIdToUnban");
		HttpSession session = request.getSession();

		/* First if is if Ban-button is pressed */
		if (userIdToBan != null) {
			System.out.println("userIdToBan exists!");
			int userId = Integer.parseInt(userIdToBan);
			boolean success = adminService.banUserById(userId);
			if (success) {
				System.out.println(userIdToBan + " was banned");
			} else {
				System.out.println("Ban was not succcessful");
			}
			/* else if is if Unban-button is pressed */
		} else if (userIdToUnban != null) {
			System.out.println("userIdToUnban exists!");
			int userId = Integer.parseInt(userIdToUnban);
			boolean success = adminService.unbanUserById(userId);
			if (success) {
				System.out.println(userIdToBan + " was unbanned");
			} else {
				System.out.println("Unban was not succcessful");
			}
		}
		ArrayList<UserBean> allRegularUsers = adminService.getAllRegularUsers();
		session.setAttribute("allUsers", allRegularUsers);

		return "/adminBanUser.jsp";
	}

}
