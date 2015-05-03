package dao.support;

import common.DBConnectionFactory;

import dao.BidDAO;
import dao.GenericDAO;

public class BidDAOImpl extends GenericDAO implements BidDAO{

	public BidDAOImpl() {
		super();
	}

	public BidDAOImpl(DBConnectionFactory services) {
		super(services);
	}
	
}
