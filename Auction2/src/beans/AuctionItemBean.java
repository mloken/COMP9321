package beans;

import java.util.Date;

public class AuctionItemBean {
	public AuctionItemBean() {
		super();
	}
	private String id;
	private String ownerId;
	private String itemName;
	private String category;
	private String picture;
	private String description;
	private AddressBean Address;
	private float reservePrice;
	private float biddingStartPrice;
	private float biddingIncrements;
	private float currentBid;
	private Date endTime;
	private String notes;
	
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public float getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(float reservePrice) {
		this.reservePrice = reservePrice;
	}
	public float getBiddingStartPrice() {
		return biddingStartPrice;
	}
	public void setBiddingStartPrice(float biddingStartPrice) {
		this.biddingStartPrice = biddingStartPrice;
	}
	public float getBiddingIncrements() {
		return biddingIncrements;
	}
	public void setBiddingIncrements(float biddingIncrements) {
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
	public AddressBean getAddress() {
		return Address;
	}
	public void setAddress(AddressBean address) {
		Address = address;
	}
	public float getCurrentBid() {
		return currentBid;
	}
	public void setCurrentBid(float currentBid) {
		this.currentBid = currentBid;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
