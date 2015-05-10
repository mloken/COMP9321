package web;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AuctionItemBean;
import beans.UserBean;
import business.UserService;
import business.support.UserServiceImpl;

public class SendBidOwnerCommand implements Command{
	
	private static UserService userService;

	/** Creates a new instance of LoginCommand */
	public SendBidOwnerCommand() {
		userService = new UserServiceImpl();
	}
	
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	  UserBean user=(UserBean) request.getAttribute("newuser");
	  String userEmail=user.getEmail();	
	  AuctionItemBean item=(AuctionItemBean) request.getAttribute("item");
	  
	  String host = "smtp.gmail.com";
	  int port = 587;
	  final String username = "auctiontime.roo@gmail.com";
	  final String password = "AdminRoo";//your password
	
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.smtp.starttls.enable", "true");
	  props.put("mail.smtp.port", port);
	  Session session = Session.getInstance(props, new Authenticator() {
	   protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(username, password);
	   }
	  });
	
	  try {
	
	   Message message = new MimeMessage(session);
	   message.setFrom(new InternetAddress("auctiontime.roo@gmail.com"));
	   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
	   message.setSubject("Auction Time :Auction Owner Reminder");
	   message.setText("Dear "+user.getNickname()+",\n Welcome to Auction Time!\n\nYour auction item :"+item.getItemName()+" has been won by others.\nPlease check into your account to agree or reject the bid.\n"+" \nAuction Time: http://localhost:8080/Auction2/");
	
	   Transport transport = session.getTransport("smtp");
	   transport.connect(host, port, username, password);
	
	   Transport.send(message);
	
	   System.out.println("Email is sent.");
	
	  } catch (MessagingException e) {
	   throw new RuntimeException(e);
	  }
	  request.setAttribute("valid", true);
	  request.setAttribute("from", "registration");
	  request.setAttribute("newuser", user);
	  request.setAttribute("message", request.getAttribute("message"));
	  return "/registration.jsp";
	 }
}