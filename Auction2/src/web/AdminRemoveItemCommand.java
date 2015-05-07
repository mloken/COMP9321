package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import business.AuctionService;
import business.support.AuctionServiceImpl;

public class AdminRemoveItemCommand implements Command {

	private static AuctionService auctionService;
	
	public AdminRemoveItemCommand(){
		auctionService = new AuctionServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String itemIdToRemove = request.getParameter("itemIdToRemove");
		HttpSession session = request.getSession();
		
		if(itemIdToRemove != null){
			auctionService.deleteItem(itemIdToRemove);
		}
		ArrayList<AuctionItemBean> allAuctionItems = auctionService.getAllAuctionItems();
		session.setAttribute("allAuctionItems", allAuctionItems);
		
		return "/adminRemoveItem.jsp";
	}

}
