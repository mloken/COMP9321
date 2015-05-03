package dao;

import beans.AuctionItemBean;

public interface AuctionItemDAO {
	
	AuctionItemBean getAuctionItemById(String id);
	
	AuctionItemBean addAuctionItem(AuctionItemBean item);
	
	void deleteAuctionItemById(String id);
	
}