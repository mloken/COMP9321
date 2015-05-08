package business;

import java.util.ArrayList;
import java.util.List;

import beans.AuctionItemBean;

public interface AuctionService {
	
	AuctionItemBean getItemById(String id);
	
	AuctionItemBean getItemByIdALL(String id);
	
	AuctionItemBean addItem(AuctionItemBean item);
	
	void deleteItem(String id);
	
	AuctionItemBean updatePriceToZero(AuctionItemBean item);

	ArrayList<AuctionItemBean> getItemBySearchKey(String searchKey);
	
	ArrayList<AuctionItemBean> getAllAuctionItems();
	
	ArrayList<AuctionItemBean> getAllActiveAuctionItems();
	
	List<AuctionItemBean> getTenRandomAuctionItems();
}
