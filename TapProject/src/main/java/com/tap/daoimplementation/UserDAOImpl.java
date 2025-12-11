package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class UserDAOImpl implements UserDAO{

	private static final String INSERT_USER="Insert into user(username,email,phonenumber,password,address,role)"
												+"values(?,?,?,?,?,?)";
	private static final String UPDATE_USER="Update user set username=?,email=?,phonenumber=?,password=?,address=? where userid=?";
	private static String GET_USER="select * from user where userid=?";
	private static String DELETE_USER="Delete from user where userid=?";
	private static String GET_ALL_USERS="select * from user";
	private static String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
	@Override
	public int addUser(User user) {
		int res=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(INSERT_USER);) {
			//statement.setInt(1,user.getUserId());
			statement.setString(1,user.getUserName());
			statement.setString(2,user.getEmail());
			statement.setString(3,user.getPhoneNumber());
			statement.setString(4,user.getPassword());
			statement.setString(5,user.getAddress());
			statement.setString(6,user.getRole());
			//statement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
			//statement.setTimestamp(9,new Timestamp(System.currentTimeMillis()));
			
			
			 res=statement.executeUpdate();
			System.out.println(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public User getUser(int userId) {
		User user=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_USER);){
			statement.setInt(1, userId);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("userid");
				String name=res.getString("username");
				String email=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				
				user= new User(id,name,email,phonenumber,password,address,role);

			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		ArrayList<User> usersList=new ArrayList<User>();
		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_ALL_USERS);){
			
			ResultSet res=statement.executeQuery();
			
			while(res.next())
			{
				int id=res.getInt("userid");
				String name=res.getString("username");
				String email=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				
				User user= new User(id,name,email,phonenumber,password,address,role);
				usersList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usersList;
	}

	@Override
	public void updateUser(User user) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_USER);){
			
			
			statement.setString(1,user.getUserName());
			statement.setString(2,user.getEmail());
			statement.setString(3,user.getPhoneNumber());
			statement.setString(4,user.getPassword());
			statement.setString(5,user.getAddress());
			statement.setInt(6,user.getUserId());
			
			int res=statement.executeUpdate();
			System.out.println(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int userId) {

		
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_USER);){
			
			statement.setInt(1,userId);
			
			int res=statement.executeUpdate();
			System.out.println(res);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByEmailId(String email)
	{
		User user=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_USER_BY_EMAIL);){
			
			statement.setString(1,email);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("userid");
				String name=res.getString("username");
				String mail=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				
				user= new User(id,name,mail,phonenumber,password,address,role);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}	 
}
