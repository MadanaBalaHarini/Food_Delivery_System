package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;

import com.tap.utility.DBConnection;

public class MenuDAOImpl implements MenuDAO{
	private static final String INSERT_MENU="Insert into menu(menuid,menuname,price,isavailable,description,imageurl,restaurantid)"
			+"values(?,?,?,?,?,?,?)";
	private static final String GET_MENU="select * from menu where menuid=?";
	private static final String DELETE_MENU="delete from menu where menuid=?";
	private static String GET_ALL="select * from menu";
	private static final String UPDATE_MENU="Update menu set menuname=?,price=?,isavailable=?,description=? where menuid=?";
	private static final String GET_RESTAURANTS_BY_RID="select * from menu where restaurantid=?";
	@Override
	public void addMenu(Menu menu) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(INSERT_MENU);) {
			statement.setInt(1,menu.getMenuid());
			statement.setString(2,menu.getMenuname());
			statement.setDouble(3,menu.getPrice());
			statement.setBoolean(4,menu.getIsavailable());
			statement.setString(5,menu.getDescription());
			statement.setString(6,menu.getImageurl());
			statement.setInt(7,menu.getRestaurantid());
			
			
			int res=statement.executeUpdate();
			System.out.println(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {

		Menu menu=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_MENU);){
			statement.setInt(1, menuId);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("menuid");
				String name=res.getString("menuname");
				double price=res.getDouble("price");
				boolean isavailable=res.getBoolean("isavailable");
				String description=res.getString("description");
				String imageurl=res.getString("imageurl");
				int restaurantid=res.getInt("restaurantid");

				menu= new Menu(id,name,price,isavailable,description,imageurl,restaurantid);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ALL);){
			
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("menuid");
				String name=res.getString("menuname");
				double price=res.getDouble("price");
				boolean isavailable=res.getBoolean("isavailable");
				String description=res.getString("description");
				String imageurl=res.getString("imageurl");
				int restaurantid=res.getInt("restaurantid");
				
				Menu menu= new Menu(id,name,price,isavailable,description,imageurl,restaurantid);
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public void updateMenu(Menu menu) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_MENU);){
			
			
			statement.setString(1,menu.getMenuname());
			statement.setDouble(2,menu.getPrice());
			statement.setBoolean(3,menu.getIsavailable());
			statement.setString(4,menu.getDescription());
		
			int res=statement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_MENU);){
			
			statement.setInt(1,menuId);
			
			int res=statement.executeUpdate();
			System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId)
	{
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_RESTAURANTS_BY_RID);){
			statement.setInt(1, restaurantId);
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("menuid");
				String name=res.getString("menuname");
				double price=res.getDouble("price");
				boolean isavailable=res.getBoolean("isavailable");
				String description=res.getString("description");
				String imageurl=res.getString("imageurl");
				int restaurantid=res.getInt("restaurantid");
				
				Menu menu= new Menu(id,name,price,isavailable,description,imageurl,restaurantid);
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}
}
