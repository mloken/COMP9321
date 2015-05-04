package business;

import java.util.ArrayList;

import beans.AuctionItemBean;

public interface AuctionService {
	
	AuctionItemBean getItemById(String id);
	
	AuctionItemBean addItem(AuctionItemBean item);
	
	void deleteItem(String id);

	ArrayList<AuctionItemBean> getItemBySearchKey(String searchKey);
	
	
}
