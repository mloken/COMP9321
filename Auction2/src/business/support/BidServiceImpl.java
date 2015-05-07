package business.support;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import dao.BidDAO;
import dao.support.BidDAOImpl;
import beans.BidBean;
import business.BidService;

public class BidServiceImpl implements BidService{

	private BidDAO bidDao;
	
	public BidServiceImpl(){
		bidDao = new BidDAOImpl();
	}
	
	@Override
	public BidBean addBidItem(BidBean item) {
		BidBean addedItem = bidDao.addBidItem(item);
		return addedItem;
	}
	
	@Override
	public BidBean updateBid(String itemid, int bidderid, Float price, Date date){
		BidBean updatedItem = bidDao.updateBid(itemid, bidderid, price, date);
		return updatedItem;
	}

	@Override
	public BidBean getBidItemById(String id) {
		BidBean item = bidDao.getBidItemById(id);
		return item;
	}

	@Override
	public ArrayList<BidBean> getAllBidItems() {
		ArrayList<BidBean> allItems = bidDao.getAllBidItems();
		return allItems;
	}
	
	@Override
	public void deleteBidItem(String id) {
		bidDao.deleteBidItemById(id);
	}
	
	public void deleteAllBidItems(){
		System.out.println("delete All Bid Items");
		bidDao.deleteAllBidItems();
	}
	
	public ArrayList<BidBean> getBidItemsByUser(int userid){
		return bidDao.getBidItemsByUser(userid);
	}

}
