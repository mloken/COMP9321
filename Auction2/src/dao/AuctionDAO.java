package dao;

import beans.AuctionItemBean;

public interface AuctionDAO {
	AuctionItemBean getAuctionItemById(String id);
	AuctionItemBean deleteAuctionItemById(String id);
}
