package dao;

import java.util.ArrayList;
import java.util.Date;

import beans.BidBean;

public interface BidDAO {
	BidBean getBidItemById(String item_id);
	
	BidBean addBidItem(BidBean item);
	
	BidBean deleteBidItemById(String id);
	
	BidBean updateBid(String itemid, int bidderid, Float price, Date date);
	
	ArrayList<BidBean> getAllBidItems();
	
	BidBean deleteAllBidItems();
}
