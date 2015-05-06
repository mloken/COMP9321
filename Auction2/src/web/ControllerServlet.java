package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private Map<String, Command> commands;

	/**
	 * Initializes the servlet.
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		commands = new HashMap<String, Command>();
		// commands.put("add", new AddCommand());
		// commands.put("delete", new DeleteCommand());
		// commands.put("list", new ListCommand());
		commands.put("addNewAuctionItem", new AddNewAuctionItemCommand());
		commands.put("login", new LoginCommand());
		commands.put("adminLogin", new AdminLoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("register", new RegisterCommand());
		commands.put("PAGE_NOT_FOUND", new ErrorCommand());
		commands.put("search", new SearchCommand());
		commands.put("itemDetail", new ItemDetailCommand());
		commands.put("showWishList", new ShowWishListCommand());
		commands.put("addToWishList", new AddToWishListCommand());
		commands.put("deleteWishList", new DeleteWishListCommand());
		commands.put("bid", new BidCommand());

//		commands.put("userProfile", new UserProfileCommand());
		
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Command cmd = resolveCommand(request);
		String next = cmd.execute(request, response);
		/*
		 * Checks if next contains a '.', if not then next is a new command
		 * could use while instead of if, but beware of infinite loops
		 */
		if (next.indexOf('.') < 0) {
			cmd = (Command) commands.get(next);
			next = cmd.execute(request, response);
		}
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(next);
		dispatcher.forward(request, response);
	}

	private Command resolveCommand(HttpServletRequest request) {
		Command cmd = (Command) commands.get(request.getParameter("operation"));
		if (cmd == null) {
			cmd = (Command) commands.get("PAGE_NOT_FOUND");
		}
		return cmd;
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 */
	public String getServletInfo() {
		return "This servlet implements a command pattern for an auction application";
	}

}
