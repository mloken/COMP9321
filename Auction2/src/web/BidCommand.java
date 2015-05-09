package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BidBean;
import beans.UserBean;
import business.support.BidServiceImpl;
import beans.AuctionItemBean;
import business.support.AuctionServiceImpl;

public class BidCommand implements Command {

	private static BidServiceImpl bidService;
	private static AuctionServiceImpl auctionService;

	/** Creates a new instance */
	public BidCommand() {
		bidService = new BidServiceImpl();
		auctionService = new AuctionServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BidBean bidItem = null;
		AuctionItemBean item = null;
		
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
		
		if (currentUser == null) {
			System.out.println("user = null, not login");
			return "/login.jsp";
		}
		
		int userid = currentUser.getUid();//Integer.parseInt(request.getParameter("uid"));
		String item_id = request.getParameter("iid");
		
		System.out.println("user ID : "+request.getParameter("uid"));
		System.out.println("item id : "+item_id);
		
		bidItem = bidService.getWinBidItemById(item_id);
		item = auctionService.getItemById(item_id);
		Float inc = item.getBiddingIncrements();
		Float reserveprice = item.getReservePrice();
		Float startprice = item.getBiddingStartPrice();
		Float bidprice = Float.parseFloat(request.getParameter("bidPrice"));
		boolean win = false;
		
		boolean resetBid = false; //set this to true if you want to reset Bid List --> debugging purpose
		if (resetBid){
			bidService.deleteAllBidItems();
			resetBid = false;
		}
		
		if (bidprice > reserveprice){//win because bid price is higher than reserve price
			System.out.println(userid + " win item "+item_id);
			//Remove item from auctionlist & auction table
			session.setAttribute("winsomething", true);
			bidService.updateBidStatusFrom2(item.getId(), 1);
			auctionService.updateBidPrice(item, bidprice);
			auctionService.updatePriceToZero(item);
			win = true;
		}
		
		if (bidItem == null) {//the item hasn't been bid by other users
			if ((bidprice - startprice) < 0){ //user put bid price less than bidding start price
				System.out.println("lower bid price");
				request.setAttribute("valid", false);
				request.setAttribute("message", "Please put bid price higher than start price<br>");
				request.setAttribute("auctionItem", item);
				request.setAttribute("currentprice", startprice);
				return "/itemDetail.jsp";
			}
		}
		else{
			if ((bidprice - bidItem.getPrice()) < inc){ //user put bid price with increment lower than minimum increment from current price
				System.out.println("less than increment");
				request.setAttribute("valid", false);
				request.setAttribute("message", "Please put bid price higher than bidding increment value from current price<br>");
				request.setAttribute("currentprice", bidItem.getPrice());
				request.setAttribute("auctionItem", item);
				return "/itemDetail.jsp";
			}
			System.out.println("notify user id : "+bidItem.getBidderId()+" that he/she lost the bidding of item "+bidItem.getItemId());
			//bidService.updateBid(item_id, userid, Float.parseFloat(request.getParameter("bidPrice")), new Date());
			auctionService.updateBidPrice(item, bidprice);
			bidService.updateBidStatus(item_id, 0);
		}
		
		bidItem = new BidBean();
		bidItem.setItemId(item_id);
		bidItem.setBidderId(userid);
		bidItem.setPrice(bidprice);
		bidItem.setDate(new Date());
		bidItem.setStatus(2);
		bidService.addBidItem(bidItem);
		auctionService.updateBidPrice(item, bidprice);
		System.out.println("Successfully bid "+item_id+" with price : "+bidItem.getPrice());
		
		request.setAttribute("bidItem", bidItem);
		ArrayList<BidBean> bidlist = bidService.getAllWinBidItems();
		request.setAttribute("bidlist", bidlist);
		request.setAttribute("valid", true);
		request.setAttribute("win", win);
		return "/bidSuccess.jsp";
		
//		return searchKey;
		
	}
}
