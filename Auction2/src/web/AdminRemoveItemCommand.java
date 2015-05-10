package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import beans.BidBean;
import beans.UserBean;
import beans.WishlistItemBean;
import business.AdminService;
import business.AuctionService;
import business.support.AdminServiceImpl;
import business.support.AuctionServiceImpl;
import business.support.BidServiceImpl;
import business.support.WishlistServiceImpl;

public class AdminRemoveItemCommand implements Command {

	private static AuctionService auctionService;
	private static WishlistServiceImpl wishlistService;
	private static AdminService adminService;
	private static BidServiceImpl bidService;
	
	public AdminRemoveItemCommand(){
		auctionService = new AuctionServiceImpl();
		wishlistService = new WishlistServiceImpl();
		adminService = new AdminServiceImpl();
		bidService = new BidServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String itemIdToRemove = request.getParameter("itemIdToRemove");
		HttpSession session = request.getSession();

		ArrayList<WishlistItemBean> wishlistItems =null;
		ArrayList<BidBean> bidItems =null;
		if(itemIdToRemove != null){
			wishlistItems = wishlistService.getWishlistFromItemId(itemIdToRemove);

			for(WishlistItemBean element:wishlistItems){
				
				wishlistService.deleteWishlistItemById(element.getId());
				
			}
			
			bidItems=bidService.getAllBidItems();
				for(BidBean element:bidItems){
					if(element.getItemId().equalsIgnoreCase(itemIdToRemove)){
						bidService.deleteBidItem(element.getItemId());
					}
				
			
			
				
			}
			auctionService.deleteItem(itemIdToRemove);
		}
		
		

		ArrayList<AuctionItemBean> allAuctionItems = auctionService.getAllAuctionItems();
		session.setAttribute("allAuctionItems", allAuctionItems);
		
		return "/adminRemoveItem.jsp";
	}

}
