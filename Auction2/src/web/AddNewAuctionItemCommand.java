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
import business.AuctionService;
import business.UserLoginFailedException;
import business.support.AuctionServiceImpl;
import business.support.UserServiceImpl;

public class AddNewAuctionItemCommand implements Command {

	private static AuctionService auctionService;

	public AddNewAuctionItemCommand() {
		auctionService = new AuctionServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean currentUser = (UserBean) session.getAttribute("user");
//		if (currentUser == null) {
//			return "/login.jsp";
//		}
		int ownerId = currentUser.getUid();

		boolean success = true;
		String alertmessage = "";

		AuctionItemBean item = new AuctionItemBean();

		// INPUT VALIDATION
		if (request.getParameter("item_name") != null) {
			String itemname = request.getParameter("item_name");
			String category = request.getParameter("category");
			String description = request.getParameter("description");
			String picture = request.getParameter("picture");
			String streetaddr = request.getParameter("streetAddress");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String postcode = request.getParameter("postalCode");
			String resprice = request.getParameter("reservePrice");
			String startbid = request.getParameter("biddingStartPrice");
			String bidinc = request.getParameter("biddingIncrements");
			String endtime = request.getParameter("endTime");
			String notes = request.getParameter("notes");
			boolean valid = true;

			if (itemname.isEmpty()) {
				alertmessage += "Your Title can not be empty<br>";
				valid = false;
			} else {
				valid = valid && true;
			}
			if (category.isEmpty()) {
				alertmessage += "Your Category can not be empty<br>";
				valid = false;
			} else {
				valid = valid && true;
			}
			/*
			 * if (picture.isEmpty()){ alertmessage+=
			 * "Your Picture can not be empty<br>"; valid = false; } else {
			 * valid=valid&&true; }
			 */
			if (streetaddr.isEmpty()) {
				alertmessage += "Please insert your street address<br>";
				valid = false;
			} else {
				valid = valid && true;
			}
			if (city.isEmpty()) {
				alertmessage += "Please insert your city<br>";
				valid = false;
			} else {
				valid = valid && true;
			}
			if (state.isEmpty()) {
				alertmessage += "Please insert your state<br>";
				valid = false;
			} else {
				valid = valid && true;
			}
			if (country.isEmpty()) {
				alertmessage += "Please insert your country<br>";
				valid = false;
			} else {
				valid = valid && true;
			}

			if (startbid.toString().isEmpty()) {
				alertmessage += "Your Bidding Start Price can not be empty<br>";
				valid = false;
			} else {
				if (!startbid.toString().matches("[0-9]{1,8}+\\.?[0-9]*?")) {
					alertmessage += "Your Bidding Start Price is not valid<br>";
					valid = false;
				} else {
					valid = valid && true;
				}
			}

			if (resprice.toString().isEmpty()) {
				alertmessage += "Your Reserve Price can not be empty<br>";
				valid = false;
			} else {
				if (!resprice.toString().matches("[0-9]{1,8}+\\.?[0-9]*?")) {
					alertmessage += "Your Reserve Price is not valid<br>";
					valid = false;
				} else {
					valid = valid && true;
				}
			}

			if (bidinc.toString().isEmpty()) {
				alertmessage += "Your Bidding Increments can not be empty<br>";
				valid = false;
			} else {
				if (!bidinc.toString().matches("[0-9]{1,5}+\\.?[0-9]*?")) {
					alertmessage += "Your Bidding Increments is not valid<br>";
					valid = false;
				} else {
					valid = valid && true;
				}
			}
//			if (endtime.equals("")) {
//				alertmessage += "Your End Time can not be empty<br>";
//				valid = false;
//			} else {
//				if (!endtime
//						.matches("[1-3]{1}+[0-9]{3}+\\-[0-12]{1,2}+\\-[1-31]{1,2}")) {
//					alertmessage += "Your end time is invalid. Please follow the format YYYY-MM-DD<br>";
//					valid = false;
//				} else {
//					valid = valid && true;
//				}
//			}
			if (endtime.isEmpty()){
				/*Sets the time to current time + 10 minutes*/
				long systemTime = System.currentTimeMillis();
				Date closingTime = new Date(systemTime + 10*60*1000);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd-kk:mm");
				endtime = df.format(closingTime);
			}
			
			if (postcode.isEmpty()) {
				alertmessage += "Your Postal Code can not be empty<br>";
				valid = false;
			} else {
				if (!postcode.matches("[0-9]{4,5}+")) {
					alertmessage += "Your Postal Address is not valid<br>";
					valid = false;
				} else {
					valid = valid && true;
				}
			}

			request.setAttribute("valid", valid);

			if (valid) {
				alertmessage = "Congratulation! You have successfully added auction item "
						+ itemname + "!<br>";
				item.setId(UUID.randomUUID().toString());
				item.setOwnerId(ownerId);
				item.setItemName(itemname);
				item.setCategory(category);
				item.setDescription(description);
				item.setPicture(picture);
				AddressBean addr = new AddressBean();
				addr.setStreetAddress(streetaddr);
				addr.setCity(city);
				addr.setState(state);
				addr.setCountry(country);
				addr.setPostalCode(postcode);
				item.setAddress(addr);
				item.setReservePrice(Float.parseFloat(resprice));
				item.setBiddingStartPrice(Float.parseFloat(startbid));
				item.setBiddingIncrements(Float.parseFloat(bidinc));
				item.setCurrentBid(0);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd-kk:mm");
				try {
					item.setEndTime(df.parse(endtime));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					// (user inserted invalid date format)
					e1.printStackTrace();
				}
				item.setNotes(notes);
				item.setStatus(1);
				auctionService.addItem(item);
			} else {
				alertmessage = "Your auction item has not been added, there are some errors in your inputs <br>"
						+ alertmessage;
			}
		}

		request.setAttribute("message", alertmessage);
		request.setAttribute("item", item);
		return "/addAuction.jsp";
	}

}
