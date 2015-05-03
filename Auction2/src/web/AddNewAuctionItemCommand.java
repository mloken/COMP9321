package web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AddressBean;
import beans.AuctionItemBean;
import beans.UserBean;
import business.UserLoginFailedException;
import business.support.AuctionServiceImpl;
import business.support.UserServiceImpl;

public class AddNewAuctionItemCommand implements Command {

	private static AuctionServiceImpl auctionService;
	
	public AddNewAuctionItemCommand() {
		auctionService = new AuctionServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		UserBean currentUser = (UserBean) session.getAttribute("user");
//		if (currentUser == null) {
//			return "/login.jsp";
//		}
//		String ownerId = currentUser.getId();
		AuctionItemBean item = new AuctionItemBean();
		item.setId(UUID.randomUUID().toString());
		item.setOwnerId(5);
//		item.setOwnerId(ownerId);
		item.setCategory(request.getParameter("category"));
		item.setItemName(request.getParameter("item_name"));
		item.setCategory(request.getParameter("category"));
		item.setDescription(request.getParameter("description"));
		item.setPicture(request.getParameter("picture"));
		AddressBean addr = new AddressBean();
		addr.setStreetAddress(request.getParameter("streetAddress"));
		addr.setCity(request.getParameter("city"));
		addr.setState(request.getParameter("state"));
		addr.setCountry(request.getParameter("country"));
		addr.setPostalCode(request.getParameter("postalCode"));
		item.setAddress(addr);
		item.setReservePrice(Float.parseFloat(request.getParameter("reservePrice")));
		item.setBiddingStartPrice(Float.parseFloat(request.getParameter("biddingStartPrice")));
		item.setBiddingIncrements(Float.parseFloat(request.getParameter("biddingIncrements")));
		item.setCurrentBid(0);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd-kk:mm");
		try {
			item.setEndTime(df.parse(request.getParameter("endTime")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			// (user inserted invalid date format)
			e1.printStackTrace();
		}
		item.setNotes(request.getParameter("notes"));
		
		auctionService.addItem(item);
		request.setAttribute("item", item);
		return "auctionAdded.jsp";
	}

}
