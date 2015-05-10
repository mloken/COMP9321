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

public class SearchCommand implements Command {

	private static AuctionServiceImpl auctionService;

	/** Creates a new instance of LoginCommand */
	public SearchCommand() {
		auctionService = new AuctionServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AuctionItemBean> auctionItems = null;
		String searchKey = request.getParameter("searchKey");
		String category = request.getParameter("category");
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		String message =request.getParameter("message");
		request.setAttribute("valid", request.getAttribute("valid"));
		System.out.println("message"+message);
		
		if (minPrice==""){minPrice = "0";}
		if (maxPrice==""){maxPrice = "1000000";}
		if (category==""){category = "";}
		
		//
		if (request.getParameter("search")!=null){
			auctionItems = auctionService.getItemBySearchKey(searchKey);
		}
		else {
			auctionItems = auctionService.getItemBySearchKeyAdv(searchKey, category, Float.parseFloat(minPrice), Float.parseFloat(maxPrice));
		}
		if (auctionItems == null) {
			System.out.println("searchKey == null");
			/**BTW: for this to work  "|| auctionItems.size()==0" has to be included in the if,
			however, this if is not needed since empty auctionItems is handled in searchResults.jsp**/
//			RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
//			rd.forward(request, response);
			return "/homepage.jsp";
		}
		else{
			request.setAttribute("auctionItems", auctionItems);
			
			request.setAttribute("searchKey", searchKey);
			
//			if (request.getParameter("message")!=null){
//				request.setAttribute("valid", true);
//			}
//			RequestDispatcher rd = request.getRequestDispatcher("/searchResults.jsp");
//			rd.forward(request, response);
			return "/searchResults.jsp";
		}
//		return searchKey;
		
	}
}
