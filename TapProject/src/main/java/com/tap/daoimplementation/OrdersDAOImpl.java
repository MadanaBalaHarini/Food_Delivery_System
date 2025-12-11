package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
//import java.sql.Timestamp;
import java.util.List;

import com.tap.dao.OrdersDAO;
import com.tap.model.Orders;
import com.tap.utility.DBConnection;

public class OrdersDAOImpl implements OrdersDAO {
	private static final String INSERT_ORDER="Insert into orders(orderdate, restaurantid, userid, totalamount, paymentmethod, status, deliveryaddress)"
			+"values(?,?,?,?,?,?,?)";
	private static final String GET_ORDER="select * from orders where orderid=?";
	private static final String DELETE_ORDER="delete from orders where orderid=?";
	private static String GET_ALL="select * from orders";
	private static final String UPDATE_ORDER="Update orders set restaurantid=?,status=?,deliveryaddress=? where orderid=?";

	@Override
	public int addOrder(Orders order) {
		int orderId=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);) {
			//statement.setTimestamp(1,new Timestamp(System.currentTimeMillis()));

			statement.setTimestamp(1, new Timestamp(order.getOrderdate().getTime()));
			statement.setInt(2, order.getRestaurantid()); 
			statement.setInt(3, order.getUserid()); 
			statement.setDouble(4, order.getTotalamount());
			statement.setString(5, order.getPaymentmethod()); 
			statement.setString(6, order.getStatus());
			statement.setString(7, order.getDeliveryaddress()); 

			
			//int res=statement.executeUpdate();
			//System.out.println(res);
			
//			int affectedRows=statement.executeUpdate();
//			if(affectedRows ==0) {
//				throw new SQLException("Creating order failed,no rows affected.");
//			}
//			ResultSet ids= statement.getGeneratedKeys();
//			
//			while(ids.next()) {
//				orderId = ids.getInt("1");
//			}
			
	        int affectedRows = statement.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating order failed, no rows affected.");
	        }

	        try (ResultSet ids = statement.getGeneratedKeys()) {
	            if (ids.next()) {
	                orderId = ids.getInt(1);
	            }
	        }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
		
	}

	@Override
	public Orders getOrder(int orderId) {
		Orders order=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ORDER);){
			statement.setInt(1, orderId);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("orderid");
				Date date=res.getTimestamp("orderdate");
				int restaurantid=res.getInt("restaurantid");
				int userid=res.getInt("userid");
				double totalamount=res.getDouble("totalamount");
				String paymentmethod=res.getString("paymentmethod");
				String status=res.getString("status");
				String deliveryaddress=res.getString("deliveryaddress");
				order = new  Orders(id,date,restaurantid,userid,totalamount,paymentmethod,status,deliveryaddress);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Orders> getAllorders() {
		ArrayList<Orders> ordersList=new ArrayList<Orders>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ALL);){
			
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("orderid");
				Date date=res.getTimestamp("orderdate");
				int restaurantid=res.getInt("restaurantid");
				int userid=res.getInt("userid");
				double totalamount=res.getDouble("totalamount");
				String paymentmethod=res.getString("paymentmethod");
				String status=res.getString("status");
				String deliveryaddress=res.getString("deliveryaddress");
				Orders order = new  Orders(id,date,restaurantid,userid,totalamount,paymentmethod,status,deliveryaddress);
				ordersList.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	@Override
	public void updateOrder(Orders order) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_ORDER);){
			
			
			statement.setInt(1,order.getRestaurantid());
			statement.setString(2,order.getStatus());
			statement.setString(3,order.getDeliveryaddress());
			
			int res=statement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_ORDER);){
			
			statement.setInt(1,orderId);
			
			int res=statement.executeUpdate();
			System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
