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
import business.support.AuctionServiceImpl;
import business.support.WishlistServiceImpl;

public class ShowWishListCommand implements Command {

	private static WishlistServiceImpl wishlistService;
	private static AuctionServiceImpl auctionService;


	/** Creates a new instance of LoginCommand */
	public ShowWishListCommand() {
		wishlistService = new WishlistServiceImpl();
		auctionService = new AuctionServiceImpl();

	}

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<WishlistItemBean> wishlistItems = null;
		ArrayList<AuctionItemBean> auctionItems = new ArrayList<AuctionItemBean>();
//		WishlistItemBean wishlistItem = null;
		AuctionItemBean auctionItem = null;
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		System.out.println("user_id= "+currentUser.getUid());
		wishlistItems = wishlistService.getWishlistFromUserId(currentUser.getUid());
//		auctionItems = auctionService.getItemById(wishlistItems);
		for(WishlistItemBean element : wishlistItems) {
			auctionItem=auctionService.getItemById(element.getItemId());
			auctionItems.add(auctionItem);	
	    }
		
		request.setAttribute("auctionItems", auctionItems);
		return "/wishlist.jsp";
		
		
	}
}
