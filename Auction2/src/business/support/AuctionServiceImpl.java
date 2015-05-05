package business.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import dao.AuctionItemDAO;
import dao.support.AuctionItemDAOImpl;
import beans.AuctionItemBean;
import business.AuctionService;

public class AuctionServiceImpl implements AuctionService{

	private AuctionItemDAO auctionItemDao;
	
	public AuctionServiceImpl(){
		auctionItemDao = new AuctionItemDAOImpl();
	}
	
	@Override
	public AuctionItemBean addItem(AuctionItemBean item) {
		AuctionItemBean addedItem = auctionItemDao.addAuctionItem(item);
		return addedItem;
	}

	@Override
	public AuctionItemBean getItemById(String id) {
		AuctionItemBean item = auctionItemDao.getAuctionItemById(id);
		return item;
	}

	@Override
	public ArrayList<AuctionItemBean> getItemBySearchKey(String searchKey) {
		ArrayList<AuctionItemBean> searchResults = auctionItemDao.getAuctionItemBySearchKey(searchKey);
		return searchResults;
	}
	
	@Override
	public ArrayList<AuctionItemBean> getAllAuctionItems() {
		ArrayList<AuctionItemBean> allItems = auctionItemDao.getAllAuctionItems();
		return allItems;
	}
	
	@Override
	public List<AuctionItemBean> getTenRandomAuctionItems() {
		ArrayList<AuctionItemBean> allItems = getAllAuctionItems();
		List<AuctionItemBean> shuffledItems = new LinkedList<AuctionItemBean>(allItems);
		Collections.shuffle(shuffledItems);
		return shuffledItems.subList(0, 10);
	}
	
	@Override
	public void deleteItem(String id) {
		auctionItemDao.deleteAuctionItemById(id);
	}

}
