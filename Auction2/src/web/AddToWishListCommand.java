package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import beans.UserBean;
import beans.WishlistItemBean;
import business.support.WishlistServiceImpl;

public class AddToWishListCommand implements Command {

	private static WishlistServiceImpl wishlistService;

	/** Creates a new instance  */
	public AddToWishListCommand() {
		wishlistService = new WishlistServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchKey = request.getParameter("searchKey");
		request.setAttribute("searchKey", searchKey);
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		String itemId = request.getParameter("itemId");
		int userId = currentUser.getUid();
		String wishlistItems;
		
		wishlistItems = wishlistService.addToWishlist(itemId,userId);

//		RequestDispatcher rd = request.getRequestDispatcher("/dispatcher?operation=search");
//		rd.forward(request, response);
		return "search";
	}
}
