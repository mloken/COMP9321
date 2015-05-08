package web;

import java.io.IOException;
import java.util.ArrayList;

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

public class ShowBidListCommand implements Command {

	private static BidServiceImpl bidService;
	private static AuctionServiceImpl auctionService;


	/** Creates a new instance of LoginCommand */
	public ShowBidListCommand() {
		bidService = new BidServiceImpl();
		auctionService = new AuctionServiceImpl();

	}

	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BidBean> winbidItems = new ArrayList<>();
		ArrayList<BidBean> lostbidItems = new ArrayList<>();
		AuctionItemBean auctionItem = null;
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		System.out.println("user_id= "+currentUser.getUid());
		winbidItems = bidService.getBidItemsByUserAndStatus(currentUser.getUid(), 1);
		lostbidItems = bidService.getBidItemsByUserAndStatus(currentUser.getUid(), 0);
//		auctionItems = auctionService.getItemById(wishlistItems);
		
		request.setAttribute("winbidlist", winbidItems);
		request.setAttribute("lostbidlist", lostbidItems);
		return "/bidlist.jsp";
		
		
	}
}
