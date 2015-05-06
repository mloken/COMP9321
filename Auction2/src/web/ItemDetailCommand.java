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
import business.support.AuctionServiceImpl;
import business.support.BidServiceImpl;

public class ItemDetailCommand implements Command {

	private static AuctionServiceImpl auctionService;
	private static BidServiceImpl bidService;
	/** Creates a new instance */
	public ItemDetailCommand() {
		auctionService = new AuctionServiceImpl();
		bidService = new BidServiceImpl();

	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AuctionItemBean auctionItem = null;
		String id = request.getParameter("id");
		BidBean bidItem = null;

		auctionItem = auctionService.getItemById(id);
		bidItem = bidService.getBidItemById(id);

		if (auctionItem == null) {
			System.out.println("searchKey == null");
			
			return "/searchResults.jsp";
		}
		else{
			if (bidItem == null){
				request.setAttribute("currentprice", auctionItem.getBiddingStartPrice());
			}
			else {
				request.setAttribute("currentprice", bidItem.getPrice());
			}

			request.setAttribute("auctionItem", auctionItem);
			return "/itemDetail.jsp";
		}
//		return searchKey;
		
	}
}
