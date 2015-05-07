package dao;

import java.util.ArrayList;

import beans.AuctionItemBean;

public interface AuctionItemDAO {
	
	AuctionItemBean getAuctionItemById(String id);
	
	AuctionItemBean addAuctionItem(AuctionItemBean item);
	
	AuctionItemBean deleteAuctionItemById(String id);

	ArrayList<AuctionItemBean> getAuctionItemBySearchKey(String searchKey);
	
	AuctionItemBean updatePriceToZero(AuctionItemBean item);
	
	ArrayList<AuctionItemBean> getAllAuctionItems();
	
}