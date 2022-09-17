package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cafeItems.Item;

public class ItemsTable extends DatabaseConnect{
	/**
	 Columns:
	 ID integer PK
	 Name varchar(45)
	 Quantity integer
	 Price decimal(10,2)
	 */
	
	/**
	 * Add an item
	 */
	public static void addItem(Item i) {
		try(Connection con = getConnection();) {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Items");
			
				rs.next();
				rs.moveToInsertRow();
				
				rs.updateInt("ID", i.getID());
				rs.updateString("Name", i.getName());
				rs.updateInt("Quantity", 0);
				rs.updateDouble("Price", i.getPrice());
				rs.insertRow();
				
				rs.close();
				stmt.close();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	/**
	 * Delete an item
	 */
	public static void removeItem(Item i) {
		try(Connection con = getConnection();) {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT* FROM Items WHERE ID = "+i.getID());
			
				rs.next();
				rs.deleteRow();
			
			rs.close();
			stmt.close();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	/**
	 * Update the price of a give Item
	 */
	public static void updatePrice(Item i, double price) {
		String query = "UPDATE Items SET Price = "+price+" WHERE ID = "+i.getID();
		
		try(Connection con = getConnection();) {
			
			Statement stmt = con.createStatement();
			int affected = stmt.executeUpdate(query);
			
			stmt.close();
			if(affected == 1) {
				return;
			}
			throw new SQLException();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	/**
	 * Update the quantity of a give Item
	 */
	public static void updateQuantity(Item i, int quantity) {
		
		try(Connection con = getConnection();) {
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Items WHERE ID = "+i.getID());
				rs.next();
				//	int currentQuantity = rs.getInt("Quantity");
					rs.updateInt("Quantity", quantity);
					rs.updateRow();

			rs.close();
			stmt.close();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	
	/**
	 * Get the quantity of a give Item
	 */
	public static int getQuantity(int itemNo) {
		
		try(Connection con = getConnection();) {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Quantity"
											+ " FROM Items"
											+ " WHERE ID = "+itemNo);
				rs.next();
				int quantity = rs.getInt("quantity");

			rs.close();
			stmt.close();
			
			return quantity;
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return 0;
		}
	}
	
	
	
}
