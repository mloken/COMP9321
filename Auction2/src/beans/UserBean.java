package beans;


import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.swing.JOptionPane;
import com.sun.glass.ui.Window;
import com.sun.java.swing.plaf.windows.resources.windows;

public class UserBean {
	private int uid;
	private String firstName;
	private String lastName;
	private String nickname;
	private int accessLevel;
	private String username;
	private String password;
	private String email;
	private String contactNumber;
	private String yearOfBirth;
	private AddressBean address;
	private String creditCard;
	private boolean isOnline;
	public UserBean(){
		super();
	}
	public String getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	public void notify(AuctionItemBean item, int role){
		if (!item.isOpen()){//reserve price was not met until closing time. owner can choose accept or reject the highest bid
			System.out.println("reserve price wasn't met until closing time");
			if (role==1){
				if (this.isOnline){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "reserve price wasn't met until closing time");
				}
				else {
					System.out.println("not online, send email only to owner");
				}
				sendemail(this.getEmail());
			}
			else {
				if (this.isOnline){
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "Your bid has reached its closing time. Wait for the owner to accept/reject your bid");
				}
				else {
					System.out.println("not online, send email only to bidder");
				}
				sendemail(this.getEmail());
			}
		}
		else {//there's a bidder who bid >= reserve price before closing time
			
		}
	}
	
	public void sendemail(String email){
		System.out.println("send email");
	/*	final String username = "christa.chiquita@gmail.com";
        final String password = "Rndyxta11";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("christa.chiquita@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("christa.chiquita@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }*/
    }
	
}