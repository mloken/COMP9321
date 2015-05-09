package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import beans.UserBean;
import beans.WishlistItemBean;
import business.AdminService;
import business.AuctionService;
import business.support.AdminServiceImpl;
import business.support.AuctionServiceImpl;
import business.support.WishlistServiceImpl;

public class AdminRemoveItemCommand implements Command {

	private static AuctionService auctionService;
	private static WishlistServiceImpl wishlistService;
	private static AdminService adminService;
	
	public AdminRemoveItemCommand(){
		auctionService = new AuctionServiceImpl();
		wishlistService = new WishlistServiceImpl();
		adminService = new AdminServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String itemIdToRemove = request.getParameter("itemIdToRemove");
		HttpSession session = request.getSession();
//		WishlistItemBean wishlistItem;
//		ArrayList<UserBean> allUsers = adminService.getAllUsers();
		ArrayList<WishlistItemBean> wishlistItems =null;
		if(itemIdToRemove != null){
			
			wishlistItems =adminService.getAllWishlists();
			for(WishlistItemBean element:wishlistItems){
				if(element.getItemId()==itemIdToRemove){
					wishlistService.deleteWishlistItemById(element.getId());
				}
			}
			auctionService.deleteItem(itemIdToRemove);
		}
		
		

//		wishlistItems = wishlistService.getWishlistFromUserId(currentUser.getUid());
//		wishlistService.deleteWishlistItemByItemId(itemIdToRemove)
////		if(wishlistService.deleteWishlistItemByItemId(itemIdToRemove)){
//			System.out.println("delete items that also in wishlist");
//		}
		
		ArrayList<AuctionItemBean> allAuctionItems = auctionService.getAllAuctionItems();
		session.setAttribute("allAuctionItems", allAuctionItems);
		
		return "/adminRemoveItem.jsp";
	}

}
