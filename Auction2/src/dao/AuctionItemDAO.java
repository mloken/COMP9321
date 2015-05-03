package dao;

import beans.AuctionItemBean;

public interface AuctionItemDAO {
	AuctionItemBean getAuctionItemById(String id);
	AuctionItemBean deleteAuctionItemById(String id);
}
