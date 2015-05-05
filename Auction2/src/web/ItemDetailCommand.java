package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import business.support.AuctionServiceImpl;

public class ItemDetailCommand implements Command {

	private static AuctionServiceImpl auctionService;

	/** Creates a new instance */
	public ItemDetailCommand() {
		auctionService = new AuctionServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AuctionItemBean auctionItem = null;
		String id = request.getParameter("id");
		
		auctionItem = auctionService.getItemById(id);
		if (auctionItem == null) {
			System.out.println("searchKey == null");
			
			return "/searchResults.jsp";
		}
		else{
			request.setAttribute("auctionItem", auctionItem);
			return "/itemDetail.jsp";
		}
//		return searchKey;
		
	}
}
