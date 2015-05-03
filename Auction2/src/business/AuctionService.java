package business;

import beans.AuctionItemBean;

public interface AuctionService {
	
	AuctionItemBean getItemById(String id);
	
	AuctionItemBean addItem(AuctionItemBean item);
	
	void deleteItem(String id);
	
	
}
