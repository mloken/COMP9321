package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AuctionItemBean;
import business.AuctionService;
import business.support.AuctionServiceImpl;

public class HomepageCommand implements Command {
	
	private static AuctionService auctionService;
	
	public HomepageCommand() {
		auctionService = new AuctionServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<AuctionItemBean> randomTenAuctionItems;
		randomTenAuctionItems=auctionService.getTenRandomAuctionItems();
		request.setAttribute("randomTenAuctionItems", randomTenAuctionItems);
		
		return "/homepage.jsp";	
	}

}
