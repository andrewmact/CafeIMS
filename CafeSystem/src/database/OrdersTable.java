package database;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import cafeItems.Item;

public class OrdersTable extends DatabaseConnect{

	/**

	orderID int PK
	itemID int
	quantity int
	orderDate datetime
	
	**/
	
	public static int orderItem(Item i, int quantity) {
		try(Connection con = getConnection();) {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
			
			rs.moveToInsertRow();
			rs.updateInt("itemID", i.getID());
			rs.updateInt("quantity", quantity);
			Date today = Date.valueOf(LocalDate.now());
			rs.updateDate("orderDate", today);
			int orderNumber = rs.getInt("orderID");
			rs.insertRow();
			
			
			rs.close();
			stmt.close();
			
			return orderNumber;
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return -1;
		}
	}
	
	public static void checkOrder(Item i) {
		try(Connection con = getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE itemID = "+i.getID());
			
			System.out.println(i.getName()+" Order list");
		
			while(rs.next()) {
				int orderId = rs.getInt("orderID");
				int quantity = rs.getInt("quantity");
				Date orderDate = rs.getDate("orderDate");
				
				System.out.println("Order ID:"+orderId+" Quantity:"+quantity+" Order Date:"+orderDate);
			}
			
			rs.close();
			stmt.close();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	
	public static void checkOrder(int orderNumber) {
		try(Connection con = getConnection();) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE orderID = "+orderNumber);
			
			rs.next();
			int orderId = rs.getInt("orderID");
			int orderNo = rs.getInt("itemID");
			int quantity = rs.getInt("quantity");
			Date orderDate = rs.getDate("orderDate");
			
			System.out.println("Order ID:"+orderId+" Item No:"+orderNo+" Quantity:"+quantity+" Order Date:"+orderDate);
			
			rs.close();
			stmt.close();
		} 
		catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}
	
	
}
