package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import beans.UserBean;
import beans.WishlistItemBean;
import business.support.WishlistServiceImpl;

public class ShowWishListCommand implements Command {

	private static WishlistServiceImpl wishlistService;

	/** Creates a new instance of LoginCommand */
	public ShowWishListCommand() {
		wishlistService = new WishlistServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<WishlistItemBean> wishlistItems = null;
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		System.out.println("user_id= "+currentUser.getUid());
		wishlistItems = wishlistService.getWishlistFromUserId(currentUser.getUid());
		request.setAttribute("wishlistItems", wishlistItems);
		return "/wishlist.jsp";
		
		
	}
}
