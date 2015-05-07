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
		ArrayList<BidBean> bidItems = new ArrayList<>();
		AuctionItemBean auctionItem = null;
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		System.out.println("user_id= "+currentUser.getUid());
		bidItems = bidService.getBidItemsByUser(currentUser.getUid());
//		auctionItems = auctionService.getItemById(wishlistItems);
		
		request.setAttribute("bidlist", bidItems);
		return "/bidlist.jsp";
		
		
	}
}
