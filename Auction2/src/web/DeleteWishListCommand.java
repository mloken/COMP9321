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

public class DeleteWishListCommand implements Command {

	private static WishlistServiceImpl wishlistService;

	/** Creates a new instance  */
	public DeleteWishListCommand() {
		wishlistService = new WishlistServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		String itemId = request.getParameter("id");
		
		WishlistItemBean wishlistItem;
		
		wishlistItem = wishlistService.deleteWishlistItemByItemAndUser(itemId,currentUser.getUid());

		
		RequestDispatcher rd = request.getRequestDispatcher("/dispatcher?operation=showWishList");
		rd.forward(request, response);
		return request.getParameter("id");
	}
}
