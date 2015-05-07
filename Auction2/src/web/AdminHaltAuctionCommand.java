package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AuctionItemBean;
import business.AdminService;
import business.AuctionService;
import business.support.AdminServiceImpl;
import business.support.AuctionServiceImpl;

public class AdminHaltAuctionCommand implements Command {

	private static AdminService adminService;
	private static AuctionService auctionService;
	
	public AdminHaltAuctionCommand(){
		adminService = new AdminServiceImpl();
		auctionService = new AuctionServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		String itemIdToHalt = request.getParameter("itemIdToHalt");
		String itemIdToUnhalt = request.getParameter("itemIdToUnhalt");
		HttpSession session = request.getSession();
		
		if(itemIdToHalt != null){
			adminService.haltAuctionById(itemIdToHalt);
		} else if (itemIdToUnhalt != null){
			adminService.unhaltAuctionById(itemIdToUnhalt);
		}
		ArrayList<AuctionItemBean> allActiveAuctionItems = auctionService.getAllActiveAuctionItems();
		session.setAttribute("allActiveAuctionItems", allActiveAuctionItems);
		
		return "/adminHaltAuction.jsp";
	}

}
