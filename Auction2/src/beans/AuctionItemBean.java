package beans;

import java.util.Date;

public class AuctionItemBean {
	public AuctionItemBean() {
		super();
	}
	private String title;
	private String category;
	private String picture;
	private String description;
	private AddressBean postalAddress;
	private double reservePrice;
	private double biddingStartPrice;
	private double biddingIncrements;
	private Date endTime;
	private String id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String pictureURL) {
		this.picture = pictureURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AddressBean getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(AddressBean postalAddress) {
		this.postalAddress = postalAddress;
	}
	public double getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}
	public double getBiddingStartPrice() {
		return biddingStartPrice;
	}
	public void setBiddingStartPrice(double biddingStartPrice) {
		this.biddingStartPrice = biddingStartPrice;
	}
	public double getBiddingIncrements() {
		return biddingIncrements;
	}
	public void setBiddingIncrements(double biddingIncrements) {
		this.biddingIncrements = biddingIncrements;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
