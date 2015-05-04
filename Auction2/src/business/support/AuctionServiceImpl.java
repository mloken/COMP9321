package business.support;

import java.util.ArrayList;

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
	public void deleteItem(String id) {
		auctionItemDao.deleteAuctionItemById(id);
	}
}
