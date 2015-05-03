package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionFactory;
import common.ServiceLocatorException;
import beans.AuctionItemBean;
import dao.AuctionItemDAO;
import dao.DataAccessException;
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

	public AuctionItemBean createAuctionItemBean(AuctionItemBean item) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("insert into tbl_items (id, owner_id, item_name, category, description, picture, streetAddress, city, state, country, postalCode, reservePrice, biddingStartPrice, biddingIncrements, bidPrice, endTime, notes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, item.getId());
			stmt.setString(2, item.getOwnerId());
			stmt.setString(3, item.getItemName());
			stmt.setString(4, item.getCategory());
			stmt.setString(5, item.getDescription());
			stmt.setString(6, item.getPicture());
			stmt.setString(7, item.getAddress().getStreetAddress());
			stmt.setString(8, item.getAddress().getCity());
			stmt.setString(9, item.getAddress().getState());
			stmt.setString(10, item.getAddress().getCountry());
			stmt.setString(11, item.getAddress().getPostalCode());
			stmt.setFloat(12, item.getReservePrice());
			stmt.setFloat(13, item.getBiddingStartPrice());
			stmt.setFloat(14, item.getBiddingIncrements());
			stmt.setFloat(15, item.getCurrentBid());
			java.sql.Date sqlDate = new java.sql.Date(item.getEndTime()
					.getTime());
			stmt.setDate(16, sqlDate);
			stmt.setString(17, item.getNotes());

			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not insert one row into database");
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public AuctionItemBean addAuctionItem(AuctionItemBean item) {
		// TODO Auto-generated method stub
		return null;
	}
}