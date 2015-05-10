package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import beans.BidBean;
import beans.UserBean;
import beans.WishlistItemBean;
import business.support.AuctionServiceImpl;
import business.support.BidServiceImpl;
import business.support.WishlistServiceImpl;

public class ShowAuctionListCommand implements Command {

	private static BidServiceImpl bidService;
	private static AuctionServiceImpl auctionService;


	/** Creates a new instance of LoginCommand */
	public ShowAuctionListCommand() {
		bidService = new BidServiceImpl();
		auctionService = new AuctionServiceImpl();

	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AuctionItemBean> openItems = new ArrayList<>();
		ArrayList<AuctionItemBean> closedItems = new ArrayList<>();
		AuctionItemBean auctionItem = null;
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		System.out.println("user_id show= "+currentUser.getUid());
		closedItems = auctionService.getClosedAuctionItemsByOwner(currentUser.getUid(), new Date());
//		auctionItems = auctionService.getItemById(wishlistItems);
		request.setAttribute("from", "sellnotif");
		request.setAttribute("closedItems", closedItems);
		return "/auctionlist.jsp";
		
		
	}
}
