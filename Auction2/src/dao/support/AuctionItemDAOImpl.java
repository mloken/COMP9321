package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import common.DBConnectionFactory;
import common.ServiceLocatorException;
import beans.AddressBean;
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
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM TBL_ITEMS WHERE id = ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				AuctionItemBean contact = createAuctionItemBean(rs);
				stmt.close();
				return contact;
			}
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
	public ArrayList<AuctionItemBean> getAuctionItemBySearchKey(String searchKey) throws DataAccessException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<AuctionItemBean> list = new ArrayList<AuctionItemBean>() ;
		try {
			
			con = services.createConnection();
			stmt = con.prepareStatement("SELECT * FROM TBL_ITEMS WHERE UPPER(CATEGORY) LIKE UPPER(?) OR UPPER(ITEM_NAME) LIKE UPPER(?) OR UPPER(DESCRIPTION) LIKE UPPER(?)");
			stmt.setString(1, "%"+searchKey+"%");
			stmt.setString(2, "%"+searchKey+"%");
			stmt.setString(3, "%"+searchKey+"%");
			rs = stmt.executeQuery();
			while (rs.next())
				list.add(createAuctionItemBean(rs));
			
		} catch (ServiceLocatorException e) {
			throw new DataAccessException("Unable to retrieve connection; "
					+ e.getMessage(), e);
		} catch (SQLException e) {
			throw new DataAccessException("Unable to execute query; "
					+ e.getMessage(), e);
		} finally {
			
			if (con != null) {
				try {
					stmt.close();
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return list;
	}
	
	@Override
	public void deleteAuctionItemById(String id) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("delete from tbl_items where id = ?");
			stmt.setString(1, id);
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not delete one row from database");
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
	}

	public AuctionItemBean addAuctionItem(AuctionItemBean item) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("insert into tbl_items (id, owner_id, item_name, category, description, picture, streetAddress, city, state, country, postalCode, reservePrice, biddingStartPrice, biddingIncrements, bidPrice, endTime, notes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, item.getId());
			stmt.setInt(2, item.getOwnerId());
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
		return item;
	}
	
	private AuctionItemBean createAuctionItemBean(ResultSet rs) throws SQLException {
		AuctionItemBean item = new AuctionItemBean();
		item.setId(rs.getString("id"));
		item.setOwnerId(rs.getInt("owner_id"));
		item.setItemName(rs.getString("item_name"));
		item.setCategory(rs.getString("category"));
		item.setDescription(rs.getString("description"));
		item.setPicture(rs.getString("picture"));
		AddressBean addr = new AddressBean();
		addr.setStreetAddress(rs.getString("streetAddress"));
		addr.setCity(rs.getString("city"));
		addr.setState(rs.getString("state"));
		addr.setCountry(rs.getString("country"));
		addr.setPostalCode(rs.getString("postalCode"));
		item.setAddress(addr);
		item.setReservePrice(rs.getFloat("reservePrice"));
		item.setBiddingStartPrice(rs.getFloat("biddingStartPrice"));
		item.setBiddingIncrements(rs.getFloat("biddingIncrements"));
		item.setCurrentBid(rs.getFloat("bidPrice"));
		item.setEndTime(rs.getDate("endTime"));
		item.setNotes(rs.getString("notes"));
		return item;
	}
}