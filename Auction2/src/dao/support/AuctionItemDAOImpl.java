package dao.support;

import java.sql.ResultSet;

import common.DBConnectionFactory;
import beans.AuctionItemBean;
import dao.AuctionItemDAO;
import dao.GenericDAO;

public class AuctionItemDAOImpl extends GenericDAO implements AuctionItemDAO {

	public AuctionItemDAOImpl() {
		super();
	}

	public AuctionItemDAOImpl(DBConnectionFactory services) {
		super(services);
	}

	@Override
	public AuctionItemBean getAuctionItemById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuctionItemBean deleteAuctionItemById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private AuctionItemBean createAuctionItemBean(ResultSet rs) {
		return null;
	}

	@Override
	public AuctionItemBean addAuctionItem(AuctionItemBean item) {
		// TODO Auto-generated method stub
		return null;
	}
}