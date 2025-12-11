package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemsDAO;
import com.tap.model.OrderItems;
import com.tap.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemsDAO{
	private static final String INSERT_ORDERITEM="Insert into orderitem(orderid,itemname,menuid,totalprice)"
			+"values(?,?,?,?)";
	private static final String UPDATE_ORDERITEM="Update orderitem set itemname=? where orderitemid=?";
	private static String GET_ORDERITEM="select * from orderitem where orderitemid=?";
	private static String DELETE_ORDERITEM="Delete from orderitem where orderitemid=?";
	private static String GET_ALL_ITEMS="select * from orderitem";

	@Override
	public void addOrderItem(OrderItems orderitem) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(INSERT_ORDERITEM);) {
			statement.setInt(1,orderitem.getOrderid());
			statement.setString(2,orderitem.getItemname());
			statement.setInt(3,orderitem.getMenuid());
			statement.setDouble(4,orderitem.getTotalprice());
		
			int res=statement.executeUpdate();
			System.out.println(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public OrderItems getOrderItems(int orderitemid) {
		OrderItems orderitem=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ORDERITEM);){
			statement.setInt(1, orderitemid);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
								
			    int itemid=res.getInt("orderitemid");
			    int orderid=res.getInt("orderid");
			    String itemname=res.getString("itemname");
			    int menuid=res.getInt("menuid");
			    double totalprice=res.getDouble("totalprice");
				orderitem= new OrderItems(itemid,orderid,itemname,menuid,totalprice);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orderitem;
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		ArrayList<OrderItems> orderItemsList=new ArrayList<OrderItems>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ALL_ITEMS);){
			
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
			    int itemid=res.getInt("orderitemid");
			    int orderid=res.getInt("orderid");
			    String itemname=res.getString("itemname");
			    int menuid=res.getInt("menuid");
			    double totalprice=res.getDouble("totalprice");
				
				OrderItems items= new OrderItems(itemid,orderid,itemname,menuid,totalprice);
				orderItemsList.add(items);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderItemsList;
	}

	@Override
	public void updateOrderItem(OrderItems orderitem) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_ORDERITEM);){
			
			
			statement.setString(1,orderitem.getItemname());
			
			int res=statement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderitem(int orderitemid) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_ORDERITEM);){
			
			statement.setInt(1,orderitemid);
			
			int res=statement.executeUpdate();
			System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	

}
