package business.support;

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
		// TODO Auto-generated method stub
		return null;
	}
}
