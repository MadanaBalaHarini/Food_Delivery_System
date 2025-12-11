package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO{
	private static final String INSERT_RESTAURANT="Insert into restaurant(restaurantid,restaurantname,address,rating,cuisine,deliverytime,isactive,imageurl,adminuserid)"
			+"values(?,?,?,?,?,?,?,?,?)";
	private static final String GET_RESTAURANT="select * from restaurant where restaurantid=?";
	private static final String DELETE_RESTAURANT="delete from restaurant where restaurantid=?";
	private static String GET_ALL_RESTAURANTS="select * from restaurant";
	private static final String UPDATE_RESTAURANT="Update restaurant set name=?,address=?,rating=?,cuisine=?,deliverytime=? where restaurantid=?";
	@Override
	public void addRestaurant(Restaurant restaurant) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(INSERT_RESTAURANT);) {
			statement.setInt(1,restaurant.getRestaurantid());
			statement.setString(2,restaurant.getRestaurantname());
			statement.setString(3,restaurant.getAddress());
			statement.setDouble(4,restaurant.getRating());
			statement.setString(5,restaurant.getCuisine());
			statement.setInt(6,restaurant.getDeliverytime());
			statement.setBoolean(7,restaurant.getIsactive());
			statement.setString(8,restaurant.getImageurl());
			statement.setInt(9,restaurant.getAdminuserid());
			
			
			int res=statement.executeUpdate();
			System.out.println(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Restaurant restaurant=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_RESTAURANT);){
			statement.setInt(1, restaurantId);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("restaurantid");
				String name=res.getString("restaurantname");
				String address=res.getString("address");
				double rating=res.getDouble("rating");
				String cuisine=res.getString("cuisine");
				int deliverytime=res.getInt("deliverytime");
				boolean active=res.getBoolean("isactive");
				String imageurl=res.getString("imageurl");
				int adminuserid=res.getInt("adminuserid");
				restaurant= new Restaurant(id,name,address,rating,cuisine,deliverytime,active,imageurl,adminuserid);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		ArrayList<Restaurant> restaurantsList=new ArrayList<Restaurant>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ALL_RESTAURANTS);){
			
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("restaurantid");
				String name=res.getString("restaurantname");
				String address=res.getString("address");
				double rating=res.getDouble("rating");
				String cuisine=res.getString("cuisine");
				int deliverytime=res.getInt("deliverytime");
				boolean active=res.getBoolean("isactive");
				String imageurl=res.getString("imageurl");
				int adminuserid=res.getInt("adminuserid");
				
				Restaurant restaurant= new Restaurant(id,name,address,rating,cuisine,deliverytime,active,imageurl,adminuserid);
				restaurantsList.add(restaurant);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantsList;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_RESTAURANT);){
			
			
			statement.setString(1,restaurant.getRestaurantname());
			statement.setString(2,restaurant.getAddress());
			statement.setDouble(3,restaurant.getRating());
			statement.setString(4,restaurant.getCuisine());
			statement.setInt(5,restaurant.getDeliverytime());
			
			int res=statement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_RESTAURANT);){
			
			statement.setInt(1,restaurantId);
			
			int res=statement.executeUpdate();
			System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
