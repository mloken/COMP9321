package business;

import java.util.ArrayList;
import java.util.List;

import beans.AuctionItemBean;

public interface AuctionService {
	
	AuctionItemBean getItemById(String id);
	
	AuctionItemBean addItem(AuctionItemBean item);
	
	void deleteItem(String id);

	ArrayList<AuctionItemBean> getItemBySearchKey(String searchKey);
	
	ArrayList<AuctionItemBean> getAllAuctionItems();
	
	List<AuctionItemBean> getTenRandomAuctionItems();
}
