package dao;

import java.util.ArrayList;

import beans.AuctionItemBean;

public interface AuctionItemDAO {
	
	AuctionItemBean getAuctionItemById(String id);
	
	AuctionItemBean getAuctionItemByIdALL(String id);
	
	AuctionItemBean addAuctionItem(AuctionItemBean item);
	
	AuctionItemBean deleteAuctionItemById(String id);

	ArrayList<AuctionItemBean> getAuctionItemBySearchKey(String searchKey);
	
	AuctionItemBean updatePriceToZero(AuctionItemBean item);
	
	ArrayList<AuctionItemBean> getAllAuctionItems();
	
	boolean haltAuctionItemById(String id);
	
	boolean unhaltAuctionItemById(String id);

	ArrayList<AuctionItemBean> getAllAuctionItemsByOwner(int uid);
	
}