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
		request.setAttribute("searchKey", searchKey);
		auctionItems = auctionService.getItemBySearchKey(searchKey);
		if (auctionItems == null) {
			System.out.println("searchKey == null");
//			RequestDispatcher rd = request.getRequestDispatcher("/homepage.jsp");
//			rd.forward(request, response);
			return "/homepage.jsp";
		}
		else{
			request.setAttribute("auctionItems", auctionItems);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/searchResults.jsp");
//			rd.forward(request, response);
			return "/searchResults.jsp";
		}
//		return searchKey;
		
	}
}
