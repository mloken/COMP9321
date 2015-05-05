package beans;

import java.util.ArrayList;

public class WishListBean {
	private ArrayList<AuctionItemBean> auctionItems;

	public WishListBean(){ auctionItems = new ArrayList<AuctionItemBean>();}
	
	public void setAuctionItems(ArrayList<AuctionItemBean> auctionItems) {
		this.auctionItems = auctionItems;
	}
	public ArrayList<AuctionItemBean> getAuctionItems() {
		return auctionItems;
	}

	public boolean addAuctionItem(AuctionItemBean auctionItem){return auctionItems.add(auctionItem);}

	public boolean isEmpty(){
		if (auctionItems.size()==0)
			return true;
		else
			return false;
	}
	public void removeAuctionItem(AuctionItemBean item) {
		auctionItems.remove(item);
	}
}
