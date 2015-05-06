package dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.AddressBean;
import beans.AuctionItemBean;
import beans.WishlistItemBean;
import common.DBConnectionFactory;
import common.ServiceLocatorException;
import dao.DataAccessException;
import dao.GenericDAO;
import dao.WishlistDAO;

public class WishlistDAOImpl extends GenericDAO implements WishlistDAO{

	public WishlistDAOImpl() {
		super();
	}

	public WishlistDAOImpl(DBConnectionFactory services) {
		super(services);
	}
	
	public ArrayList<WishlistItemBean> getWishlistFromUserId(int userId){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		ArrayList<WishlistItemBean> list = new ArrayList<WishlistItemBean>() ;
		try {
			con = services.createConnection();
			stmt = con.prepareStatement("SELECT * FROM TBL_WISHLIST WHERE user_id = ?");
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			while (rs.next())
				list.add(createWishlistItem(rs));
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
	public WishlistItemBean addToWishlist(WishlistItemBean item) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO TBL_WISHLIST (item_id, user_id) values (?, ?)");
			stmt.setString(1, item.getItemId());
			stmt.setInt(2, item.getUserId());
			
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not insert row into database");
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
	
	public WishlistItemBean deleteWishlistItemById(int id){
		Connection con = null;
		WishlistItemBean deletedItem = getWishlistItemFromId(id);
		try {
			con = services.createConnection();
			PreparedStatement stmt = con
					.prepareStatement("DELETE FROM TBL_WISHLIST where id = ?");
			stmt.setInt(1, id);
			int n = stmt.executeUpdate();
			if (n != 1)
				throw new DataAccessException(
						"Did not delete row from database");
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
		return deletedItem;
	}
	
	private WishlistItemBean getWishlistItemFromId(int id) {
		Connection con = null;
		try {
			con = services.createConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM TBL_WISHLIST WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				WishlistItemBean item = createWishlistItem(rs);
				stmt.close();
				return item;
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

	private WishlistItemBean createWishlistItem(ResultSet rs) throws SQLException{
		WishlistItemBean item = new WishlistItemBean();
		item.setId(rs.getInt("id"));
		item.setItemId(rs.getString("item_id"));
		item.setUserId(rs.getInt("user_id"));
		return item;
	}
}
