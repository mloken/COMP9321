package dao;

import java.util.ArrayList;

import beans.AuctionItemBean;

public interface AuctionItemDAO {
	
	AuctionItemBean getAuctionItemById(String id);
	
	AuctionItemBean addAuctionItem(AuctionItemBean item);
	
	void deleteAuctionItemById(String id);

	ArrayList<AuctionItemBean> getAuctionItemBySearchKey(String searchKey);
	
	ArrayList<AuctionItemBean> getAllAuctionItems();
	
}